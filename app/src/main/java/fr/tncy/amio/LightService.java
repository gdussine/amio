package fr.tncy.amio;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URL;
import java.util.Timer;
import java.util.TimerTask;

import fr.tncy.amio.model.LightItems;

public class LightService extends Service {

    private Timer timer;
    private TimerTask task;

    public LightService() {
    }
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        Log.d(this.getClass().getSimpleName(), "Création du service des lumières.");
        task =new TimerTask(){
            @Override
            public void run() {
                try {
                    URL url = new URL("http://iotlab.telecomnancy.eu:8080/iotlab/rest/data/1/light1/last");
                    LightItems lights = new ObjectMapper().readValue(url, LightItems.class);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        };
        timer = new Timer("LightServiceTimer");
        timer.schedule(task, 0, 30000L);
    }

    public void onDestroy(){
        Log.d(this.getClass().getSimpleName(), "Destruction du service des lumières.");
        task.cancel();
        timer.purge();
    }

}