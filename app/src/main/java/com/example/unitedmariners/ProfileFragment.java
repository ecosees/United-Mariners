package com.example.unitedmariners;

import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;


public class ProfileFragment extends Fragment {

TextView logOut,emailTxt;
FirebaseAuth auth;
FirebaseUser user;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.fragment_profile, container, false);
        logOut=v.findViewById(R.id.logout);
        emailTxt=v.findViewById(R.id.user_email);
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