package com.example.myquran;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.EditText;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class DBHelper extends SQLiteOpenHelper {



    public DBHelper(@Nullable Context context) {
        super(context, "Quran.db", null, 1);
    }

    public DBHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTableSTatement =
                "CREATE TABLE " +
                        "'tayah' ( 'AyaID' INTEGER,'SuraID' INTEGER, 'AyaNo'	INTEGER, 'ArabicText' TEXT, 'FatehMuhammadJalandhri' TEXT, 'MehmoodulHassan' TEXT, 'DrMohsinKhan' TEXT, 'MuftiTaqiUsmani' TEXT, 'RakuID' INTEGER, 'PRakuID' INTEGER, 'ParaID' INTEGER)";
        db.execSQL(createTableSTatement);
        String createTable2STatement =
                " CREATE TABLE " +
                        "'tsurah' ( 'SurahID' INTEGER, 'SurahIntro' TEXT, 'SurahNameE' TEXT, 'Nazool' TEXT, 'SurahNameU' TEXT)";
        db.execSQL(createTable2STatement);
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF " +
                "EXISTS " + "tsurah");
        db.execSQL("DROP TABLE IF " +
                "EXISTS " + "tayah");
        onCreate(db);
    }

    public void  addStudent(){
        SQLiteDatabase db = this.getWritableDatabase();
        db.close();
    }

    public ArrayList<String> getAyaat(int i,int index)
    {
        SQLiteDatabase db = this.getReadableDatabase();


        Cursor cursorCourses = db.rawQuery("SELECT * FROM tayah where SuraID ="+i , null);
        //Cursor cursorCourses = db.rawQuery("SELECT * FROM tayah", null);
        ArrayList<String> n = new ArrayList<>();

        if (cursorCourses.moveToFirst()) {
            do {

                String s = cursorCourses.getString(3);
                String t = cursorCourses.getString(index);
                //String u = cursorCourses.getString(6);
                String line ="\n"+ s+"\n"+t;
                n.add(line);
            } while (cursorCourses.moveToNext());
        }
        cursorCourses.close();
        return  n;
    }

    public ArrayList<Modelclass> getAyaat()
    {
        SQLiteDatabase db = this.getReadableDatabase();


        Cursor cursorCourses = db.rawQuery("SELECT * FROM tayah" , null);
        //Cursor cursorCourses = db.rawQuery("SELECT * FROM tayah", null);
        ArrayList<Modelclass> n = new ArrayList<>();

        if (cursorCourses.moveToFirst()) {
            do {

//                String s = cursorCourses.getString(3);
//                String t = cursorCourses.getString(index);
//                //String u = cursorCourses.getString(6);
//                String line ="\n"+ s+"\n"+t;
                n.add(new Modelclass(cursorCourses.getInt(2),cursorCourses.getString(3),cursorCourses.getString(4)));
            } while (cursorCourses.moveToNext());
        }
        cursorCourses.close();
        return  n;
    }

    public ArrayList<Modelclass> getAyaat(int i)
    {
        SQLiteDatabase db = this.getReadableDatabase();


        Cursor cursorCourses = db.rawQuery("SELECT * FROM tayah" , null);
        //Cursor cursorCourses = db.rawQuery("SELECT * FROM tayah", null);
        ArrayList<Modelclass> n = new ArrayList<>();

        if (cursorCourses.moveToFirst()) {
            do {

//                String s = cursorCourses.getString(3);
//                String t = cursorCourses.getString(index);
//                //String u = cursorCourses.getString(6);
//                String line ="\n"+ s+"\n"+t;
                n.add(new Modelclass(cursorCourses.getInt(2),cursorCourses.getString(3),cursorCourses.getString(i)));
            } while (cursorCourses.moveToNext());
        }
        cursorCourses.close();
        return  n;
    }

    public ArrayList<modelsurah> getsurah()
    {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("Select * from tsurah",null);
        ArrayList<modelsurah> m = new ArrayList<>();
        if (cursor.moveToNext())
        {
            do{
                m.add(new modelsurah(cursor.getString(2),cursor.getString(4)));
            }while(cursor.moveToNext());
        }
        cursor.close();
        return m;
    }

    public int getSURAHID(String s)
    {
        SQLiteDatabase DB = getReadableDatabase();
        int i = -1;
        Cursor cursor = DB.rawQuery("Select * from tsurah where SurahNameE ='"+s+"'",null);
        if(cursor.moveToNext())
        {

                i = cursor.getInt(0);

        }
        return i;
    }

    public ArrayList<Modelclass> getAyaa(int i,int index)
    {
        SQLiteDatabase db = this.getReadableDatabase();


        Cursor cursorCourses = db.rawQuery("SELECT * FROM tayah where SuraID ="+i , null);
        ArrayList<Modelclass> n = new ArrayList<>();

        if (cursorCourses.moveToFirst()) {
            do {

                n.add(new Modelclass(cursorCourses.getInt(2),cursorCourses.getString(3),cursorCourses.getString(index)));
            } while (cursorCourses.moveToNext());
        }
        cursorCourses.close();
        return  n;
    }

}
