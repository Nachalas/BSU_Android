package com.example.lab3test;

import android.app.Service;
import android.content.Intent;
import android.graphics.Color;
import android.os.Binder;
import android.os.IBinder;
import android.widget.Button;

public class MainService extends Service {

    public class MainServiceBinder extends Binder {
        public MainService getService(){
            return MainService.this;
        }
    }

    @Override
    public IBinder onBind(Intent intent) {
        return new MainServiceBinder();
    }

    public void setRed(Button button) {
        button.setBackgroundColor(Color.RED);
    }

    public void setBlue(Button button) {
        button.setBackgroundColor(Color.BLUE);
    }

    public void setGreen(Button button) {
        button.setBackgroundColor(Color.parseColor("#009933"));
    }

    public void setBlack(Button button) {
        button.setBackgroundColor(Color.BLACK);
    }
}
