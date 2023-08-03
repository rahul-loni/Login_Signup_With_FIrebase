package com.example.login_signup_with_firebase;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.login_signup_with_firebase.databinding.ActivityLoginBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Login extends AppCompatActivity {
ActivityLoginBinding binding;
FirebaseAuth firebaseAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        firebaseAuth=FirebaseAuth.getInstance();

        binding.btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email=binding.txtEmail.getText().toString().trim();
                String password=binding.txtPassword.getText().toString().trim();

                if (email.isEmpty()){
                    Toast.makeText(Login.this, "Please Enter Email", Toast.LENGTH_SHORT).show();
                }
                if (password.isEmpty()){
                    Toast.makeText(Login.this, "Please Enter Password", Toast.LENGTH_SHORT).show();
                }
                firebaseAuth.signInWithEmailAndPassword(email,password)
                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()){
                                    Intent loginIntent=new Intent(getApplicationContext(),MainActivity.class);
                                    startActivity(loginIntent);
                                    finish();
                                    Toast.makeText(Login.this, "Login comp", Toast.LENGTH_SHORT).show();
                                }else {
                                    Toast.makeText(Login.this, "Login not comp", Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
            }
        });
    }
}