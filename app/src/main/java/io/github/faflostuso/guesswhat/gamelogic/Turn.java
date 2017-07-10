package io.github.faflostuso.guesswhat.gamelogic;

import android.graphics.drawable.AnimatedStateListDrawable;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/**
 * Created by florian on 03.07.17.
 */

public class Turn {
    private Question question;
    private GameService game;
    private HashMap<Player, PlayerAnswer> playerAnswers;
    private HashMap<Player, Answer> selectedAnswers;

    public Turn(GameService game, Question question){
        this.game = game;
        this.question = question;
    }

    /**
     * evaluates Turn
     * @return winners of turn
     */
    private ArrayList<Player> evalTurn(){
        Answer selectedAnswer;
        Player answerGivenBy;
        ArrayList<Player> winners = new ArrayList<Player>();

        //check for each Player if s/he guessed right
        for(Player player : game.getPlayers()){
            selectedAnswer = selectedAnswers.get(player);

            if(selectedAnswer == question.getAnswer()){
                player.addPoints(game.getPointsForCorrectAnswer());
                winners.add(player);
            } else {
                //does not thorw ClassCastException because every answer that is not the correct answer is a PlayerAnswer
                answerGivenBy =((PlayerAnswer) selectedAnswer).getPlayer();
                answerGivenBy.addPoints(game.getPointsForDeceiving());
                winners.add(answerGivenBy);
            }
        }

        return winners;
    }

    public void setPlayerAnswer(Player player, Answer answer){

    }

    public ArrayList<PlayerAnswer> getPlayerAnswers(){
        return new ArrayList<PlayerAnswer>(Arrays.asList((PlayerAnswer[]) this.playerAnswers.entrySet().toArray()));
    }

}
