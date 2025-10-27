package com.example.lab5_bsmith179_2;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        // Enable action bar logo
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayShowHomeEnabled(true);
            getSupportActionBar().setLogo(R.mipmap.ic_launcher);
            getSupportActionBar().setDisplayUseLogoEnabled(true);
        }

        // List view setup
        String[] attraction = new String[]{"Art Institute of Chicago", "Magnificent Mile", "Willis Tower", "Chicago Bean", "Water Tower"};
        listView = findViewById(R.id.listView);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_checked, android.R.id.text1, attraction);
        listView.setAdapter(adapter);

        // Handle user interaction with the list
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch(position){
                    // Label the list options to reduce future confusion
                    case 0:
                        // Open URL in browser window
                        startActivity (new Intent(Intent.ACTION_VIEW, Uri.parse ("http://artic.edu ")));
                        break;

                    case 1:
                        // it goes here
                        startActivity (new Intent(Intent.ACTION_VIEW, Uri.parse ("http://themagnificentmile.com ")));
                        break;

                    case 2:
                        // it goes here

                        break;

                    case 3:
                        // it goes here

                        break;

                    case 4:
                        // it goes here

                        break;

                }
            }
        });
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}