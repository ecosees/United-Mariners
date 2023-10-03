package com.example.unitedmariners;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
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

public class home_screen_Activity extends AppCompatActivity {
  RecyclerView rv;
  ImageButton menu_btn;

  ImageView photo;

  TextView tv_name;

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
    tv_name = findViewById(R.id.tv_name);
    String userName = getIntent().getStringExtra("userName");
    tv_name.setText(userName);
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
  }

  public void fragmentShow() {
    bottomNavigationView = findViewById(R.id.bottom_navigation);
    bottomNavigationView.setOnItemSelectedListener(
        new NavigationBarView.OnItemSelectedListener() {
          @Override
          public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
              case R.id.search:
                getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.container, searchFragment)
                    .commit();
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
                AllData all=new AllData();
                setupArraylist(all.allData());
                Toast.makeText(getApplicationContext(), "All", Toast.LENGTH_SHORT).show();
                return true;
              case R.id.information:
                AllData information=new AllData();
                setupArraylist(information.information());
                Toast.makeText(getApplicationContext(), "information", Toast.LENGTH_SHORT).show();
                return true;
              case R.id.swimming:
                AllData swimming=new AllData();
                setupArraylist(swimming.swimming());
                Toast.makeText(getApplicationContext(), "swimming", Toast.LENGTH_SHORT).show();
                return true;

              case R.id.nearest_Places:
                AllData nearest_Places=new AllData();
                setupArraylist(nearest_Places.nearest_Places());
                Toast.makeText(getApplicationContext(), "nearest_Places", Toast.LENGTH_SHORT)
                    .show();
                return true;
              case R.id.water_source:
                AllData water_source=new AllData();
                setupArraylist(water_source.water_source());
                Toast.makeText(getApplicationContext(), "water_source", Toast.LENGTH_SHORT).show();
                return true;
              case R.id.quality:
                AllData quality=new AllData();
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
    showData=setData;
    AdapterHomeInformation adapter = new AdapterHomeInformation(showData);
    RecyclerView.LayoutManager lm = new LinearLayoutManager(this);
    rv.setHasFixedSize(true);
    rv.setAdapter(adapter);
    rv.setLayoutManager(lm);
  }
}
