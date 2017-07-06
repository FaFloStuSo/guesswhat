package io.github.faflostuso.guesswhat;

import android.app.ActionBar;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import io.github.faflostuso.guesswhat.gamelogic.Game;
import io.github.faflostuso.guesswhat.gamelogic.GameService;

public class StartActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_start);

        //register on click listeners
        findViewById(R.id.gamemode_1_button).setOnClickListener(gm1Button_OnClickListener);


    }

    //on click listener for gamemode Buttons
    final View.OnClickListener gm1Button_OnClickListener = new View.OnClickListener() {
        public void onClick(final View v){
            Intent i = new Intent(v.getContext(), io.github.faflostuso.guesswhat.gamelogic.GameService.class);

            switch(v.getId()) {
                case R.id.gamemode_1_button:
                    i.putExtra(GameService.GAMEMODE, Game.GAMEMODE_1);
                    break;
            }

            startService(i);
        }
    };
}
