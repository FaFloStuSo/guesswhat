package io.github.faflostuso.guesswhat.gamelogic;

/**
 * Created by florian on 03.07.17.
 */

public class Game {
    public final int POINTS_FOR_CORRECT_ANSWER;
    public final int POINTS_FOR_DECEIVING;

    public Game(int points_for_correct_answer, int points_for_deceiving) {
        POINTS_FOR_CORRECT_ANSWER = points_for_correct_answer;
        POINTS_FOR_DECEIVING = points_for_deceiving;
    }
}
