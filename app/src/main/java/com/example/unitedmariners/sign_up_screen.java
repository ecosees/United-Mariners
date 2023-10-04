package com.example.unitedmariners;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class sign_up_screen extends AppCompatActivity {
  EditText et_user_name, s_et_email, s_et_password, et_verify_password;
  TextView s_tv_login;
  String name;
  Button btn_signup, s_btn_login;
  String email, password;
  FirebaseAuth mAuth;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_sign_up_screen);
    mAuth = FirebaseAuth.getInstance();
    et_user_name = findViewById(R.id.et_user_name);
    s_et_email = findViewById(R.id.s_et_email);
    s_et_password = findViewById(R.id.s_et_password);
    et_verify_password = findViewById(R.id.et_verify_password);
    btn_signup = findViewById(R.id.btn_signup);
    s_tv_login = findViewById(R.id.s_tv_login);

    s_tv_login.setOnClickListener(
        new View.OnClickListener() {
          @Override
          public void onClick(View view) {
            Intent intent = new Intent(getApplicationContext(), login_screen.class);
            startActivity(intent);
            finish();
          }
        });

    btn_signup.setOnClickListener(
        new View.OnClickListener() {
          @Override
          public void onClick(View view) {
            name = et_user_name.getText().toString();
            SharedPreferences sharedPreferences = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString("userName", name);
            editor.apply();
            auth();

          }
        });
  }

  public void auth() {
    String email, password;
    email = String.valueOf(s_et_email.getText());
    password = String.valueOf(s_et_password.getText());

    if (TextUtils.isEmpty(email)) {
      Toast.makeText(sign_up_screen.this, "Enter email", Toast.LENGTH_SHORT).show();
      return;
    }

    if (TextUtils.isEmpty(password)) {
      Toast.makeText(sign_up_screen.this, "Enter password", Toast.LENGTH_SHORT).show();
      return;
    }

    mAuth
        .createUserWithEmailAndPassword(email, password)
        .addOnCompleteListener(
            this,
            new OnCompleteListener<AuthResult>() {
              @Override
              public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                  Toast.makeText(sign_up_screen.this, "Account Created", Toast.LENGTH_SHORT).show();
                  Intent intent = new Intent(getApplicationContext(), MapsActivity.class);
                  intent.putExtra("key", name);
                  startActivity(intent);
                  finish();

                  finish();
                } else {
                  Toast.makeText(sign_up_screen.this, "Authentication failed.", Toast.LENGTH_SHORT)
                      .show();
                }
              }
            });
  }
}
