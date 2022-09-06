package com.example.myquran;

public class modelsurah {

    private String english;
    private String urdu;

    public modelsurah()
    {
        english = "";
        urdu = "";
    }

    public modelsurah(String s,String m)
    {
        english = s;
        urdu = m;
    }

    public String getEnglish() {
        return english;
    }

    public String getUrdu() {
        return urdu;
    }

    public void setEnglish(String english) {
        this.english = english;
    }

    public void setUrdu(String urdu) {
        this.urdu = urdu;
    }
}
