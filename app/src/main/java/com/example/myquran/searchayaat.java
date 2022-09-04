package com.example.myquran;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class searchayaat extends AppCompatActivity {
    ListView listView;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_searchayaat);
        listView=findViewById(R.id.searchayaat);
        Intent i = getIntent();
        String surah = i.getStringExtra("name");
        int position  = -1;

        suratName s = new suratName();
        int[] arr =s.SSP;
        QuranArabicText ayaat = new QuranArabicText();
        ArrayList<String> ayyats = new ArrayList<>();

        for(int j = 0;j<s.englishSurahNames.length;j++)
        {
            if(surah.equals(s.englishSurahNames[j]))
            {
                position = j;
                break;
            }
        }

        int start,endindex;
        if(position!=113)
        {
            start = arr[position];
            endindex = arr[position+1];
            endindex--;
        }
        else
        {
            start = ayaat.QuranArabicText.length-6;
            endindex =ayaat.QuranArabicText.length;
        }

        for(int j =start - 1;j<endindex;j++ )
        {
            ayyats.add(ayaat.QuranArabicText[j]);
        }

        ArrayAdapter<String> a = new ArrayAdapter<>(searchayaat.this,R.layout.urdutext,ayyats);
        listView.setAdapter(a);
    }
}