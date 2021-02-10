package com.example.fakesoundplayer180075_180224;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.media.Image;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.concurrent.TimeUnit;

import static com.example.fakesoundplayer180075_180224.R.string.Play;

public class MainActivity2 extends AppCompatActivity {
    MediaPlayer player;
    TextView durationTotal, durationPlayed, txt_titulo,txt_Autor;
    SeekBar seekBar;
    ImageView play,pause,img;
    int currentTime = 0; // variavel para guardar o tempo em que estamos na musica

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        getSupportActionBar().setTitle("Activity1");

        durationPlayed = findViewById(R.id.durationPlayed);
        durationTotal = findViewById(R.id.durationTotal);
        seekBar = findViewById(R.id.seekBar);
        play = findViewById(R.id.play);
        pause = findViewById(R.id.pause);
        txt_titulo = findViewById(R.id.txv_Titulo);
        img  = findViewById(R.id.img_Capa);
        txt_Autor = findViewById(R.id.txv_Autor);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        Intent intent = getIntent();

        currentTime = intent.getIntExtra("currentTime", 0); // para ir buscar o tempo que estamos da musica quando voltarmos da outra atividade;
        int imagem = intent.getIntExtra("Imagem", 0);
        String  autor = intent.getStringExtra("Autor");
        String titulo = intent.getStringExtra("Titulo");
        int segundos = intent.getIntExtra("Segundos", 0);
        int mp3 = intent.getIntExtra("selectedMp3",0);

        img.setImageResource(imagem);
        txt_Autor.setText(autor);
        txt_titulo.setText(titulo);


        Handler handler = new Handler();
        Runnable runnable;

        player = MediaPlayer.create(this, mp3);

        runnable = new Runnable() {
            @Override
            public void run() {
                seekBar.setProgress(player.getCurrentPosition());
                handler.postDelayed(this, 500);
            }
        };
        int duration = player.getDuration();
        String sDuration = convertFormat(duration);

        durationTotal.setText(sDuration);

        play.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v)
            {
                play.setVisibility(View.GONE);
                pause.setVisibility(View.VISIBLE);
                player.start();
                seekBar.setMax(player.getDuration());
                handler.postDelayed(runnable,0);
            }
        });

        pause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pause.setVisibility(View.GONE);
                play.setVisibility(View.VISIBLE);
                player.pause();
                handler.removeCallbacks(runnable);
            }
        });


        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                    if(b){
                        player.seekTo(i);
                    }
                durationPlayed.setText(convertFormat(player.getCurrentPosition()));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        player.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {
                pause.setVisibility(View.GONE);
                play.setVisibility(View.VISIBLE);
                player.seekTo(0);
            }
        });
    }

    @SuppressLint("DefaultLocale")
    private String convertFormat(int duration) {
        return String.format("%02d:%02d",
                TimeUnit.MILLISECONDS.toMinutes(duration)
                ,TimeUnit.MILLISECONDS.toSeconds(duration),
                TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(duration)));
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