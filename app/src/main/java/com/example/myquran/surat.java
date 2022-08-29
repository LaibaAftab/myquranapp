package com.example.myquran;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toolbar;

import com.google.android.material.navigation.NavigationView;

public class surat extends AppCompatActivity {

    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;
    ListView listview;
    ActionBarDrawerToggle actionBarDrawerToggle;

    //for clicking the toggle button on the top of left side
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if(actionBarDrawerToggle.onOptionsItemSelected(item))
        {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_surat);
        drawerLayout = findViewById(R.id.drawer);

        listview = findViewById(R.id.suratname);
        suratName sn = new suratName();
        String[] listSn = sn.englishSurahNames;
        int[] suratindex = sn.SSP;

        ArrayAdapter arrayAdapter = new ArrayAdapter<String>(surat.this, android.R.layout.simple_list_item_1,listSn);
        listview.setAdapter(arrayAdapter);

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent nextpage = new Intent(surat.this,ayaat.class);
                nextpage.putExtra("name",position);
                startActivity(nextpage);
            }
        });

        navigationView = findViewById(R.id.navigationView);
        actionBarDrawerToggle = new ActionBarDrawerToggle(this,drawerLayout,R.string.menu_Open,R.string.close_menu);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()) {
                    case R.id.surah:
                        Intent surah = new Intent(surat.this,surat.class);
                        startActivity(surah);
                        break;
                    case R.id.bookmark:
                        Intent home = new Intent(surat.this,MainActivity.class);
                        startActivity(home);
                        break;
                    case R.id.search:
                        Intent search = new Intent(surat.this,search.class);
                        startActivity(search);
                        break;
                }
                return true;
            }
        });

    }
}