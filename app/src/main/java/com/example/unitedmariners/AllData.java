package com.example.unitedmariners;

import java.util.ArrayList;

public class AllData {
    public ArrayList <DataHome> allData(){
        ArrayList<DataHome> allDataArray=new ArrayList<>();
       allDataArray.add(new DataHome(R.drawable.european, "European Eel",R.string.European_Eel));
    allDataArray.add(new DataHome(R.drawable.mediterranean, "Mediterranean Monk Seal", R.string.Mediterranean));
    allDataArray.add(new DataHome(R.drawable.sturgeon, "Russian Sturgeon", R.string.Sturgeon));
        return allDataArray;
    }

    public ArrayList <DataHome> information(){
        ArrayList<DataHome> allDataArray=new ArrayList<>();
       allDataArray.add(new DataHome(R.drawable.european, "European Eel",R.string.European_Eel));
        return allDataArray;
    }
    public ArrayList <DataHome> nearest_Places(){
        ArrayList<DataHome> allDataArray=new ArrayList<>();
        allDataArray.add(new DataHome(R.drawable.european, "European Eel",R.string.European_Eel));
        return allDataArray;
    }
    public ArrayList <DataHome> swimming(){
        ArrayList<DataHome> allDataArray=new ArrayList<>();
        allDataArray.add(new DataHome(R.drawable.european, "European Eel",R.string.European_Eel));
        return allDataArray;
    }
        public ArrayList <DataHome> quality(){
        ArrayList<DataHome> allDataArray=new ArrayList<>();
        allDataArray.add(new DataHome(R.drawable.european, "European Eel",R.string.European_Eel));
        return allDataArray;
    }   public ArrayList <DataHome> water_source(){
        ArrayList<DataHome> allDataArray=new ArrayList<>();
        allDataArray.add(new DataHome(R.drawable.european, "European Eel",R.string.European_Eel));
        return allDataArray;
    }
}
