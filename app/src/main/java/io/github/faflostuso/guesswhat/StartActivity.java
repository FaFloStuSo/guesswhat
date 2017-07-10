package io.github.faflostuso.guesswhat;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import io.github.faflostuso.guesswhat.gamelogic.GameService;

public class StartActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_start);

        //register on click listeners
        findViewById(R.id.gamemode_1_button).setOnClickListener(gamemode_OnClickListener);


    }

    //on click listener for gamemode Buttons
    final View.OnClickListener gamemode_OnClickListener = new View.OnClickListener() {
        public void onClick(final View v){
            Intent serviceIntent = new Intent(v.getContext(), io.github.faflostuso.guesswhat.gamelogic.GameService.class);
            Intent activityIntent = new Intent(v.getContext(), AddPlayerActivity.class);

            switch(v.getId()) {
                case R.id.gamemode_1_button:
                    serviceIntent.putExtra(GameService.GAMEMODE, GameService.GAMEMODE_1);
                    break;
            }

            startService(serviceIntent);
            startActivity(activityIntent);
        }
    };
}
