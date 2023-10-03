package com.example.unitedmariners;

import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;


public class ProfileFragment extends Fragment {
    ImageView profile_photo;
    ImageButton user_name_edit;

TextView email,logOut,emailTxt,change_location,add_account;
FirebaseAuth auth;
FirebaseUser user;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.fragment_profile, container, false);
        logOut=v.findViewById(R.id.logout);
        emailTxt=v.findViewById(R.id.user_email);
        email=v.findViewById(R.id.email);
        user_name_edit=v.findViewById(R.id.user_name_edit);
        profile_photo=v.findViewById(R.id.profile_photo);
        change_location =v.findViewById(R.id.change_location);
        add_account =v.findViewById(R.id.add_account);



        email.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), login_screen.class);
                startActivity(intent);
                requireActivity().finish();

            }
        });


        change_location.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    Intent intent = new Intent(getActivity(), MapsActivity.class);
                    startActivity(intent);
                    requireActivity().finish();

            }
        });

        add_account.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), sign_up_screen.class);
                startActivity(intent);
                requireActivity().finish();

            }
        });


        auth=FirebaseAuth.getInstance();
        user=auth.getCurrentUser();
        if(user==null){
           Intent intent = new Intent(getContext(), login_screen.class);
            startActivity(intent);
        }else {
            emailTxt.setText(user.getEmail());
        }
        logOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseAuth.getInstance().signOut();
                Intent intent = new Intent(getContext(), login_screen.class);
                startActivity(intent);
                requireActivity().finish();
            }
        });
        return v;
    }
}