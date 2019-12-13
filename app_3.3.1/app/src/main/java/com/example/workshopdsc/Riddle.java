package com.example.workshopdsc;

public class Riddle {
    public String riddle;
    public String asker;
    public boolean answer;

    public Riddle(String riddle, String asker, boolean answer) {
        this.riddle = riddle;
        this.asker = asker;
        this.answer = answer;
    }

    public String getRiddle() {
        return riddle;
    }

    public void setRiddle(String riddle) {
        this.riddle = riddle;
    }

    public String getAsker() {
        return asker;
    }

    public void setAsker(String asker) {
        this.asker = asker;
    }

    public boolean isAnswer() {
        return answer;
    }

    public void setAnswer(boolean answer) {
        this.answer = answer;
    }
}
