package com.example.dscuiuxcasestudy;

import java.util.ArrayList;

public class RiddleDictionary {
    private static RiddleDictionary riddleDictionary;
    private ArrayList<Riddle> riddles;

    public static RiddleDictionary getInstance(){
        if(riddleDictionary==null) riddleDictionary=new RiddleDictionary();
        return riddleDictionary;
    }
    public ArrayList<Riddle> getRiddles() { return riddles; }
    public void generateRiddleData(){
        riddles = new ArrayList<>();
        riddles.add(new Riddle("Riddle me this?!", "Anggi Maisa",true));
        riddles.add(new Riddle("Riddle me this?!", "Fernando Christyanto", true));
        riddles.add(new Riddle("Riddle me this?!", "Jonathan Darwin", false));
        riddles.add(new Riddle("Riddle me this?!", "Naufal Prakoso", false));
        riddles.add(new Riddle("Riddle me this?!", "Willson", true));
    }
    private RiddleDictionary() { generateRiddleData(); }
}
