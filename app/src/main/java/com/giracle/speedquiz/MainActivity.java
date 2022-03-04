package com.giracle.speedquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private Button newPlayer;
    private Button jouer;
    private EditText playerOne;
    private EditText playerTwo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        newPlayer = findViewById(R.id.btn_newPlayer);
        jouer = findViewById(R.id.btn_jouer);
        playerOne = findViewById(R.id.player1);
        playerTwo = findViewById(R.id.player2);

    }

    @Override
    protected void onStart() {
        super.onStart();

        // rendre visible l'editText si qqun appui sur le bouton "nouveau joueur"
        newPlayer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (newPlayer.isActivated()){
                    playerOne.setVisibility(View.VISIBLE);
                } else {
                    playerOne.setVisibility(View.INVISIBLE);
                }
            }
        });

        // rendre visible l'editText pour le deuxieme joueur si le premier est rempli
        playerOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (playerOne.getText().length() == 0){
                    playerTwo.setVisibility(View.INVISIBLE);
                } else {
                    playerTwo.setVisibility(View.VISIBLE);
                }
            }
        });

        // rendre visible l'editText pour le deuxieme joueur si le  premier est rempli
        jouer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (playerOne.getText().length() == 0 && playerTwo.getText().length() == 0){
                    jouer.setClickable(false);
                } else {
                    jouer.setClickable(true);
                }
            }
        });

    }
//
//        if (newPlayer.isActivated()) {
//            playerOne.setVisibility(View.VISIBLE);
//        } else {
//            playerOne.setVisibility(View.INVISIBLE);
//        }


//        playerOne = findViewById(R.id.player1);
//        playerTwo = findViewById(R.id.player2);
//        playerOne.setVisibility(View.INVISIBLE);
//        playerTwo.setVisibility(View.INVISIBLE);
//
//        btn_newPlayer = findViewById(R.id.btn_newPlayer);
//
//        btn_newPlayer.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                playerOne.setVisibility(View.VISIBLE);
//            }
//        })
}