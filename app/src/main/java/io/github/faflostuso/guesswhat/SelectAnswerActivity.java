package io.github.faflostuso.guesswhat;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;

import io.github.faflostuso.guesswhat.gamelogic.PlayerAnswer;

public class SelectAnswerActivity extends AppCompatActivity {

    ArrayAdapter<PlayerAnswer> PlayerAnswerAdapter = new ArrayAdapter<>(this,
            R.layout.activity_select_answer, R.id.list_player_answers, .getPlayerAnswers);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_answer);
    }




}
