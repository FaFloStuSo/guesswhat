package io.github.faflostuso.guesswhat.gamelogic;

import java.util.ArrayList;

/**
 * Created by florian on 03.07.17.
 */

public class Game {
    public static final byte GAMEMODE_1 = 0;
    public static final int GAMEMODE_2 = 1;
    public final int POINTS_FOR_CORRECT_ANSWER;
    public final int POINTS_FOR_DECEIVING;
    private ArrayList<Question> unusedQuestion; //TODO als Set!
    private ArrayList<Player> players;
    private boolean gameActive;

    public Game(int points_for_correct_answer, int points_for_deceiving) {
        POINTS_FOR_CORRECT_ANSWER = points_for_correct_answer;
        POINTS_FOR_DECEIVING = points_for_deceiving;
    }

    public void addPlayer(){
        //TODO nur hinzufügen wenn Spiel noch nicht begonnen
    }

    public void addQuestion(Question question){
        //TODO exception werfen, wenn Frage schon vorhanden
        unusedQuestion.add(question);
    }

    public void startGame(){

    }

    public ArrayList<Player> getPlayers(){
        //TODO implement
        return null;
    }

    public boolean isGameActive(){
        return this.isGameActive();
    }
}
