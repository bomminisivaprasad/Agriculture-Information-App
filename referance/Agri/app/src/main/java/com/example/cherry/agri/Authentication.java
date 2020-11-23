package com.example.cherry.agri;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;


import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.cherry.agri.databinding.ActivityAuthenticationBinding;
import com.example.cherry.agri.databinding.ActivityRegisterBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;


public class Authentication extends AppCompatActivity {
    ActivityAuthenticationBinding aBinding;
    ActivityRegisterBinding rBinding;
    FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_authentication);
        aBinding = DataBindingUtil.setContentView(this,R.layout.activity_authentication);
        auth = FirebaseAuth.getInstance();
    }

    public void login(View view) {
        String mail = aBinding.umail.getText().toString();
        String pass = aBinding.upass.getText().toString();
        if (mail.isEmpty()|pass.isEmpty()){
            Toast.makeText(this, "Please fill all the details", Toast.LENGTH_SHORT).show();
        }else{
            auth.signInWithEmailAndPassword(mail,pass).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()){
                        startActivity(new Intent(Authentication.this,MainActivity.class));
                        finish();
                    }
                    else{
                        Toast.makeText(Authentication.this, "Authentication Failed",
                                Toast.LENGTH_SHORT).show();
                    }
                }
            });
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
                    Toast.makeText(Authentication.this, "Cant be empty", Toast.LENGTH_SHORT).show();
                }else{
                    auth.sendPasswordResetEmail(mail).addOnCompleteListener(Authentication.this, new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if (task.isSuccessful()){
                                Toast.makeText(Authentication.this, "reset mail sent", Toast.LENGTH_SHORT).show();
                            }else{
                                Toast.makeText(Authentication.this, "reset failed"  , Toast.LENGTH_SHORT).show();
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
                    Toast.makeText(Authentication.this, "Please fill all details", Toast.LENGTH_SHORT).show();
                }else if(pass.length()<6){
                    rBinding.upass.setError("minimum 6 digits");
                }
                else if(!repass.equals(pass)){
                    rBinding.urepass.setError("password mismatch");
                }else{
                    auth.createUserWithEmailAndPassword(mail,pass).addOnCompleteListener(Authentication.this,new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()){
                                startActivity(new Intent(Authentication.this,MainActivity.class));
                                finish();
                            }else{
                                Toast.makeText(Authentication.this, "Registration Failed",
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