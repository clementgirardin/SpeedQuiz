package com.giracle.speedquiz;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import com.giracle.speedquiz.Controllers.QuestionManager;
import com.giracle.speedquiz.Models.Question;

public class GameActivity  extends AppCompatActivity {

    Button repondre1;
    Button repondre2;
    Button rejouer;
    Button menu;
    TextView questionJoueur1;
    TextView questionJoueur2;
    TextView scoreJoueur1;
    TextView scoreJoueur2;
    TextView nomJoueur1;
    TextView nomJoueur2;
    private int compteurScoreJ1;
    private int compteurScoreJ2;
    public Question currentQuestion;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        // récupération par ID des boutons
        repondre1 = findViewById(R.id.btn_repondreJoueur1);
        repondre2 = findViewById(R.id.btn_repondreJoueur2);
        rejouer = findViewById(R.id.btn_rejouer);
        menu = findViewById(R.id.btn_menu);
        questionJoueur1 = findViewById(R.id.tv_questionJoueur1);
        questionJoueur2 = findViewById(R.id.tv_questionJoueur2);
        scoreJoueur1 = findViewById(R.id.tv_scoreJoueur1);
        scoreJoueur2 = findViewById(R.id.tv_scoreJoueur2);
        nomJoueur1 = findViewById(R.id.tv_nomjoueur1);
        nomJoueur2 = findViewById(R.id.tv_nomjoueur2);
        Intent nomJoueurs = getIntent();
        // GLOBAL_VARIABLE
        Runnable questionRunnable = null;


        @Override
        protected void onStart(){
            super.onStart();
            nomJoueur1.setText(nomJoueurs.getStringExtra("joueur1"));
            nomJoueur2.setText(nomJoueurs.getStringExtra("joueur2"));
            gestQuestion();


            //Bouton du joueur 1 pour répondre aux questions (disponible durant le jeu)
            repondre1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (currentQuestion.isReponse() == 1) {
                        repondre1.setEnabled(false);
                        repondre2.setEnabled(false);
                        compteurScoreJ1++;
                        scoreJoueur1.setText(compteurScoreJ1);
                    } else if (compteurScoreJ1 > 0) {
                        compteurScoreJ1--;
                        scoreJoueur1.setText(compteurScoreJ1);
                    }
                }
            });

            //Bouton du joueur 2 pour répondre aux questions (disponible durant le jeu)
            repondre2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (currentQuestion.isReponse() == 1) {
                        repondre1.setEnabled(false);
                        repondre2.setEnabled(false);
                        compteurScoreJ2++;
                        scoreJoueur2.setText(compteurScoreJ2);
                    } else if (compteurScoreJ2 > 0) {
                        compteurScoreJ2--;
                        scoreJoueur2.setText(compteurScoreJ2);
                    }
                }
            });

        }

        public void gestQuestion() {
            QuestionManager questionListe = new QuestionManager(this);
            Handler handler = new Handler();
            questionRunnable = new Runnable() {
                @Override
                public void run() {
                    if (questionListe.isLastQuestion()) {
                        handler.removeCallbacks(this);
                        scoreJoueur1.setText("0");
                        scoreJoueur2.setText("0");
                        questionJoueur1.setText("");
                        questionJoueur2.setText("");
                    } else {
                        currentQuestion = questionListe.getRandomQuestion();
                        questionJoueur1.setText(currentQuestion.getQuestion());
                        questionJoueur2.setText(currentQuestion.getQuestion());
                        repondre1.setEnabled(true);
                        repondre2.setEnabled(true);
                        handler.postDelayed(this, 2000);
                    }
                }
            };
            handler.postDelayed(questionRunnable, 2000);
        }
    }
}
