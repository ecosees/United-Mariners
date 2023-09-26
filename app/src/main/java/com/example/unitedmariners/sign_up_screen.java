package com.example.unitedmariners;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class sign_up_screen extends AppCompatActivity {
  EditText et_user_name,s_et_email,s_et_password,et_verify_password;
  TextView s_tv_login;
  Button btn_signup,s_btn_login;
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
  }
}
