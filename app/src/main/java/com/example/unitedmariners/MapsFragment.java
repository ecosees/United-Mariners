package com.example.unitedmariners;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Geocoder;
import android.location.Location;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import android.os.LocaleList;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;

public class MapsFragment extends Fragment {
  FusedLocationProviderClient fusedLocationProviderClient;
  private static final int REQUEST_CODE = 100;
  Double latitude, longitude;
  private dataFragmentListener listener;

  @Override
  public void onAttach(@NonNull Context context) {
    super.onAttach(context);
    if (context instanceof dataFragmentListener) {
      listener = (dataFragmentListener) context;

    } else {
      throw new ClassCastException("Activity does not implements");
    }
  }

  @Override
  public void onDetach() {
    super.onDetach();
    listener = null;
  }

  public void getLastLocation() {

    /*   if (ActivityCompat.checkSelfPermission(getContext(), Manifest.permission.ACCESS_FINE_LOCATION)
    != PackageManager.PERMISSION_GRANTED
    || ActivityCompat.checkSelfPermission(
    getContext(), Manifest.permission.ACCESS_COARSE_LOCATION)
    != PackageManager.PERMISSION_GRANTED) */

    Log.d(
        "suzan",
        String.valueOf(
            ActivityCompat.checkSelfPermission(
                    getContext(), Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED));

    Log.d(
        "suzan",
        String.valueOf(
            ActivityCompat.checkSelfPermission(
                    getContext(), Manifest.permission.ACCESS_COARSE_LOCATION)
                != PackageManager.PERMISSION_GRANTED));

    if (ActivityCompat.checkSelfPermission(getContext(), Manifest.permission.ACCESS_FINE_LOCATION)
        == PackageManager.PERMISSION_GRANTED) {
      fusedLocationProviderClient
          .getLastLocation()
          .addOnSuccessListener(
              new OnSuccessListener<Location>() {
                @Override
                public void onSuccess(Location location) {
                  Log.d("suzan", location.toString());
                  if (location != null) {
                    latitude = location.getLatitude();
                    longitude = location.getLongitude();

                    listener.dataSend(latitude, longitude); // بيروح من هنا
                  }
                }
              })
          .addOnFailureListener(
              new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {
                  Log.d("suzan" , e.toString());
                }
              });
      ;
    } else {

      ActivityCompat.requestPermissions(requireActivity(), new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 1542);

      Log.d("suzan", "Failed");
    }
  }


  @Override
  public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
    super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    Log.d("suzan" , "return request");

    if (requestCode == 1542) {
      if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
        // Permission granted, you can now use location services
        getLastLocation();
      } else {
        // Permission denied, handle it accordingly (e.g., show a message or disable location features)
        Log.d("suzan" , "Failed from permission function");
      }
    }
  }



  @Override
  public View onCreateView(
      LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    View view = inflater.inflate(R.layout.fragment_maps, container, false);
    fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(getContext());
    getLastLocation();
    SupportMapFragment supportMapFragment =
        (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.frag_map);
    supportMapFragment.getMapAsync(
        new OnMapReadyCallback() {
          @Override
          public void onMapReady(@NonNull GoogleMap googleMap) {

            googleMap.setOnMapClickListener(
                new GoogleMap.OnMapClickListener() {
                  @Override
                  public void onMapClick(@NonNull LatLng latLng) {
                    MarkerOptions markerOptions = new MarkerOptions();
                    markerOptions.position(latLng);
                    markerOptions.title(latLng.latitude + " KG " + latLng.longitude);
                    googleMap.clear();
                    googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(latLng, 20));
                    googleMap.addMarker(markerOptions);
                    if (latLng.latitude == 0.0d && latLng.longitude == 0.0d) {
                      getLastLocation();
                    } else {
                      latitude = latLng.latitude;
                      longitude = latLng.longitude;
                    }
                    listener.dataSend(latitude, longitude);
                  }
                });
          }
        });

    return view;
  }

  public interface dataFragmentListener {
    void dataSend(Double latitude, Double longitude);
  }
}
