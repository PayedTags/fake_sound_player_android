package com.example.fakesoundplayer180075_180224;

import androidx.appcompat.app.AppCompatActivity;
import java.util.Date;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.text.format.DateUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
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
    int currentTime = 0; // variavel para guardar o tempo em que estamos na musica

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Musica paranoid = new Musica("I prevail", "Paranoid", 145, R.drawable._36020b88ae8a1c11a5ce051e8318026);
        Musica AnotherLife = new Musica("Montionless in white", "Another life", 202, R.drawable._9ed23aae5d5cee0646876189ad7dc06);
        Musica Mood = new Musica("24kgoldn","Mood",141,R.drawable._mood);
        Musica Bang = new Musica("AJR","Bang!!",171,R.drawable._bang);

        while(count < 1)
        {
            playlist.add(paranoid);
            playlist.add(AnotherLife);
            playlist.add(Mood);
            playlist.add(Bang);
            count++;
        }


        ListAdapter adapter = new ListAdapter(this, playlist);

        ListView listViewMusicas = findViewById(R.id.lstview_Musicas);

        listViewMusicas.setAdapter(adapter);


        listViewMusicas.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Intent intent = new Intent(getApplicationContext(), MainActivity2.class);
                intent.putExtra("Imagem", playlist.get(position).getCapa());
                intent.putExtra("Autor", playlist.get(position).getAutor());
                intent.putExtra("Titulo", playlist.get(position).getTitulo());
                intent.putExtra("Segundos", playlist.get(position).getSegundos());
                intent.putExtra("currentTime", currentTime); // para mandar o tempo que estamos da musica para a outra atividade
                startActivityForResult(intent, 1);
            }
        });




       /* listViewMusicas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), MainActivity2.class);
                i.putExtra("currentTime", currentTime); // para mandar o tempo que estamos da musica para a outra atividade
                startActivity(i);
            }
        });*/
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        super.onActivityResult(requestCode, resultCode, data);
        // check if the request code is same as what is passed  here it is 2
        if(requestCode==1)
        {
            currentTime = data.getIntExtra("currentTime", 0);
        }
    }

}

