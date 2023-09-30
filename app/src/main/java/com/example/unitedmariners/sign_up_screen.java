package com.example.unitedmariners;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
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

public class sign_up_screen extends AppCompatActivity {
  EditText et_user_name,s_et_email,s_et_password,et_verify_password;
  TextView s_tv_login;
  Button btn_signup,s_btn_login;

  FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_sign_up_screen);
    et_user_name = findViewById(R.id.et_user_name);
    s_et_email = findViewById(R.id.s_et_email);
    s_et_password = findViewById(R.id.s_et_password);
    et_verify_password = findViewById(R.id.et_verify_password);

    btn_signup = findViewById(R.id.btn_signup);
    s_tv_login = findViewById(R.id.s_tv_login);

    s_tv_login.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        Intent intent = new Intent(getApplicationContext(), login_screen.class);
        startActivity(intent);
      }
    });


    btn_signup.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        String email, password;
        email = String.valueOf(s_et_email.getText());
        password = String.valueOf(s_et_password.getText());

        if (TextUtils.isEmpty(email)){
          Toast.makeText(sign_up_screen.this,"Enter email",Toast.LENGTH_SHORT).show();
          return;
        }
        if (TextUtils.isEmpty(password)){
          Toast.makeText(sign_up_screen.this,"enter password",Toast.LENGTH_SHORT).show();
          return;
        }

        firebaseAuth.createUserWithEmailAndPassword(email,password)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                  @Override
                  public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()){
                      Toast.makeText(sign_up_screen.this,"login successful",Toast.LENGTH_SHORT).show();
                      Intent intent = new Intent(sign_up_screen.this,MapsActivity.class);
                      startActivity(intent);
                      finish();
                    }
                    else {
                      Toast.makeText(sign_up_screen.this,"failled",Toast.LENGTH_SHORT).show();

                    }
                  }
                });

      }
    });

  }
}
