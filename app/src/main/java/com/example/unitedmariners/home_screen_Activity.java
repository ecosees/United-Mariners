package com.example.unitedmariners;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import java.util.ArrayList;
import java.util.List;

public class home_screen_Activity extends AppCompatActivity {
  RecyclerView rv;
  ImageButton menu_btn;
  String location, city, country, state,userName;
  ImageView photo;
  TextView srcFirst;
  TextView srcSecond;
  TextView srcThird;
  int general =-1;
  ArrayList<String> redSea=new ArrayList<>();
  ArrayList<String> whiteSea=new ArrayList<>();
  ArrayList<String> nile=new ArrayList<>();
  BottomNavigationView bottomNavigationView;
  SearchFragment searchFragment = new SearchFragment();
  CommunityFragment communityFragment = new CommunityFragment();
  ProfileFragment profileFragment = new ProfileFragment();
  GameFragment gameFragment = new GameFragment();

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_home_screen);
    photo = findViewById(R.id.photo);
    fragmentShow();
    rv = findViewById(R.id.rv_home);
    menu_btn = findViewById(R.id.btn_menu);
    menu_btn.setOnClickListener(
        new View.OnClickListener() {
          @Override
          public void onClick(View view) {
            showMenu(view); // Call the showMenu method when the ImageButton is clicked.
          }
        });
    Intent intent = getIntent();
    location = intent.getStringExtra("key_message1");
    city = intent.getStringExtra("key_message2");
    country = intent.getStringExtra("key_message3");
    state = intent.getStringExtra("key_message4");
    userName = intent.getStringExtra("key_message5");
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
                String url="https://www.google.com.eg/?hl=ar";
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
                    .replace(R.id.container, gameFragment)
                    .commit();
                return true;

              case R.id.home:
                getSupportFragmentManager().beginTransaction().remove(gameFragment).commit();
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
                setupArraylist(all.allData(general));
                Toast.makeText(getApplicationContext(), "All", Toast.LENGTH_SHORT).show();
                return true;
              case R.id.swimming:
                AllData swimming = new AllData();
                setupArraylist(swimming.swimming());
                Toast.makeText(getApplicationContext(), "swimming", Toast.LENGTH_SHORT).show();
                return true;

              case R.id.nearest_Places:
                AllData nearest_Places = new AllData();
                setupArraylist(nearest_Places.nearest_Places());
                Toast.makeText(getApplicationContext(), "nearest_Places", Toast.LENGTH_SHORT)
                    .show();
                return true;
              case R.id.water_source:
                AllData water_source = new AllData();
                setupArraylist(water_source.water_source());
                Toast.makeText(getApplicationContext(), "water_source", Toast.LENGTH_SHORT).show();
                return true;
              case R.id.quality:
                AllData quality = new AllData();
                setupArraylist(quality.quality());
                Toast.makeText(getApplicationContext(), "Quality of water", Toast.LENGTH_SHORT)
                    .show();
                return true;
            }
            return false;
          }
        });

    popup.show();
  }

  public void setupArraylist(ArrayList<DataHome> setData) {
    ArrayList<DataHome> showData = new ArrayList<>();
    showData = setData;
    AdapterHomeInformation adapter = new AdapterHomeInformation(showData);
    RecyclerView.LayoutManager lm = new LinearLayoutManager(this);
    rv.setHasFixedSize(true);
    rv.setAdapter(adapter);
    rv.setLayoutManager(lm);
  }
  public int listCountry(String country){

    whiteSea.add("Port Said Governorate");
    whiteSea.add("North Sinai Governorate");
    whiteSea.add("Dakahlia Governorate");
    whiteSea.add("Damietta Governorate");
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
    nile.add("Beni Suef Governorate");
    nile.add("Faiyum Governorate");
    nile.add("Ash Sharqia Governorate");
    nile.add("Cairo Governorate");
    nile.add("El Beheira Governorate");
    nile.add("Giza Governorate");
    nile.add("Al Qalyubia Governorate");
    nile.add("Menofia Governorate");
    nile.add("Gharbia Governorate");
    nile.add("الدقهلية");
    for (String text : redSea) {
      if (text.equalsIgnoreCase(country)) {
        general = 0;
        break;
      }
    }
    for (String text : whiteSea) {
      if (text.equalsIgnoreCase(country)) {
        general = 1;
        break;
      }
    }
    for (String text : nile) {
      if (text.equalsIgnoreCase(country)) {
        general = 2;
        break;
      }
    }

    return general;
  }
}
