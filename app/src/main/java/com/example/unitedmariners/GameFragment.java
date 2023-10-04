package com.example.unitedmariners;

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
    TextView game_stars;
    LinearLayout linear1, linear2, linear3, linear4;


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


        linear1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String answer1 = "answer1";
                String answer2 = "answer1";
                String answer3 = "true answer"; //put here true answer
                String answer4 = "answer1";
                int type = 1;

                Bundle args = new Bundle();
                args.putString("answer1", answer1);
                args.putString("answer2", answer2);
                args.putString("answer3", answer3);
                args.putString("answer4", answer4);
                args.putInt("type" , type);

                Navigation.findNavController(v).navigate(R.id.action_gameFragment_to_gameFragment2 , args);

            }
        });

        linear2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String answer1 = "answer1";
                String answer2 = "answer1";
                String answer3 = "answer3";
                String answer4 = "true answer"; //put here true answer
                int type = 2;

                Bundle args = new Bundle();
                args.putString("answer1", answer1);
                args.putString("answer2", answer2);
                args.putString("answer3", answer3);
                args.putString("answer4", answer4);
                args.putInt("type" , type);

                Navigation.findNavController(v).navigate(R.id.action_gameFragment_to_gameFragment2 , args);


            }
        });
        linear3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String answer1 = "true answer";  //put here true answer
                String answer2 = "answer1";
                String answer3 = "answer1";
                String answer4 = "answer1";
                int type = 3;

                Bundle args = new Bundle();
                args.putString("answer1", answer1);
                args.putString("answer2", answer2);
                args.putString("answer3", answer3);
                args.putString("answer4", answer4);
                args.putInt("type" , type);

                Navigation.findNavController(v).navigate(R.id.action_gameFragment_to_gameFragment2 , args);

            }
        });
        linear4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String answer1 = "answer1";
                String answer2 = "true answer";  //put here true answer
                String answer3 = "answer1";
                String answer4 = "answer1";
                int type = 4;

                Bundle args = new Bundle();
                args.putString("answer1", answer1);
                args.putString("answer2", answer2);
                args.putString("answer3", answer3);
                args.putString("answer4", answer4);
                args.putInt("type" , type);

                Navigation.findNavController(v).navigate(R.id.action_gameFragment_to_gameFragment2 , args);

            }
        });


        return v;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }
}