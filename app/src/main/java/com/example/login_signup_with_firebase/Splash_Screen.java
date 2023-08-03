package com.example.login_signup_with_firebase;

import static java.lang.Thread.sleep;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class Splash_Screen extends AppCompatActivity {
    ImageView imageView;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        init();
        Animation animation= AnimationUtils.loadAnimation(this,R.anim.animation);
        imageView.setAnimation(animation);
        textView.setAnimation(animation);
        Thread thread=new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    sleep(9000);
                    Intent intent=new Intent(getApplicationContext(),Login.class);
                    startActivity(intent);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        });
        thread.start();
    }
    public void init(){
        imageView=findViewById(R.id.img);
        textView=findViewById(R.id.txt);
    }
}