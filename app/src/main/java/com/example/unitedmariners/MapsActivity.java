package com.example.unitedmariners;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;
import android.util.Log;
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
  }

  @Override
  public void dataSend(Double latitude, Double longitude) {
    try {
      geocoder = new Geocoder(this, Locale.getDefault());
      addresses = geocoder.getFromLocation(latitude, longitude, 1);
  //    Log.d("mohamed", addresses.toString());
      String address = addresses.get(0).getAddressLine(0);
      String city = addresses.get(0).getLocality();
      String state = addresses.get(0).getAdminArea();
      String country = addresses.get(0).getCountryName();
      et_location.setText(address);

    } catch (IOException e) {
      e.printStackTrace();
    } catch (IndexOutOfBoundsException e) {
      e.printStackTrace();
     // Toast.makeText(this, e.toString(), Toast.LENGTH_SHORT).show();
    }
  }
}
