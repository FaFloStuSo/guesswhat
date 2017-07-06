package io.github.faflostuso.guesswhat.gamelogic;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

import java.util.ArrayList;
import java.util.Collections;

import io.github.faflostuso.guesswhat.Exceptions.PlayerAlreadyExistsException;

public class GameService extends Service {
    public static final String GAMEMODE = "mGamemode";
    public static final byte GAMEMODE_1 = 0;
    public static final byte GAMEMODE_2 = 1;
    private int pointsForCorrectAnswer;
    private int pointsForDeceiving;
    private ArrayList<Question> unusedQuestion;
    private ArrayList<Player> players;
    private boolean mStarted;
    private byte mGamemode;
    private final GameBinder mBinder = new GameBinder();
    //TODO wenn keine Activity im Vordergrund Service in Leiste tun

    @Override
    public void onCreate() {
        unusedQuestion = new ArrayList<Question>();
        players = new ArrayList<Player>();
        mStarted = false;

        //shuffle questions to ensure unique game each time
        Collections.shuffle(unusedQuestion);

        //initiate some variables for developing purposes only!
        pointsForCorrectAnswer = 3; //TODO aus Einstellungen richtigen Wert auslesen
        pointsForDeceiving = 3;

        //TODO aus XML auslesen (in anderem Thread!)
        String[] antworten = {
                "offensichtlich richtige Antowrt",
                "sehr schwere Antowrt",
                "Antwort 3",
                "hier muss man schon ganz schön gut sein"
        };
        String[] fragen = {
                "Was ist die offensichtlich richtige Antwort?",
                "Welche Antwort ist die schwerste?",
                "Antwort 3?",
                "Was ist die richtige Antwort?"
        };
        for (int i = 0; i < fragen.length; i++)
            addQuestion(new Question(fragen[i], new Answer(antworten[i])));
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId){
<<<<<<< HEAD
        //set mGamemode if game is not active
        if (!mStarted){
             this.mGamemode = intent.getByteExtra(GAMEMODE, (byte) 0 );
        }
=======

        Log.w("Test", "GameService Startet");
>>>>>>> 68a6840... added a Game Service

        //runs as long as it is not explicitly stopped
        return Service.START_STICKY;
    }

<<<<<<< HEAD
    /**
     * Class used for the client Binder, so clients can access public methods of GameService
     */
    public class GameBinder extends Binder {
        public GameService getService() {
            return GameService.this;
        }
    }

    @Override
    public IBinder onBind(Intent intent) {
        return mBinder;
    }

    private void addQuestion(Question question){
        //TODO exception werfen, wenn Frage schon vorhanden
        unusedQuestion.add(question);
    }

    /**
     * adds a Player to the game if game has not been started when called
     * @throws PlayerAlreadyExistsException, if player with the same name already exists
     */
    public void addPlayer(Player player) throws PlayerAlreadyExistsException{
        if(!mStarted){
            if(!players.contains(player)) {
                players.add(player);
            } else {
                throw new PlayerAlreadyExistsException("Player already exists");
            }
        }
    }

    public void startGame(){
        this.mStarted = true;
    }

    public ArrayList<Player> getPlayers(){
        //TODO implement
        return null;
    }

    public boolean isStarted(){
        return this.isStarted();
    }

    public int getPointsForCorrectAnswer() {
        return pointsForCorrectAnswer;
    }

    public int getPointsForDeceiving() {
        return pointsForDeceiving;
    }

=======
    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }
>>>>>>> 68a6840... added a Game Service
}
