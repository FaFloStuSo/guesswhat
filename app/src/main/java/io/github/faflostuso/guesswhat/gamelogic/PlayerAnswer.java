package io.github.faflostuso.guesswhat.gamelogic;

/**
 * Created by Fabian on 03.07.2017.
 */

public class PlayerAnswer extends Answer {

    private Player player;

    public PlayerAnswer(String answerText, Player player){
        super(answerText);
        this.player = player;
    }

    public Player getPlayer(){
        return player;
    }

}

