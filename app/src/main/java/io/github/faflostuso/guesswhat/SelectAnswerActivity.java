package io.github.faflostuso.guesswhat;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;

import io.github.faflostuso.guesswhat.gamelogic.GameService;
import io.github.faflostuso.guesswhat.gamelogic.PlayerAnswer;

public class SelectAnswerActivity extends AppCompatActivity {

    private GameService mService;
    private boolean mBound;

    ArrayAdapter<PlayerAnswer> PlayerAnswerAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.);
    }

    @Override
    protected void onStart(){
        super.onStart();

        //binding to game service
        Intent intent = new Intent(this, GameService.class);
        bindService(intent, connection, Context.BIND_AUTO_CREATE);

        // TODO if service not bound, catch Exception
        PlayerAnswerAdapter = new ArrayAdapter<PlayerAnswer>(this,
                R.layout., R.id.list_player_answers, mService.getCurrentTurn().getPlayerAnswers());
    }

    private ServiceConnection connection = new ServiceConnection() {

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



    public View findListView(){
        LayoutInflater inflater = (LayoutInflater)this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View  rootView = inflater.inflate(R.layout., , false);

        AdapterView SelectedAnswersView = (ListView) rootView.findViewById(R.id.list_player_answers);
        SelectedAnswersView.setAdapter(PlayerAnswerAdapter);

        return rootView;
   }




}
