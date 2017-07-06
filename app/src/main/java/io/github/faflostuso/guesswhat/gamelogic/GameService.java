package io.github.faflostuso.guesswhat.gamelogic;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

import java.util.ArrayList;

public class GameService extends Service {
    public static final String GAMEMODE = "gamemode";
    public static final byte GAMEMODE_1 = 0;
    public static final int GAMEMODE_2 = 1;
    public final int POINTS_FOR_CORRECT_ANSWER;
    public final int POINTS_FOR_DECEIVING;
    private ArrayList<Question> unusedQuestion; //TODO als Set!
    private ArrayList<Player> players;
    private boolean gameActive;

    public GameService() {
        POINTS_FOR_CORRECT_ANSWER = 3; //TODO aus Einstellungen richtigen Wert auslesen
        POINTS_FOR_DECEIVING = 3;
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


    @Override
    public int onStartCommand(Intent intent, int flags, int startId){

        //TODO gamemode aus Intent nur nehmen und ändern, wenn Speil noch nicht aktiv

        //runs as long as it is not explicitly stopped
        return Service.START_STICKY;
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
