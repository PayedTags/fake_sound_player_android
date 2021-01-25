package com.example.fakesoundplayer180075_180224;

import androidx.appcompat.app.AppCompatActivity;
import java.util.Date;
import android.os.Bundle;
import android.text.format.DateUtils;
import android.widget.ArrayAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    static final long ONE_MINUTE_IN_MILLIS=60000;//millisecs

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<Musica> playlist = new ArrayList<Musica>();

        Musica paranoid = new Musica("I prevail", "Paranoid", new Date(10 * ONE_MINUTE_IN_MILLIS));

        playlist.add(paranoid);

        ArrayAdapter<Musica> arrayAdapter = new ArrayAdapter<Musica>(this,)


    }
}