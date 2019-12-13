package com.example.workshopdsc;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class RiddleDictionary {
    private static RiddleDictionary riddleDictionary;
    private ArrayList<Riddle> riddles;

    protected void generateRiddleData(){
        riddles = new ArrayList<>();
        riddles.add(new Riddle("Riddle me this?!", "John Doe", true));
        riddles.add(new Riddle("Riddle me this?!", "John Doe1", false));
        riddles.add(new Riddle("Riddle me this?!", "John Doe2", true));
        riddles.add(new Riddle("Riddle me this?!", "John Doe3", false));
    }

    public ArrayList<Riddle> getRiddles(){ return riddles; }
    public static RiddleDictionary getInstance(){
        if(riddleDictionary == null) riddleDictionary = new RiddleDictionary();
        return riddleDictionary;
    }

    public RiddleDictionary() {
        generateRiddleData();
    }
}
