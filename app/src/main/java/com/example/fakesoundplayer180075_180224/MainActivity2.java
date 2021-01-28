package com.example.fakesoundplayer180075_180224;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {
    MediaPlayer player;
    int currentTime = 0; // variavel para guardar o tempo em que estamos na musica

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        getSupportActionBar().setTitle("Activity1");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        Intent intent = getIntent();

        final TextView txt_titulo = findViewById(R.id.txtview_Titulo);
        final ImageView img  = findViewById(R.id.img_Capa);
        final TextView txt_Autor = findViewById(R.id.txv_Autor);

        currentTime = intent.getIntExtra("currentTime", 0); // para ir buscar o tempo que estamos da musica quando voltarmos da outra atividade;
        int imagem = intent.getIntExtra("Imagem", 0);
        String autor = intent.getStringExtra("Autor");
        String titulo = intent.getStringExtra("Titulo");
        int segundos = intent.getIntExtra("Segundos", 0);

        txt_titulo.setText(titulo);
        txt_Autor.setText(autor);
        
        if(titulo.equals("Mood"))
        {
            player = MediaPlayer.create(this, R.raw.mood);
            img.setImageResource(R.drawable._mood);
        }

        if(titulo.equals("Paranoid")){
            player = MediaPlayer.create(this, R.raw.paranoid);
            img.setImageResource(R.drawable._9ed23aae5d5cee0646876189ad7dc06);
        }
        if(titulo.equals("Another life")){
            player = MediaPlayer.create(this, R.raw.another_life);
            img.setImageResource(R.drawable._36020b88ae8a1c11a5ce051e8318026);
        }
        if(titulo.equals("Bang!!")){
            player = MediaPlayer.create(this, R.raw.bang);
            img.setImageResource(R.drawable._bang);
        }

        player.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {
                stopPlayer();
            }
        });
        player.start();
        Button buttonPlayer = findViewById(R.id.btn_player);

        buttonPlayer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), MainActivity.class);
                i.putExtra("currentTime", currentTime); // para mandar o tempo que estamos da musica para a outra atividade (o footer)
                startActivity(i);
            }
        });

    }

    public void stopPlayer(){
        if(player != null)
        {
            player.release();
            player = null;
            Toast.makeText(this, "MediaPlayer released", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        stopPlayer();
    }

}