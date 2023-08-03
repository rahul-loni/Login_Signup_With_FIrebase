package com.example.login_signup_with_firebase;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.login_signup_with_firebase.databinding.ActivitySignupBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Signup extends AppCompatActivity {
ActivitySignupBinding binding;
FirebaseAuth firebaseAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivitySignupBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        firebaseAuth=FirebaseAuth.getInstance();

        binding.btnSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email=binding.txtEmail.getText().toString().trim();
                String password=binding.txtPassword.getText().toString().trim();
                String cPassword=binding.txtCPassword.getText().toString().trim();
                if (email.isEmpty()){
                    Toast.makeText(Signup.this, "Please Enter Email", Toast.LENGTH_SHORT).show();
                }if (password.isEmpty()){
                    Toast.makeText(Signup.this, "Please Enter Password", Toast.LENGTH_SHORT).show();
                }if (cPassword.equals(password)){
                   firebaseAuth.createUserWithEmailAndPassword(email,password)
                           .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                               @Override
                               public void onComplete(@NonNull Task<AuthResult> task) {
                                   if (task.isSuccessful()){
                                       Intent intent=new Intent(getApplicationContext(),MainActivity.class);
                                       startActivity(intent);
                                       finish();
                                       Toast.makeText(Signup.this, "Signup Comp", Toast.LENGTH_SHORT).show();
                                   }else {
                                       Toast.makeText(Signup.this, "Signup Not Comp", Toast.LENGTH_SHORT).show();
                                   }
                               }
                           });
                }else {
                    Toast.makeText(Signup.this, "Password or confirmPassword do not match", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}