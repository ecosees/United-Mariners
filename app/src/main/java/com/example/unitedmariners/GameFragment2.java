package com.example.unitedmariners;

import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class GameFragment2 extends Fragment {
    ImageButton im_back_icon;
    TextView try_again, tv_animal1, tv_animal2, tv_animal3, tv_animal4, level;
    ImageView animal_photo;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_game2, container, false);

        im_back_icon = v.findViewById(R.id.im_back_icon);
        try_again = v.findViewById(R.id.try_again);
        tv_animal1 = v.findViewById(R.id.tv_animal1);
        tv_animal2 = v.findViewById(R.id.tv_animal2);
        tv_animal3 = v.findViewById(R.id.tv_animal3);
        tv_animal4 = v.findViewById(R.id.tv_animal4);
        level = v.findViewById(R.id.level);
        animal_photo = v.findViewById(R.id.animal_photo);

        String answer1 = getArguments().getString("answer1");
        String answer2 = getArguments().getString("answer2");
        String answer3 = getArguments().getString("answer3");
        String answer4 = getArguments().getString("answer4");
        int type = getArguments().getInt("type");

        tv_animal1.setText(answer1);
        tv_animal2.setText(answer2);
        tv_animal3.setText(answer3);
        tv_animal4.setText(answer4);
        if (type == 1)       //level 1
        {
            animal_photo.setImageResource(R.drawable.mediterraneansea);
            level.setText("Level 1");

        } else if (type == 2)  //level 2
        {
            animal_photo.setImageResource(R.drawable.atlantic_ocean);
            level.setText("Level 2");

        } else if (type == 3)  //level 3
        {
            animal_photo.setImageResource(R.drawable.lion_fish);
            level.setText("Level 3");
        } else if (type == 4)  //level 4
        {
            animal_photo.setImageResource(R.drawable.manatee);
            level.setText("Level 4");
        }


        im_back_icon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(v).navigateUp();
            }
        });


        tv_animal1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (type == 1)
                    try_again.setVisibility(View.VISIBLE);
                else if (type == 2)
                    try_again.setVisibility(View.VISIBLE);
                else if (type == 3) {
                    try_again.setVisibility(View.VISIBLE);
                    try_again.setText("Congratulation .. ");
                    try_again.setTextColor(Color.GREEN);
                } else if (type == 4)
                    try_again.setVisibility(View.VISIBLE);

                Log.d("suzan", String.valueOf(type));

            }
        });

        tv_animal2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (type == 1)
                    try_again.setVisibility(View.VISIBLE);
                else if (type == 2)
                    try_again.setVisibility(View.VISIBLE);
                else if (type == 3) {
                    try_again.setVisibility(View.VISIBLE);
                } else if (type == 4) {
                    try_again.setVisibility(View.VISIBLE);
                    try_again.setText("Congratulation .. ");
                    try_again.setTextColor(Color.GREEN);
                }

                Log.d("suzan", String.valueOf(type));

            }
        });

        tv_animal3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (type == 1) {
                    try_again.setVisibility(View.VISIBLE);
                    try_again.setText("Congratulation .. ");
                    try_again.setTextColor(Color.GREEN);
                } else if (type == 2)
                    try_again.setVisibility(View.VISIBLE);
                else if (type == 3)
                    try_again.setVisibility(View.VISIBLE);
                else if (type == 4)
                    try_again.setVisibility(View.VISIBLE);

                Log.d("suzan", String.valueOf(type));

            }
        });

        tv_animal4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (type == 1)
                    try_again.setVisibility(View.VISIBLE);
                else if (type == 2) {
                    try_again.setVisibility(View.VISIBLE);
                    try_again.setText("Congratulation .. ");
                    try_again.setTextColor(Color.GREEN);
                } else if (type == 3)
                    try_again.setVisibility(View.VISIBLE);

                else if (type == 4)
                    try_again.setVisibility(View.VISIBLE);

                Log.d("suzan", String.valueOf(type));

            }
        });


        return v;
    }
}