package com.example.unitedmariners;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.SurfaceControl;
import android.widget.FrameLayout;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import java.util.ArrayList;

public class home_screen_Activity extends AppCompatActivity {
    RecyclerView rv;

    BottomNavigationView bottomNavigationView;
    SearchFragment searchFragment=new SearchFragment();
    CommunityFragment communityFragment=new CommunityFragment();
    ProfileFragment profileFragment=new ProfileFragment();
    GameFragment gameFragment=new GameFragment();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);
        rv=findViewById(R.id.rv_home);
        ArrayList <DataHome> showData=new ArrayList<>();
        showData.add(new DataHome(R.drawable.background_img,"see","Lorem Ipsum is simply dummy text" +
                " ofthe printing and Lorem Lorem Ipsum is" +
                " simply Ipsum is simply dummy text of the printing and " +
                "Lorem Ipsum is simply dummy text of "));
        showData.add(new DataHome(R.drawable.background_img,"see","Lorem Ipsum is simply dummy text" +
                " ofthe printing and Lorem Lorem Ipsum is" +
                " simply Ipsum is simply dummy text of the printing and " +
                "Lorem Ipsum is simply dummy text of "));
        showData.add(new DataHome(R.drawable.background_img,"see","Lorem Ipsum is simply dummy text" +
                " ofthe printing and Lorem Lorem Ipsum is" +
                " simply Ipsum is simply dummy text of the printing and " +
                "Lorem Ipsum is simply dummy text of "));
        showData.add(new DataHome(R.drawable.background_img,"see","Lorem Ipsum is simply dummy text" +
                " ofthe printing and Lorem Lorem Ipsum is" +
                " simply Ipsum is simply dummy text of the printing and " +
                "Lorem Ipsum is simply dummy text of "));
        AdapterHomeInformation adapter=new AdapterHomeInformation(showData);
        RecyclerView.LayoutManager lm=new LinearLayoutManager(this);
        rv.setHasFixedSize(true);
        rv.setAdapter(adapter);
        rv.setLayoutManager(lm);
        fragmentShow();


    }
    public void fragmentShow(){
        bottomNavigationView =findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.search :
                        getSupportFragmentManager().beginTransaction().replace(R.id.container,searchFragment).commit();
                        return true;

                    case R.id.community:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container,communityFragment).commit();
                        return true;

                    case R.id.profile:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container,profileFragment).commit();
                        return true;

                    case R.id.game:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container,gameFragment).commit();
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
}