package com.example.login_signup_with_firebase;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.login_signup_with_firebase.databinding.ActivityForgotPawwordBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class ForgotPawword extends AppCompatActivity {
    ActivityForgotPawwordBinding binding;
    FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityForgotPawwordBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        firebaseAuth=FirebaseAuth.getInstance();

        binding.btnSendEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email=binding.txtEmail.getText().toString().trim();
                if (email.isEmpty()){
                    Toast.makeText(ForgotPawword.this, "Please Enter Email", Toast.LENGTH_SHORT).show();
                }
                firebaseAuth.sendPasswordResetEmail(email)
                        .addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {
                             if (task.isSuccessful()){
                                 Toast.makeText(ForgotPawword.this, "Check Email", Toast.LENGTH_SHORT).show();
                             }
                            }
                        });
            }
        });
    }
}