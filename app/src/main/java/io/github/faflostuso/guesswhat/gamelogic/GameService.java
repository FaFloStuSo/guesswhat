package io.github.faflostuso.guesswhat.gamelogic;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

public class GameService extends Service {
    public static final String GAMEMODE = "gamemode";

    public GameService() {
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId){

        Log.w("Test", "GameService Startet");

        //runs as long as it is not explicitly stopped
        return Service.START_STICKY;
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
