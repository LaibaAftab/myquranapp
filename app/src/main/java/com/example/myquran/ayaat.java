package com.example.myquran;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toolbar;

import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;

public class ayaat extends AppCompatActivity {



    ListView listview;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ayaat);

        listview = findViewById(R.id.listayaat);
        Intent i = getIntent();


        suratName s = new suratName();
        int[] arr =s.SSP;
        int startindex,endindex;
        QuranArabicText ayaat = new QuranArabicText();
        ArrayList<String> ayyats = new ArrayList<>();
        if(i.getIntExtra("name",0)!=113)
        {
            startindex = arr[i.getIntExtra("name",0)];
            endindex = arr[i.getIntExtra("name",0)+1];
            endindex--;
        }
        else
        {
            startindex = ayaat.QuranArabicText.length-6;
            endindex =ayaat.QuranArabicText.length;
        }

        for(int j =startindex - 1;j<endindex;j++ )
        {
            ayyats.add(ayaat.QuranArabicText[j]);
        }

        ArrayAdapter<String> a = new ArrayAdapter<>(ayaat.this,android.R.layout.simple_list_item_1,ayyats);
        listview.setAdapter(a);

    }
}