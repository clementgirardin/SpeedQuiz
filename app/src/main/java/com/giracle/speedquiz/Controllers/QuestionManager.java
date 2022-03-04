package com.giracle.speedquiz.Controllers;


import android.content.Context;
import com.giracle.speedquiz.Models.Question;
import java.util.List;
import java.util.Random;

public class QuestionManager {

//    private List<Question> questionList;
//
//    /**
//     * Constructeur de classe qui initialise une nouvelle liste de questions
//     * @param context Contexte d'application
//     */
////    public QuestionManager(Context context){
////        questionList = initQuestionList(context);
////    }
//
//    /**
//     * Liste des question
//     * @return Une Array List <Integer>*/
//    public List<Question> getQuestionList() {
//        return questionList;
//    }
//
//    /**
//     * Prned une question au hazard
//     * @param questionList ArrayList de questions
//     * @return un objet Question
//     */
//    public Question getRandomQuestion(List<Question> questionList){
//
//        int randomIndex = getQuestionIndex(questionList);
//        Question question = questionList.get(randomIndex);
//        questionList.remove(randomIndex);
//
//        return question;
//    }
//
//    /**
//     * Génère un indey aléatoire pour choisir une question
//     * @return un nombre entier
//     */
//    private int getQuestionIndex(List<Question> questionList){
//        Random rand = new Random();
//        return rand.nextInt(questionList.size());
//    }
//
//    /**
//     * Renvoi vrai si toutes les questions ont été posées
//     * @param questionList Une arraylist de questions
//     * @return Une valeur boolean
//     */
//    public boolean isLastQuestion(List<Question> questionList){
//        return questionList.isEmpty();
//    }
//
//    /**
//     * Regroupe toutes les questions
//     * @param questionList Tableaux pour la liste des questions
//     */
//    private void initQuestionList(List<Question> questionList){
//        questionList.add(new Question("Usain Bolt est l'athlète le plus médaillés aux championnats du monde", 1));
//        questionList.add(new Question("Iker Casillas et Manuel Neuer son les deux gardiens de foot les moins titrés du monde", 0));
//        questionList.add(new Question("Paris est meilleur que marseille", 1));
//        questionList.add(new Question("Le FC Barcelone est en europa league", 1));
//        questionList.add(new Question("Clash royale est un jeu dévelopé par activision", 0));
//        questionList.add(new Question("Les bonbons Haribo son fabriqués avec de la graisse de porc", 1));
//
//    }

}