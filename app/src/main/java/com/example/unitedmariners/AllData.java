package com.example.unitedmariners;

import java.util.ArrayList;

public class AllData {
  String userInput;

  public void location() {}

  public ArrayList<DataHome> allData(int general) {
    ArrayList<DataHome> allDataArray = new ArrayList<>();
    if (general == 0) { // The Red Sea
      allDataArray.add(new DataHome(R.drawable.european, "European Eel", R.string.European_Eel));
      allDataArray.add(new DataHome(R.drawable.european, "European Eel", R.string.European_Eel));
      allDataArray.add(new DataHome(R.drawable.sturgeon, "Russian Sturgeon", R.string.Sturgeon));
    } else if (general == 1) { // The Mediterranean Sea
      allDataArray.add(
          new DataHome(
              R.drawable.mediterranean, "Mediterranean Monk Seal", R.string.Mediterranean));
    } else if (general == 2) { // nile
      allDataArray.add(
          new DataHome(
              R.drawable.mediterranean, "Mediterranean Monk Seal", R.string.Mediterranean));

    } else {
      // all data
    }

    return allDataArray;
  }

  public ArrayList<DataHome> nearest_Places() {
    ArrayList<DataHome> allDataArray = new ArrayList<>();
    allDataArray.add(new DataHome(R.drawable.european, "European Eel", R.string.European_Eel));
    allDataArray.add(new DataHome(R.drawable.european, "European Eel", R.string.European_Eel));
    allDataArray.add(new DataHome(R.drawable.european, "European Eel", R.string.European_Eel));
    allDataArray.add(new DataHome(R.drawable.european, "European Eel", R.string.European_Eel));
    allDataArray.add(new DataHome(R.drawable.european, "European Eel", R.string.European_Eel));
    return allDataArray;
  }

  public ArrayList<DataHome> swimming() {
    ArrayList<DataHome> allDataArray = new ArrayList<>();
    allDataArray.add(new DataHome(R.drawable.european, "European Eel", R.string.European_Eel));
    return allDataArray;
  }

  public ArrayList<DataHome> quality() {
    ArrayList<DataHome> allDataArray = new ArrayList<>();
    allDataArray.add(new DataHome(R.drawable.european, "European Eel", R.string.European_Eel));

    return allDataArray;
  }

  public ArrayList<DataHome> water_source() {
    ArrayList<DataHome> allDataArray = new ArrayList<>();
    return allDataArray;
  }
}
