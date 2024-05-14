package com.example.unitedmariners;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class MapsActivity extends AppCompatActivity implements MapsFragment.dataFragmentListener {
  List<Address> addresses = new ArrayList<>();
  Geocoder geocoder;
  EditText et_location;
  String address, city, state, country,userName;
  Button start;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_maps);
    Fragment fragment = new MapsFragment();
    getSupportFragmentManager()
        .beginTransaction()
        .replace(R.id.frame_layout, new MapsFragment())
        .commit();
    et_location = findViewById(R.id.et_Location);
    Intent intent=getIntent();
    userName=intent.getStringExtra("key");
    start = findViewById(R.id.startbtn);
    start.setOnClickListener(
        new View.OnClickListener() {
          @Override
          public void onClick(View view) {
            Intent intent = new Intent(getApplicationContext(), home_screen_Activity.class);
            intent.putExtra("key_message1", address);
            intent.putExtra("key_message2", city);
            intent.putExtra("key_message3", state);
            intent.putExtra("key_message4", country);
            if (country.toLowerCase().equals("egypt")){
              startActivity(intent);
            }else {
              Toast.makeText(MapsActivity.this, "Change Location and Choose Egypt", Toast.LENGTH_SHORT).show();}
          }
        });
  }

  @Override
  public void dataSend(Double latitude, Double longitude) {
    try {
      geocoder = new Geocoder(this, Locale.getDefault());
      addresses = geocoder.getFromLocation(latitude, longitude, 1);
      //    Log.d("mohamed", addresses.toString());
      address = addresses.get(0).getAddressLine(0);
      city = addresses.get(0).getLocality();
      state = addresses.get(0).getAdminArea();
      country = addresses.get(0).getCountryName();
      et_location.setText(address);

    } catch (IOException e) {
      e.printStackTrace();
    } catch (IndexOutOfBoundsException e) {
      e.printStackTrace();
      // Toast.makeText(this, e.toString(), Toast.LENGTH_SHORT).show();
    }
  }
}
