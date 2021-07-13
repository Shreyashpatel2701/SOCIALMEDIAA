package com.example.socialmedia;

import androidx.appcompat.app.AppCompatActivity;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class MainActivity extends AppCompatActivity {
    FirebaseUser currentUser;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mAuth = FirebaseAuth.getInstance();
        if (mAuth == null){
            currentUser = mAuth.getCurrentUser();
        }
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                   FirebaseUser user = mAuth.getCurrentUser();
                   if (user == null){
                       Intent intent = new Intent(MainActivity.this,LoginActivity.class);
                       startActivity(intent);
                       finish();
                   }else {
                       Intent Homeintent = new Intent(MainActivity.this,Home_Activity.class);
                       Homeintent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                       startActivity(Homeintent);

                         finish();
                   }

            }
        },100);




    }
}