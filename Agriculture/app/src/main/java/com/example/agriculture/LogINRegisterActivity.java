package com.example.agriculture;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.example.agriculture.databinding.ActivityLogINRegisterBinding;
import com.example.agriculture.databinding.ActivityRegisterBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LogINRegisterActivity extends AppCompatActivity {

    ActivityLogINRegisterBinding aBinding;
    ActivityRegisterBinding rBinding;
    FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        aBinding = DataBindingUtil.setContentView(this,R.layout.activity_log_i_n_register);
        auth = FirebaseAuth.getInstance();
        if (auth.getCurrentUser()!=null){
            startActivity(new Intent(this,Home.class));
            finish();
        }
    }
    public boolean isConnected() {
        boolean connected = false;
        try {
            ConnectivityManager manager = (ConnectivityManager)getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo nInfo = manager.getActiveNetworkInfo();
            connected = nInfo != null && nInfo.isConnectedOrConnecting();
                    //nInfo.isAvailable() && nInfo.isConnected();
            return connected;
        } catch (Exception e) {

        }
        return connected;
    }


    public void login(View view) {
        String mail = aBinding.umail.getText().toString();
        String pass = aBinding.upass.getText().toString();
        if(isConnected()){
        if (mail.isEmpty()|pass.isEmpty()){
            Toast.makeText(this, "Please fill all the details", Toast.LENGTH_SHORT).show();
        }else{
            auth.signInWithEmailAndPassword(mail,pass).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()){
                        startActivity(new Intent(LogINRegisterActivity.this,Home.class));
                        finish();
                    }
                    else{
                        Toast.makeText(LogINRegisterActivity.this, "LogINRegisterActivity Failed",
                                Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }else{
            Snackbar.make(view,"No Internet Connected", Snackbar.LENGTH_LONG).show();
        }
    }

    public void reset(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        View v = LayoutInflater.from(this).inflate(R.layout.reset,null,false);
        final EditText email = v.findViewById(R.id.umail);
        builder.setView(v);
        builder.setCancelable(false);
        builder.setPositiveButton("Reset", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String mail = email.getText().toString();
                if (mail.isEmpty()){
                    Toast.makeText(LogINRegisterActivity.this, "Cant be empty", Toast.LENGTH_SHORT).show();
                }else{
                    auth.sendPasswordResetEmail(mail).addOnCompleteListener(LogINRegisterActivity.this, new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if (task.isSuccessful()){
                                Toast.makeText(LogINRegisterActivity.this, "reset mail sent", Toast.LENGTH_SHORT).show();
                            }else{
                                Toast.makeText(LogINRegisterActivity.this, "reset failed"  , Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }
            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        builder.show();
    }

    public void personRegister(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        rBinding = DataBindingUtil.inflate(LayoutInflater.from(this),R.layout.activity_register,null,false);
        builder.setView(rBinding.getRoot());
        builder.setCancelable(false);
        builder.setPositiveButton("Register", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                final String name = rBinding.uname.getText().toString();
                final String mail = rBinding.umail.getText().toString();
                final String number = rBinding.uphone.getText().toString();
                String pass = rBinding.upass.getText().toString();
                String repass = rBinding.urepass.getText().toString();
                if (name.isEmpty()|mail.isEmpty()|number.isEmpty()|pass.isEmpty()|repass.isEmpty()){
                    Toast.makeText(LogINRegisterActivity.this, "Please fill all details", Toast.LENGTH_SHORT).show();
                }else if(pass.length()<6){
                    rBinding.upass.setError("minimum 6 digits");
                }
                else if(!repass.equals(pass)){
                    rBinding.urepass.setError("password mismatch");
                }else{
                    auth.createUserWithEmailAndPassword(mail,pass).addOnCompleteListener(LogINRegisterActivity.this,new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()){
                                startActivity(new Intent(LogINRegisterActivity.this,Home.class));
                                finish();
                            }else{
                                Toast.makeText(LogINRegisterActivity.this, "Registration Failed",
                                        Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }
            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        builder.show();

    }
}