package io.github.faflostuso.guesswhat;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import io.github.faflostuso.guesswhat.Exceptions.PlayerAlreadyExistsException;
import io.github.faflostuso.guesswhat.gamelogic.GameService;
import io.github.faflostuso.guesswhat.gamelogic.Player;

public class AddPlayerActivity extends AppCompatActivity {
    private GameService mService;
    private boolean mBound;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_player);
    }

    @Override
    protected void onStart(){
        super.onStart();

        //binding to game service
        Intent intent = new Intent(this, GameService.class);
        bindService(intent, connection, Context.BIND_AUTO_CREATE);

        //register listeners
        findViewById(R.id.add_player_button).setOnClickListener(btnListener);
    }

    @Override
    protected void onStop(){
        super.onStop();

        //unbind from game service
        if (mBound){
            unbindService(connection);
            mBound = false;
        }
    }


    /** Defines callbacks for service binding, passed to bindService() */
    private ServiceConnection connection = new ServiceConnection() {
        //TODO implement ServiceConnection in extra file

        @Override
        public void onServiceConnected(ComponentName className,
                                       IBinder service) {
            // get game service instance
            GameService.GameBinder binder = (GameService.GameBinder) service;
            mService = binder.getService();
            mBound = true;
        }

        @Override
        public void onServiceDisconnected(ComponentName arg0) {
            mBound = false;
        }
    };

    private final View.OnClickListener btnListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            EditText textView = (EditText) findViewById(R.id.player_name_edittext);

            switch (v.getId()){
                case R.id.add_player_button: //TODO soll auch über DONE button aufgerufen werden
                    addPlayer(textView.getText().toString());
                    break;
            }
        }
    };

    /**
     * checks if player name is valid and creates player object or shows error message
     * @Name
     */
    private void addPlayer(String Name){
        //hide error messages
        findViewById(R.id.addplayer_error_textview).setVisibility(View.GONE);


        if(Name.matches("[A-Za-z0-9]+")) { //TODO Umlaute, Accents und Co erlauben
            try{
                mService.addPlayer(new Player(Name));
            } catch (PlayerAlreadyExistsException e){
                showErrorMessage(getResources().getString(R.string.name_already_exists));
            }
        } else {
            showErrorMessage(getResources().getString(R.string.allowed_chars));
        }
    }

    private void showErrorMessage(String msg){
        TextView textView = (TextView) findViewById(R.id.addplayer_error_textview);

        textView.setText(msg);
        textView.setVisibility(View.VISIBLE);
    }
}
