package com.example.fakesoundplayer180075_180224;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity2 extends AppCompatActivity {

    int currentTime = 0; // variavel para guardar o tempo em que estamos na musica

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Intent intent = getIntent();

        currentTime = intent.getIntExtra("currentTime", 0); // para ir buscar o tempo que estamos da musica quando voltarmos da outra atividade;
        int imagem = intent.getIntExtra("Imagem", 0);
        String autor = intent.getStringExtra("Autor");
        String titulo = intent.getStringExtra("Titulo");
        int segundos = intent.getIntExtra("Segundos", 0);


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
}