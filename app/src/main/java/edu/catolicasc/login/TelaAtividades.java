package edu.catolicasc.login;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import edu.catolicasc.login.Pokemon.TelaPokemon;
import edu.catolicasc.login.Timer.TimerLoko;

public class TelaAtividades extends AppCompatActivity {

    private Button button;
    private Button buttonTempo;
    private Button buttonPokemon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_atividades);

        button = findViewById(R.id.buttonLista);
        buttonTempo = findViewById(R.id.buttonTimer);
        buttonPokemon = findViewById(R.id.buttonPokedex);

        button.setOnClickListener(onClickListener);
        buttonTempo.setOnClickListener(onClickListenerTimer);
        buttonPokemon.setOnClickListener(onClickListenerPokedex);

    }


    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            Intent intent = new Intent(TelaAtividades.this, Lista.class);
            startActivity(intent);
        }
    };


    View.OnClickListener onClickListenerTimer = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            Intent intent = new Intent(TelaAtividades.this, TimerLoko.class);
            startActivity(intent);
        }
    };

    View.OnClickListener onClickListenerPokedex = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

             Intent intent = new Intent(TelaAtividades.this, TelaPokemon.class);
             startActivity(intent);
        }
    };


}
