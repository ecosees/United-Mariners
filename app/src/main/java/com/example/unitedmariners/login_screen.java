package com.example.unitedmariners;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class login_screen extends AppCompatActivity {
  EditText et_email,et_password;
  TextView tv_forget_password;
  Button btn_login,btn_create_an_account,btn_facebook,btn_google;



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
    btn_login.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        Intent intent=new Intent(getApplicationContext(), MapsActivity.class);
        startActivity(intent);
      }
    });

  }
}
