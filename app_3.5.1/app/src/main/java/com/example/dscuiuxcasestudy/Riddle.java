package com.example.dscuiuxcasestudy;

public class Riddle {
    String riddle;
    String asker;
    boolean answer;

    public Riddle(String riddle, String asker, boolean answer){
        this.riddle=riddle;
        this.asker=asker;
        this.answer=answer;
    }

    public void setQuestion(String riddle){ this.riddle=riddle; }
    public String getQuestion(){ return this.riddle; }
    public void setAsker(String asker){ this.asker=asker; }
    public String getAsker(){ return this.asker; }
    public void setAnswer(boolean answer){ this.answer=answer; }
    public boolean isAnswered(){ return answer; }
}
