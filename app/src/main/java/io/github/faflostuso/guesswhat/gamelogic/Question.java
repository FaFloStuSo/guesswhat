package io.github.faflostuso.guesswhat.gamelogic;

/**
 * Created by Fabian on 03.07.2017.
 */

public class Question {

    private String question;
    private Answer correctAnswer;

    public Question(String question, Answer correctAnswer){
        this.question = question;
        this.correctAnswer = correctAnswer;
    }

    public String toString(){
        return question;
    }

    public Answer getAnswer(){
        return correctAnswer;
    }

}
