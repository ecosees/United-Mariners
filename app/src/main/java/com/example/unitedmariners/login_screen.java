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

public class login_screen extends AppCompatActivity {
  EditText et_email,et_password;
  TextView tv_forget_password;
  Button btn_login,btn_create_an_account,btn_facebook,btn_google;

  FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();


  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_login_scrren);

    et_email = findViewById(R.id.et_email);
    et_password = findViewById(R.id.et_password);

    tv_forget_password = findViewById(R.id.tv_forget_password);
    btn_login = findViewById(R.id.btn_login);
    btn_create_an_account = findViewById(R.id.btn_create_an_account);
    btn_google = findViewById(R.id.btn_google);



    btn_create_an_account.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        Intent intent = new Intent(getApplicationContext(), sign_up_screen.class);
        startActivity(intent);
      }
    });

    btn_login.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        String email, password;
        email = String.valueOf(et_email.getText());
        password = String.valueOf(et_password.getText());

        if (TextUtils.isEmpty(email)){
          Toast.makeText(login_screen.this,"Enter email",Toast.LENGTH_SHORT).show();
          return;
        }
        if (TextUtils.isEmpty(password)){
          Toast.makeText(login_screen.this,"enter password",Toast.LENGTH_SHORT).show();
          return;
        }

        firebaseAuth.createUserWithEmailAndPassword(email,password)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                  @Override
                  public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()){
                      Toast.makeText(login_screen.this,"login successful",Toast.LENGTH_SHORT).show();
                      Intent intent = new Intent(login_screen.this,MapsActivity.class);
                      startActivity(intent);
                      finish();
                    }
                    else {
                      Toast.makeText(login_screen.this,"failled",Toast.LENGTH_SHORT).show();

                    }
                  }
                });

      }
    });


  }
}
