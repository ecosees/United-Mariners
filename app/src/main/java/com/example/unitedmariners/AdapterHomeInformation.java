package com.example.unitedmariners;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdapterHomeInformation extends RecyclerView.Adapter <AdapterHomeInformation.InformationViewHolder>{
    @NonNull
    ArrayList<DataHome> data ;

    public AdapterHomeInformation(@NonNull ArrayList<DataHome> data) {
        this.data = data;
    }

    @Override
    public InformationViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
      View view=  LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_adapter_information,null,false);
      InformationViewHolder viewHolder=new InformationViewHolder(view);
        return viewHolder;

    }

    @Override
    public void onBindViewHolder(@NonNull InformationViewHolder holder, int position)  {
       DataHome  dataHome=data.get(position);
       holder.imageView.setImageResource(dataHome.getImg());
       holder.nameImg.setText(dataHome.getNameData());
       holder.dataImag.setText(dataHome.getDataabout());


    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class InformationViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView nameImg ,dataImag;
        public InformationViewHolder(@NonNull View itemView) {
            super(itemView);
             imageView=itemView.findViewById(R.id.iv_photo);
             nameImg=itemView.findViewById(R.id.txt_nameImg);
             dataImag=itemView.findViewById(R.id.txt_informationImg);
        }
    }
}
