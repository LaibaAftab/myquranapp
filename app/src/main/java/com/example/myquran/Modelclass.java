package com.example.myquran;

public class Modelclass {

    private int number;
    private String arabic;
    private String trans;

    public Modelclass() {
        number = 0;
        arabic = "";
        trans = "";
    }

    public Modelclass(int n,String a,String t) {
        number = n;
        arabic = a;
        trans =  t;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getArabic() {
        return arabic;
    }

    public void setArabic(String arabic) {
        this.arabic = arabic;
    }

    public String getTrans() {
        return trans;
    }

    public void setTrans(String trans) {
        this.trans = trans;
    }
}
