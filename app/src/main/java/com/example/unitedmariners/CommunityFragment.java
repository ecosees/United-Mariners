package com.example.unitedmariners;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class CommunityFragment extends Fragment {

Button join ;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v=inflater.inflate(R.layout.fragment_community, container, false);
        String telegramUrl = "https://t.me/+Vc3Lf4oqM1I4M2Q0";
        join=v.findViewById(R.id.btn_join_group);
        join.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(telegramUrl));
                    startActivity(intent);
            }
        });

        return v;

    }
}