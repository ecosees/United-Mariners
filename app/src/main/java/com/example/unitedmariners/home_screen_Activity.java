package com.example.unitedmariners;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.ArrayList;

public class home_screen_Activity extends AppCompatActivity implements ProfileFragment.Instance {
  RecyclerView rv;
  ImageButton menu_btn;
  String location, city, country, state, userName;
  ImageView photo;
  TextView srcFirst, txtName;
  TextView srcSecond;
  TextView srcThird;
  int general = -1;
  AlertDialog dialog;
  ArrayList<String> redSea = new ArrayList<>();
  ArrayList<String> whiteSea = new ArrayList<>();
  ArrayList<String> nile = new ArrayList<>();
  BottomNavigationView bottomNavigationView;
  SearchFragment searchFragment = new SearchFragment();
  CommunityFragment communityFragment = new CommunityFragment();
  ProfileFragment profileFragment = new ProfileFragment();
  resourcesFragment resourcesFrag = new resourcesFragment();
  BaseGameFragment baseGameFragment = new BaseGameFragment();
  FirebaseAuth auth;
  SharedPreferences sh;
  FirebaseUser user;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_home_screen);
    txtName = findViewById(R.id.tv_name);
    rv = findViewById(R.id.rv_home);
     TextView et_search = findViewById(R.id.et_search);
     et_search.setOnClickListener(new View.OnClickListener() {
       @Override
       public void onClick(View view) {
         String url = "https://www.google.com.eg/?hl=ar";
         Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
         startActivity(intent);

       }
     });
    AllData all = new AllData();
    setupRV(all.all(general));
    sh= getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
    String typeValue = sh.getString("type", "");
    if (typeValue.equals("")){
      showDialog(this);
    } else if (typeValue.equals("1")) {
      getSupportFragmentManager()
              .beginTransaction()
              .replace(R.id.container, baseGameFragment)
              .commit();
    } else if (typeValue.equals("2")) {
      AllData swimming = new AllData();
      setupRV(swimming.swimming());

    } else if (typeValue.equals("3")) {
          dialog.dismiss();
    }

    auth = FirebaseAuth.getInstance();
    user = auth.getCurrentUser();
    if (user == null) {
      Intent intent = new Intent(this, login_screen.class);
      startActivity(intent);
    } else {
      String email =user.getEmail();
      String userName = sh.getString(email, "User Name");
      txtName.setText(userName);
    }

    photo = findViewById(R.id.photo);
    SharedPreferences sh = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
    if (sh.getString("img", "") != "") {
      Bitmap bitmap = convertStringToBitmap(sh.getString("img", ""));
      if (bitmap != null) Log.d("suzan", bitmap.toString());
      photo.setImageBitmap(bitmap);
    }

    fragmentShow();
    srcFirst = findViewById(R.id.txtFirstSrc);
    srcSecond = findViewById(R.id.txtSecondSrc);
    srcThird = findViewById(R.id.txtThirdSrc);
    srcFirst = findViewById(R.id.txtFirstSrc);
    menu_btn = findViewById(R.id.btn_menu);
    menu_btn.setOnClickListener(
        new View.OnClickListener() {
          @Override
          public void onClick(View view) {
            showMenu(view);
          }
        });
    Intent intent = getIntent();
    location = intent.getStringExtra("key_message1");
    city = intent.getStringExtra("key_message2");
    country = intent.getStringExtra("key_message3");
    state = intent.getStringExtra("key_message4");
    listCountry(country);

  }

  public void fragmentShow() {
    bottomNavigationView = findViewById(R.id.bottom_navigation);
    bottomNavigationView.setOnItemSelectedListener(
        new NavigationBarView.OnItemSelectedListener() {
          @Override
          public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
              case R.id.search:
                String url = "https://www.google.com.eg/?hl=ar";
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                startActivity(intent);
                return true;

              case R.id.community:
                getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.container, communityFragment)
                    .commit();
                return true;

              case R.id.profile:
                getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.container, profileFragment)
                    .commit();
                return true;

              case R.id.game:
                getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.container, baseGameFragment)
                    .commit();
                return true;
              case R.id.home:
                getSupportFragmentManager().beginTransaction().remove(baseGameFragment).commit();
                getSupportFragmentManager().beginTransaction().remove(profileFragment).commit();
                getSupportFragmentManager().beginTransaction().remove(communityFragment).commit();
                getSupportFragmentManager().beginTransaction().remove(searchFragment).commit();
                return true;
            }
            return false;
          }
        });
  }

  @Override
  public boolean onCreatePanelMenu(int featureId, @NonNull Menu menu) {
    MenuInflater inflater = getMenuInflater();
    inflater.inflate(R.menu.menu, menu);
    return true;
  }

  public void showMenu(View view) {
    PopupMenu popup = new PopupMenu(this, view);
    MenuInflater inflater = popup.getMenuInflater();
    inflater.inflate(R.menu.menu, popup.getMenu());

    popup.setOnMenuItemClickListener(
        new PopupMenu.OnMenuItemClickListener() {
          @Override
          public boolean onMenuItemClick(MenuItem item) {
            // Handle the menu item click here
            switch (item.getItemId()) {
              case R.id.all:
                AllData all = new AllData();
                setupRV(all.all(general));
                Toast.makeText(getApplicationContext(), "All", Toast.LENGTH_SHORT).show();
                return true;
              case R.id.Endangered:
                AllData Endangered = new AllData();
                setupRV(Endangered.endangered(general));
                Toast.makeText(getApplicationContext(), "Endangered", Toast.LENGTH_SHORT).show();
                return true;
              case R.id.swimming:
                AllData swimming = new AllData();
                setupRV(swimming.swimming());
                Toast.makeText(getApplicationContext(), "Swimming", Toast.LENGTH_SHORT).show();
                return true;

              case R.id.nearest_Places:
                AllData nearest_Places = new AllData();
                setupRV(nearest_Places.nearest_Places(general));
                Toast.makeText(getApplicationContext(), "Nearest Places", Toast.LENGTH_SHORT)
                    .show();
                return true;
              case R.id.aroundWorld:
                AllData aroundWorld = new AllData();
                setupRV(aroundWorld.around_world());
                Toast.makeText(getApplicationContext(), "Around World", Toast.LENGTH_SHORT).show();
                return true;
              case R.id.quality:
                AllData quality = new AllData();
                setupRV(quality.quality(general));
                Toast.makeText(getApplicationContext(), "Quality of water", Toast.LENGTH_SHORT)
                    .show();
                return true;
              case R.id.resources:
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

                transaction.replace(R.id.container, resourcesFrag);

                transaction.addToBackStack(null);

                transaction.commit();
                Toast.makeText(getApplicationContext(), "Resources", Toast.LENGTH_SHORT);


                return true;
            }
            return false;
          }
        });

    popup.show();
  }

  public void setupRV(ArrayList<DataHome> setData) {

//    ArrayList<DataHome> showData = new ArrayList<>();
//    showData = setData;
    AdapterHomeInformation adapter = new AdapterHomeInformation(setData);
    RecyclerView.LayoutManager lm = new LinearLayoutManager(this);
    rv.setHasFixedSize(true);
    rv.setAdapter(adapter);
    rv.setLayoutManager(lm);
  }

  public int listCountry(String country) {

    whiteSea.add("Port Said Governorate");
    whiteSea.add("North Sinai Governorate");
    whiteSea.add("Dakahlia Governorate");
    whiteSea.add("Damietta Governorate");
    whiteSea.add("El Beheira Governorate");
    whiteSea.add("Kafr El Sheikh Governorate");
    whiteSea.add("Alexandria Governorate");
    whiteSea.add("Matrouh Governorate");
    //////
    redSea.add("Ismailia Governorate");
    redSea.add("Suez Governorate");
    redSea.add("South Sinai Governorate");
    redSea.add("Red Sea Governorate");
    redSea.add("Red Sea Governorate");
    ////
    nile.add("Sohag Governorate");
    nile.add("Qena Governorate");
    nile.add("Luxor Governorate");
    nile.add("Aswan Governorate");
    nile.add("Assiut Governorate");
    nile.add("Menia Governorate");
    nile.add("Minya Governorate");
    nile.add("Beni Suef Governorate");
    nile.add("Faiyum Governorate");
    nile.add("Ash Sharqia Governorate");
    nile.add("Cairo Governorate");
    nile.add("Giza Governorate");
    nile.add("Al Qalyubia Governorate");
    nile.add("Menofia Governorate");
    nile.add("Gharbia Governorate");
    nile.add("Dakahlia Governorate");
    for (String text : redSea) {
      if (text.equalsIgnoreCase(country)) {
        general = 0;
        srcFirst.setText("Indian Ocean");
        srcSecond.setText("Red Sea");
        srcThird.setText(country);
        break;
      }
    }
    for (String text : whiteSea) {
      if (text.equalsIgnoreCase(country)) {
        general = 1;
        srcFirst.setText("Atlantic Ocean");
        srcSecond.setText("The Mediterranean Sea");
        srcThird.setText(country);
        break;
      }
    }
    for (String text : nile) {
      if (text.equalsIgnoreCase(country)) {
        general = 2;
        srcFirst.setText("Lake Ethiopia");
        srcSecond.setText("Nile River");
        srcThird.setText(country);
        break;
      }
    }

    return general;
  }

  public Bitmap convertStringToBitmap(String encodedImage) {
    byte[] decodedBytes = Base64.decode(encodedImage, Base64.DEFAULT);
    return BitmapFactory.decodeByteArray(decodedBytes, 0, decodedBytes.length);
  }
  public void showDialog(Context context) {
    // Create a new AlertDialog builder
    AlertDialog.Builder builder = new AlertDialog.Builder(context);
    // Get the layout inflater
    LayoutInflater inflater = LayoutInflater.from(context);
    View dialogView = inflater.inflate(R.layout.chosse_type, null);

    builder.setView(dialogView);

    Button child = dialogView.findViewById(R.id.btn_child);
    Button fisherman = dialogView.findViewById(R.id.btn_fisherman);
    Button user = dialogView.findViewById(R.id.btn_User);

    // Create the AlertDialog
     dialog = builder.create();
    child.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        SharedPreferences.Editor editor = sh.edit();
        editor.putString("type","1");
        editor.apply();
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.container, baseGameFragment)
                .commit();

        dialog.dismiss(); // Close the dialog
      }
    });
    fisherman.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        SharedPreferences.Editor editor = sh.edit();
        editor.putString("type","2");
        editor.apply();
        AllData swimming = new AllData();
        setupRV(swimming.swimming());
        dialog.dismiss(); // Close the dialog
      }
    });
    user.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        SharedPreferences.Editor editor = sh.edit();
        editor.putString("type","3");
        editor.apply();
        dialog.dismiss(); // Close the dialog
      }
    });

    dialog.show();
  }


  @Override
  public void uploadImage(String img) {
    Bitmap bitmap =convertStringToBitmap(img);
    if (bitmap!=null){
      photo.setImageBitmap(bitmap);
    }
  }
}
