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

import static com.example.fakesoundplayer180075_180224.R.string.Play;

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

        TextView txt_titulo = findViewById(R.id.txv_Titulo);
        ImageView img  = findViewById(R.id.img_Capa);
        TextView txt_Autor = findViewById(R.id.txv_Autor);

        currentTime = intent.getIntExtra("currentTime", 0); // para ir buscar o tempo que estamos da musica quando voltarmos da outra atividade;
        int imagem = intent.getIntExtra("Imagem", 0);
        String  autor = intent.getStringExtra("Autor");
        String titulo = intent.getStringExtra("Titulo");
        int segundos = intent.getIntExtra("Segundos", 0);
        img.setImageResource(imagem);

        txt_Autor.setText(autor);
        txt_titulo.setText(titulo);
        Button buttonPlayer = findViewById(R.id.btn_player);
        buttonPlayer.setText(Play);
        buttonPlayer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(titulo.equals("Mood"))
                {
                    player = MediaPlayer.create(MainActivity2.this, R.raw.mood);
                }

                if(titulo.equals("Paranoid")){
                    player = MediaPlayer.create(MainActivity2.this, R.raw.paranoid);
                }

                if(titulo.equals("Another life")){
                    player = MediaPlayer.create(MainActivity2.this, R.raw.another_life);
                }

                if(titulo.equals("Bang!!")){
                    player = MediaPlayer.create(MainActivity2.this, R.raw.bang);
                }

                player.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mediaPlayer) {
                        stopPlayer();
                    }
                });
                player.start();

            }
        });

    }

    public void stopPlayer(){
        if(player != null)
        {
            player.release();
            player = null;
        }
    }

    @Override
    protected void onStop() {
        currentTime = player.getCurrentPosition();
        Intent i = new Intent(getApplicationContext(), MainActivity.class);
        i.putExtra("currentTime", currentTime); // para mandar o tempo que estamos da musica para a outra atividade (o footer)
        startActivity(i);
        super.onStop();
        stopPlayer();
    }

}