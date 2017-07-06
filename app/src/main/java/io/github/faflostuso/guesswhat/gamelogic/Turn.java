package io.github.faflostuso.guesswhat.gamelogic;

import android.graphics.drawable.AnimatedStateListDrawable;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by florian on 03.07.17.
 */

public class Turn {
    private Question question;
    private Game game;
    private HashMap<Player, PlayerAnswer> playerAnswers;
    private HashMap<Player, Answer> selectedAnswers;

    public Turn(Game game, Question question){
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
                player.addPoints(game.POINTS_FOR_CORRECT_ANSWER);
                winners.add(player);
            } else {
                //does not thorw ClassCastException because every answer that is not the correct answer is a PlayerAnswer
                answerGivenBy =((PlayerAnswer) selectedAnswer).getPlayer();
                answerGivenBy.addPoints(game.POINTS_FOR_DECEIVING);
                winners.add(answerGivenBy);
            }
        }

        return winners;
    }


}
