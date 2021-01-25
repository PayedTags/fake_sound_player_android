package com.example.fakesoundplayer180075_180224;

import androidx.appcompat.app.AppCompatActivity;
import java.util.Date;

import android.annotation.SuppressLint;
import android.media.Image;
import android.os.Bundle;
import android.text.format.DateUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ArrayList<Musica> playlist = new ArrayList<Musica>();
    int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Musica paranoid = new Musica("I prevail", "Paranoid", 145, R.drawable._36020b88ae8a1c11a5ce051e8318026);
        while(count < 20)
        {
            playlist.add(paranoid);
            count++;
        }



        ListView listViewMusicas = findViewById(R.id.lstview_Musicas);
        ListAdapter adapter = new ListAdapter(this, playlist);

        listViewMusicas.setAdapter(adapter);


    }

}

