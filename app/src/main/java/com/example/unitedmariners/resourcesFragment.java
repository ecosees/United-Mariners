package com.example.unitedmariners;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class resourcesFragment extends Fragment {
    TextView linkClickE,linkclickQ,linkClickW,linkClickS,linkClickA,linkClickP;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v=inflater.inflate(R.layout.fragment_resources, container, false);
        linkClickE=v.findViewById(R.id.btn_linkE);
        linkclickQ=v.findViewById(R.id.btn_linkQ);
        linkClickW=v.findViewById(R.id.btn_linkW);
        linkClickS=v.findViewById(R.id.btn_linkS);
        linkClickA=v.findViewById(R.id.btn_linkA);
        linkClickP=v.findViewById(R.id.btn_linkP);

        String urlEndangered = "https://www.nationalgeographic.com/";
        String urlPlaces = "https://a-z-animals.com/blog/2-massive-great-white-sharks-weighing-as-much-as-a-polar-bear-" +
                "each-found-swimming-off-the-coast-of-canada/?from=exit_intent ";
        String urlQuality = "https://water.fanack.com/egypt/water-quality-in-egypt/ ";
        String urlWaterOfSources = "https://www.sciencedirect.com/science/article/pii/S1687428520300200 ";
        String urlSwimming = "https://swim-west.com/10-swimming-tips-save-life-family-sea/ ";
        String urlAroundWorld = "https://www.ifaw.org/international/journal/world-most-endangered-animals ";


        linkClickE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(urlEndangered));
                startActivity(intent);

            }
        });
        linkClickP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(urlPlaces));
                startActivity(intent);

            }
        });
        linkclickQ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(urlQuality));
                startActivity(intent);

            }
        });
        linkClickW.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(urlWaterOfSources));
                startActivity(intent);

            }
        });
        linkClickS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(urlSwimming));
                startActivity(intent);

            }
        });
        linkClickA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(urlAroundWorld));
                startActivity(intent);

            }
        });
        return v;
    }
}