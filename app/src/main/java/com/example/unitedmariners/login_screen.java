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
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.unitedmariners.Models.users;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GoogleAuthProvider;
import com.google.firebase.database.FirebaseDatabase;

public class login_screen extends AppCompatActivity {
  EditText et_email,et_password;
  TextView tv_forget_password;
  Button btn_login,btn_create_an_account,btn_facebook,btn_google;

  private GoogleSignInClient client;

  FirebaseAuth mAuth ;

  FirebaseDatabase database;

  @Override
  public void onStart() {
    super.onStart();
    // Check if user is signed in (non-null) and update UI accordingly.
    FirebaseUser currentUser = mAuth.getCurrentUser();
    if(currentUser != null){
      Intent intent = new Intent(login_screen.this, MapsActivity.class);
      startActivity(intent);
      finish();
    }
  }

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_login_scrren);

    et_email = findViewById(R.id.et_email);
    et_password = findViewById(R.id.et_password);
    mAuth = FirebaseAuth.getInstance();

    tv_forget_password = findViewById(R.id.tv_forget_password);
    btn_login = findViewById(R.id.btn_login);
    btn_create_an_account = findViewById(R.id.btn_create_an_account);
    btn_google = findViewById(R.id.btn_google);

    mAuth = FirebaseAuth.getInstance();
    database = FirebaseDatabase.getInstance("https://ecosees-8e49a-default-rtdb.firebaseio.com/");

    GoogleSignInOptions options = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken(getString(R.string.default_web_client_id))
            .requestEmail()
            .build();

    client = GoogleSignIn.getClient(this, options);
    btn_google.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        Intent i = client.getSignInIntent();
        startActivityForResult(i, 123);
      }
    });

  }

    @Override
    protected void onActivityResult(int requestCode,int resultCode, @Nullable Intent data) {
      super.onActivityResult(requestCode, resultCode, data);

      if(requestCode==123){
        Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
        try {
          GoogleSignInAccount account = task.getResult(ApiException.class);

          AuthCredential credential = GoogleAuthProvider.getCredential(account.getIdToken(),null);
          mAuth.signInWithCredential(credential).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
            @Override
            public void onSuccess(AuthResult authResult) {
              if (task.isSuccessful()){
                FirebaseUser user = mAuth.getCurrentUser();
                users users1 = new users();
                assert user != null;
                users1.setUserName(user.getDisplayName());
                users1.setProfilePic(user.getPhotoUrl().toString());
                database.getReference().child("users").child(user.getUid()).setValue(users1);

                Intent intent = new Intent(login_screen.this,MapsActivity.class);
                intent.putExtra("userName",user.getDisplayName());
                intent.putExtra("ProfilePic",user.getPhotoUrl().toString());
                startActivity(intent);
              }
              else {
                Toast.makeText(login_screen.this,task.getException().getMessage(),Toast.LENGTH_SHORT).show();
              }

            }
          });

        } catch (ApiException e) {
          throw new RuntimeException(e);
        }
      }




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
  authLogin();
      }
    });
  }
  public void authLogin(){
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
    mAuth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
              @Override
              public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                  Toast.makeText(login_screen.this, "Login successful", Toast.LENGTH_SHORT).show();
                  Intent intent = new Intent(login_screen.this, MapsActivity.class);
                  startActivity(intent);
                  finish();

                } else {
                  Toast.makeText(login_screen.this, "Authentication failed.", Toast.LENGTH_SHORT).show();
                }
              }
            });


  }
}
