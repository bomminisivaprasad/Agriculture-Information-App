package com.muneiah.pureraithubazr;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


/**
 * A simple {@link Fragment} subclass.
 */
public class FormerRegiserFragment extends Fragment {

    // Write a message to the database
    FirebaseDatabase database ;
    DatabaseReference myRef ;
    TextInputLayout fname,femail,fnumber,fpassword,fcnf_password;
    Button farmerSaveBtn;
    RadioButton m,f;
FarmerPojo farmerPojo;

    public FormerRegiserFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_former_regiser, container, false);

        fname=v.findViewById(R.id.r_name);
        femail=v.findViewById(R.id.r_email);
        fnumber=v.findViewById(R.id.r_number);
        fcnf_password=v.findViewById(R.id.cnf_pass);
        fpassword=v.findViewById(R.id.f_newPass);
        m=v.findViewById(R.id.male);
        f=v.findViewById(R.id.female);
        farmerSaveBtn=v.findViewById(R.id.f_saveButtion);
        database = FirebaseDatabase.getInstance();
        myRef = database.getReference();

        farmerSaveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name=fname.getEditText().toString();
                String mail=femail.getEditText().toString();
                String number=fnumber.getEditText().toString();
                String np=fpassword.getEditText().toString();
                String cnf_np=fcnf_password.getEditText().toString();
                farmerPojo.setName(name);
                farmerPojo.setEmail(mail);
                farmerPojo.setMobile(number);
                if (np.equals(cnf_np)){
                    farmerPojo.setPassword(np);
                    farmerPojo.setPassword(cnf_np);
                }else {
                    Toast.makeText(getContext(), " password missmatch", Toast.LENGTH_SHORT).show();
                }
                farmerPojo=new FarmerPojo(name,mail,number,np,cnf_np);
                myRef.child("farmer").child(name).setValue(farmerPojo).addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Toast.makeText(getContext(), "success", Toast.LENGTH_SHORT).show();
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(getContext(), ""+e.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });

                Intent intent=new Intent(getContext(),MainActivity.class);
                startActivity(intent);

            }
        });

        /*myRef.setValue("Hello, World!");*/
        return v;
    }

}
