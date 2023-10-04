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
      allDataArray.add(new DataHome(R.drawable.sea_cucumber, "Sea Cucumber", R.string.Sea_Cucumber));
      allDataArray.add(new DataHome(R.drawable.mangrove_tress, "Mangrove Tress", R.string.Mangrove_Tress));
      allDataArray.add(new DataHome(R.drawable.manate, "Mante", R.string.Manate));
      allDataArray.add(new DataHome(R.drawable.sawfish, "Saw fish", R.string.Sawfish));
    } else if (general == 1) { // The Mediterranean Sea
      allDataArray.add(
          new DataHome(R.drawable.european, "European", R.string.European_Eel));
      allDataArray.add(new DataHome(R.drawable.mediterranean, "Mediterranean Monk Seal", R.string.Mediterranean));
      allDataArray.add(new DataHome(R.drawable.sturgeon, "Russian Sturgeon", R.string.Sturgeon));
      allDataArray.add(new DataHome(R.drawable.bluefin, "Blue Fin", R.string.Blue_Fin));
      allDataArray.add(new DataHome(R.drawable.mantaray, "Manta Ray", R.string.Manta_Ray));
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
      allDataArray.add(new DataHome(R.drawable.redsea, "Red Sea", R.string.Red_Sea));
      allDataArray.add(new DataHome(R.drawable.gulfofsuez, "Gulf of Suez", R.string.Gulf_of_Suez));
      allDataArray.add(new DataHome(R.drawable.wadi_elgemal_reserve, "Wadi El Gemal Reserve", R.string.Wadi_El_Gemal_Reserve));
      allDataArray.add(new DataHome(R.drawable.ras_nasrani, "Coasts Of Narani Reserve", R.string.Coasts_Of_Ras_Nasrani_Reserve));
      allDataArray.add(new DataHome(R.drawable.ras_mohamed, "Ras Mohamed", R.string.Ras_Mohammed_Reserve));


    }else if(general==1){// white sea
      allDataArray.add(new DataHome(R.drawable.mediterraneansea, "Mediterranean Sea", R.string.Mediterranean_Sea));
      allDataArray.add(new DataHome(R.drawable.whitesea, "Northern Coasts", R.string.Northern_Coasts));
      allDataArray.add(new DataHome(R.drawable.sinai, "North Sinai Coasts", R.string.North_Sinai_Coasts));



    }else if(general==2){//nile
      allDataArray.add(new DataHome(R.drawable.nile, "Nile Delta Region", R.string.Nile_Delta_Region));
      allDataArray.add(new DataHome(R.drawable.warraq, "Warraq", R.string.Warraq_Island));


    }else {
      //red +white +nile
    }
    return allDataArray;
  }public ArrayList<DataHome> swimming() {
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
    allDataArray.add(new DataHome(R.drawable.vaquita, "Vaquita", R.string.Vaquita));
    allDataArray.add(new DataHome(R.drawable.right_whale, "North Atlantic Right Whale", R.string.North_Atlantic_right_whale));
    allDataArray.add(new DataHome(R.drawable.kemps, "Kemps Ridley Sea Turtle", R.string.Kemps_Ridley_Sea_Turtle));
    allDataArray.add(new DataHome(R.drawable.blue_whale, "Blue Whale", R.string.Blue_Whale));
    allDataArray.add(new DataHome(R.drawable.great_white_shark, "The Great White Shark", R.string.The_Great_White_Shark));
    allDataArray.add(new DataHome(R.drawable.beluga, "Beluga", R.string.Beluga));
    allDataArray.add(new DataHome(R.drawable.seaturtle, "Sea Turtle", R.string.Loggerhead_Sea_Turtle));
    allDataArray.add(new DataHome(R.drawable.turtles, "Turtles", R.string.Turtles));
    allDataArray.add(new DataHome(R.drawable.caribbean, "Caribbean", R.string.Caribbean));
    allDataArray.add(new DataHome(R.drawable.fin_whale, "Fin Whale", R.string.Fin_Whale));
    allDataArray.add(new DataHome(R.drawable.hectors_dolphin, "Hectors Dolphin", R.string.Hectors_Dolphin));
    return allDataArray;
  }
  public ArrayList<DataHome> all(int general) {
    ArrayList<DataHome> allDataArray = new ArrayList<>();
    if (general == 0) { // The Red Sea
      allDataArray.add(new DataHome(R.drawable.seaturtle, "Sea Turtle", R.string.Sea_Turtle));
      allDataArray.add(new DataHome(R.drawable.dugong, "Dugong", R.string.Dugong));
      allDataArray.add(new DataHome(R.drawable.whaleshark, "Whale Shark", R.string.Whale_Shark));
      allDataArray.add(new DataHome(R.drawable.redsea, "Red Sea", R.string.Red_Sea));
      allDataArray.add(new DataHome(R.drawable.gulfofsuez, "Gulf of Suez", R.string.Gulf_of_Suez));
      allDataArray.add(new DataHome(R.drawable.wadi_elgemal_reserve, "Wadi El Gemal Reserve", R.string.Wadi_El_Gemal_Reserve));
      allDataArray.add(new DataHome(R.drawable.swimming, "First Advice", R.string.First_Advice));
      allDataArray.add(new DataHome(R.drawable.suncream, "Second Advice", R.string.Second_Advice));
      allDataArray.add(new DataHome(R.drawable.fishing, "Third Advice", R.string.Third_Advice));
      allDataArray.add(new DataHome(R.drawable.aquatic, "Fourth Advice", R.string.Fourth_Advice));
      allDataArray.add(new DataHome(R.drawable.hook, "Fifth Advice", R.string.Fifth_Advice));
      allDataArray.add(new DataHome(R.drawable.redsea, "Red Sea", R.string.The_Red_Sea));
      allDataArray.add(new DataHome(R.drawable.sea_cucumber, "Sea Cucumber", R.string.Sea_Cucumber));
      allDataArray.add(new DataHome(R.drawable.mangrove_tress, "Mangrove Tress", R.string.Mangrove_Tress));
      allDataArray.add(new DataHome(R.drawable.manate, "Mante", R.string.Manate));
      allDataArray.add(new DataHome(R.drawable.sawfish, "Saw fish", R.string.Sawfish));

    }else if(general==1){ // The Mediterranean Sea
      new DataHome(R.drawable.european, "European", R.string.European_Eel);
      allDataArray.add(new DataHome(R.drawable.mediterraneansee, "Mediterranean Monk Seal", R.string.Mediterranean));
      allDataArray.add(new DataHome(R.drawable.sturgeon, "Russian Sturgeon", R.string.Sturgeon));
      allDataArray.add(new DataHome(R.drawable.mediterraneansea, "Mediterranean Sea", R.string.Mediterranean_Sea));
      allDataArray.add(new DataHome(R.drawable.swimming, "First Advice", R.string.First_Advice));
      allDataArray.add(new DataHome(R.drawable.suncream, "Second Advice", R.string.Second_Advice));
      allDataArray.add(new DataHome(R.drawable.fishing, "Third Advice", R.string.Third_Advice));
      allDataArray.add(new DataHome(R.drawable.aquatic, "Fourth Advice", R.string.Fourth_Advice));
      allDataArray.add(new DataHome(R.drawable.hook, "Fifth Advice", R.string.Fifth_Advice));
      allDataArray.add(new DataHome(R.drawable.mediterraneansee, "Mediterranean", R.string.The_Mediterranean_Sea));
      allDataArray.add(new DataHome(R.drawable.mantaray, "Manta Ray", R.string.Manta_Ray));
      allDataArray.add(new DataHome(R.drawable.bluefin, "Blue Fin", R.string.Blue_Fin));


    }else if(general==2){// nile
      allDataArray.add(
              new DataHome(
                      R.drawable.native_fish, "Native Fish", R.string.Native_Fish));
      allDataArray.add(new DataHome(R.drawable.dugong, "Dugong", R.string.Dugong));
      allDataArray.add(new DataHome(R.drawable.hippopotamus, "Hippopotamus", R.string.Hippopotamus));
      allDataArray.add(new DataHome(R.drawable.swimming, "First Advice", R.string.First_Advice));
      allDataArray.add(new DataHome(R.drawable.suncream, "Second Advice", R.string.Second_Advice));
      allDataArray.add(new DataHome(R.drawable.fishing, "Third Advice", R.string.Third_Advice));
      allDataArray.add(new DataHome(R.drawable.aquatic, "Fourth Advice", R.string.Fourth_Advice));
      allDataArray.add(new DataHome(R.drawable.hook, "Fifth Advice", R.string.Fifth_Advice));
      allDataArray.add(new DataHome(R.drawable.nile_river, "Nile River", R.string.The_Nile_Rive));

    }

    return allDataArray;
  }

}