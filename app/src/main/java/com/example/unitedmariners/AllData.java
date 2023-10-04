package com.example.unitedmariners;

import java.util.ArrayList;

public class AllData {
  String userInput;

  public void location() {}

  public ArrayList<DataHome> endangered(int general) {
    ArrayList<DataHome> allDataArray = new ArrayList<>();
    if (general == 0) { // The Red Sea
      allDataArray.add(new DataHome(R.drawable.seaturtle, "Sea Turtle", R.string.Sea_Turtle));
      allDataArray.add(new DataHome(R.drawable.dugong, "Dugong", R.string.Dugong));
      allDataArray.add(new DataHome(R.drawable.whaleshark, "Whale Shark", R.string.Whale_Shark));
    } else if (general == 1) { // The Mediterranean Sea
      allDataArray.add(
          new DataHome(R.drawable.european, "European", R.string.European_Eel));
      allDataArray.add(new DataHome(R.drawable.mediterraneansee, "Mediterranean Monk Seal", R.string.Mediterranean));
      allDataArray.add(new DataHome(R.drawable.sturgeon, "Russian Sturgeon", R.string.Sturgeon));
    } else if (general == 2) { // nile
      allDataArray.add(
          new DataHome(
              R.drawable.native_fish, "Native Fish", R.string.Native_Fish));
      allDataArray.add(new DataHome(R.drawable.dugong, "Dugong", R.string.Dugong));
      allDataArray.add(new DataHome(R.drawable.hippopotamus, "Hippopotamus", R.string.Hippopotamus));

    } else {
      allDataArray.add(new DataHome(R.drawable.seaturtle, "Sea Turtle", R.string.Sea_Turtle));
      allDataArray.add(new DataHome(R.drawable.dugong, "Dugong", R.string.Dugong));
      allDataArray.add(new DataHome(R.drawable.whaleshark, "Whale Shark", R.string.Whale_Shark));
      allDataArray.add(new DataHome(R.drawable.european, "European", R.string.European_Eel));
      allDataArray.add(new DataHome(R.drawable.mediterraneansee, "Mediterranean Monk Seal", R.string.Mediterranean));
      allDataArray.add(new DataHome(R.drawable.sturgeon, "Russian Sturgeon", R.string.Sturgeon));
      allDataArray.add(new DataHome(R.drawable.dugong, "Dugong", R.string.Dugong));
      allDataArray.add(new DataHome(R.drawable.hippopotamus, "Hippopotamus", R.string.Hippopotamus));
    }

    return allDataArray;
  }

  public ArrayList<DataHome> nearest_Places(int general) {
    ArrayList<DataHome> allDataArray = new ArrayList<>();
    if (general==0){//red sea
      allDataArray.add(new DataHome(R.drawable.european, "European Eel", R.string.European_Eel));


    }else if(general==1){// white sea


    }else if(general==2){//nile


    }else {
      //red +white +nile
    }
    return allDataArray;
  }

  public ArrayList<DataHome> swimming() {
    ArrayList<DataHome> allDataArray = new ArrayList<>();
    allDataArray.add(new DataHome(R.drawable.swimming, "First Advice", R.string.First_Advice));
    allDataArray.add(new DataHome(R.drawable.suncream, "Second Advice", R.string.Second_Advice));
    allDataArray.add(new DataHome(R.drawable.fishing, "Third Advice", R.string.Third_Advice));
    allDataArray.add(new DataHome(R.drawable.aquatic, "Fourth Advice", R.string.Fourth_Advice));
    allDataArray.add(new DataHome(R.drawable.hook, "Fifth Advice", R.string.Fifth_Advice));
    return allDataArray;
  }

  public ArrayList<DataHome> quality(int general) {
    ArrayList<DataHome> allDataArray = new ArrayList<>();
    if (general == 0) { // The Red Sea
      allDataArray.add(new DataHome(R.drawable.redsea, "Red Sea", R.string.The_Red_Sea));
    }else if(general==1){
      allDataArray.add(new DataHome(R.drawable.mediterraneansee, "Mediterranean", R.string.The_Mediterranean_Sea));

    }else if(general==2){
      allDataArray.add(new DataHome(R.drawable.nile_river, "Nile River", R.string.The_Nile_Rive));

    }else {
      allDataArray.add(new DataHome(R.drawable.atlantic_ocean, "Nile River", R.string.The_Atlantic_ocean));
      allDataArray.add(new DataHome(R.drawable.ocean, "Nile River", R.string.Indian_Ocean));
    }



    return allDataArray;
  }

  public ArrayList<DataHome> around_world() {
    ArrayList<DataHome> allDataArray = new ArrayList<>();
    // data world
    allDataArray.add(new DataHome(R.drawable.swimming, "First Advice", R.string.First_Advice));
    return allDataArray;
  }
  public ArrayList<DataHome> all(int general) {
    ArrayList<DataHome> allDataArray = new ArrayList<>();
    if (general == 0) { // The Red Sea

    }else if(general==1){

    }else if(general==2){

    }

    return allDataArray;
  }

}
