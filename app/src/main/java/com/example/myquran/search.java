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
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toolbar;

import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;

public class search extends AppCompatActivity {

    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;
    ActionBarDrawerToggle actionBarDrawerToggle;
    EditText editText;
    ImageButton imageButton;
    ListView listview;

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
        setContentView(R.layout.activity_search);

        suratName sn = new suratName();
        String[] listSn = sn.englishSurahNames;
        listview = findViewById(R.id.listonsearch);
        editText = findViewById(R.id.editTextTextPersonName);
        imageButton = findViewById(R.id.imageButton2);
        String s = editText.getText().toString();

        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ArrayList<String> suratonsearch = new ArrayList<>();
                String s = editText.getText().toString();
                if(s!=null)
                {
                    for(int i = 0;i<listSn.length;i++)
                    {
                        if(listSn[i].contains(s))
                        {
                            suratonsearch.add(listSn[i]);
                        }
                    }

                    ArrayAdapter arrayAdapter = new ArrayAdapter<String>(search.this, android.R.layout.simple_list_item_1,suratonsearch);
                    listview.setAdapter(arrayAdapter);

                    listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                            Intent nextpage = new Intent(search.this,searchayaat.class);
                            nextpage.putExtra("name",suratonsearch.get(position));
                            startActivity(nextpage);
                        }
                    });
                }
            }
        });



        drawerLayout = findViewById(R.id.drawer);

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
                        Intent surah = new Intent(search.this,surat.class);
                        startActivity(surah);
                        break;
                    case R.id.bookmark:
                        Intent home = new Intent(search.this,MainActivity.class);
                        startActivity(home);
                        break;
                    case R.id.search:
                        Intent search = new Intent(search.this,search.class);
                        startActivity(search);
                        break;
                }
                return true;
            }
        });

    }
}