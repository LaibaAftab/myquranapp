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

    public ArrayList<String> getAyaat()
    {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursorCourses = db.rawQuery("SELECT * FROM tayah" , null);

        ArrayList<String> n = new ArrayList<>();

        if (cursorCourses.moveToFirst()) {
            do {

                String s = cursorCourses.getString(3);
                String t = cursorCourses.getString(4);
                String line = s+"\n"+t;
                n.add(line);
            } while (cursorCourses.moveToNext());

        }

        cursorCourses.close();
        return  n;
    }

}
