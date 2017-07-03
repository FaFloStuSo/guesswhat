package io.github.faflostuso.guesswhat.gamelogic;

/**
 * Created by Fabian on 03.07.2017.
 */

public class Answer {

    private String answer;

    public Answer(String answerText){
        answer = answerText;
    }

    public String toString(){
        return answer;
    }
}
