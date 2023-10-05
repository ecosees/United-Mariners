package com.example.unitedmariners;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class GameFragment extends Fragment {
    TextView game_stars, tvLevel1, tvLevel2, tvLevel3, tvLevel4;
    TextView showTvLevel1, showTvLevel2, showTvLevel3, showTvLevel4;
    LinearLayout linear1, linear2, linear3, linear4;

    boolean star1 = false, star2 = false, star3 = false, star4 = false;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_game, container, false);
        game_stars = v.findViewById(R.id.game_stars);
        linear1 = v.findViewById(R.id.linear1);
        linear2 = v.findViewById(R.id.linear2);
        linear3 = v.findViewById(R.id.linear3);
        linear4 = v.findViewById(R.id.linear4);
        tvLevel1 = v.findViewById(R.id.tv_level1);
        tvLevel2 = v.findViewById(R.id.tv_level2);
        tvLevel3 = v.findViewById(R.id.tv_level3);
        tvLevel4 = v.findViewById(R.id.tv_level4);
        showTvLevel1 = v.findViewById(R.id.tv_level1_show);
        showTvLevel2 = v.findViewById(R.id.tv_level2_show);
        showTvLevel3 = v.findViewById(R.id.tv_level3_show);
        showTvLevel4 = v.findViewById(R.id.tv_level4_show);


        SharedPreferences sh = requireActivity().getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);

        boolean level1 = sh.getBoolean("level1", false);
        boolean level2 = sh.getBoolean("level2", false);
        boolean level3 = sh.getBoolean("level3", false);
        boolean level4 = sh.getBoolean("level4", false);

        if (level1) {
            tvLevel1.setVisibility(View.GONE);
            showTvLevel1.setVisibility(View.VISIBLE);
            star1 = true;
        }

        if (level2) {
            tvLevel2.setVisibility(View.GONE);
            showTvLevel2.setVisibility(View.VISIBLE);
            star2 = true;
        }

        if (level3) {
            tvLevel3.setVisibility(View.GONE);
            showTvLevel3.setVisibility(View.VISIBLE);
            star3 = true;
        }

        if (level4) {
            tvLevel4.setVisibility(View.GONE);
            showTvLevel4.setVisibility(View.VISIBLE);
            star4 = true;
        }



        if(star1)
            game_stars.setText("1");
        if(star1 && star2)
            game_stars.setText("2");
        if(star1 && star2 && star3)
            game_stars.setText("3");
        if(star1 && star2 && star3 && star4)
            game_stars.setText("4");

        linear1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String answer1 = "Star Fish";
                String answer2 = "Sea Horse";
                String answer3 = "European Eel"; //true answer here
                String answer4 = "Angler Fish";
                int type = 1;

                Bundle args = new Bundle();
                args.putString("answer1", answer1);
                args.putString("answer2", answer2);
                args.putString("answer3", answer3);
                args.putString("answer4", answer4);
                args.putInt("type", type);

                Navigation.findNavController(v).navigate(R.id.action_gameFragment_to_gameFragment2, args);

            }
        });

        linear2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String answer1 = "Warlus";
                String answer2 = "Angler Fish";
                String answer3 = "Cuttle Fish";
                String answer4 = "Sturgeon"; //true answer here
                int type = 2;

                Bundle args = new Bundle();
                args.putString("answer1", answer1);
                args.putString("answer2", answer2);
                args.putString("answer3", answer3);
                args.putString("answer4", answer4);
                args.putInt("type", type);

                Navigation.findNavController(v).navigate(R.id.action_gameFragment_to_gameFragment2, args);


            }
        });
        linear3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String answer1 = "Dugong";  //true answer here
                String answer2 = "Oyster";
                String answer3 = "Viper Fish ";
                String answer4 = "Shark";
                int type = 3;

                Bundle args = new Bundle();
                args.putString("answer1", answer1);
                args.putString("answer2", answer2);
                args.putString("answer3", answer3);
                args.putString("answer4", answer4);
                args.putInt("type", type);

                Navigation.findNavController(v).navigate(R.id.action_gameFragment_to_gameFragment2, args);

            }
        });
        linear4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String answer1 = "Gulpereel";
                String answer2 = "Sea Turtle";  //put here true answer
                String answer3 = "Nudibnanchs";
                String answer4 = "Stingray";
                int type = 4;

                Bundle args = new Bundle();
                args.putString("answer1", answer1);
                args.putString("answer2", answer2);
                args.putString("answer3", answer3);
                args.putString("answer4", answer4);
                args.putInt("type", type);

                Navigation.findNavController(v).navigate(R.id.action_gameFragment_to_gameFragment2, args);

            }
        });


        return v;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }
}