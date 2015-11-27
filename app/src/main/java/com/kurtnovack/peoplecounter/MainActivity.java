package com.kurtnovack.peoplecounter;

import android.app.Activity;
import android.os.Bundle;
import android.support.wearable.view.WatchViewStub;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends Activity {

    private TextView counterLabel;
    int counter = 0;

    public void reset(View view) {
        counter = 0;
        counterLabel.setText(String.valueOf(counter));
    }

    public void addPerson(View view) {
        counter++;
        counterLabel.setText(String.valueOf(counter));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final WatchViewStub stub = (WatchViewStub) findViewById(R.id.watch_view_stub);
        stub.setOnLayoutInflatedListener(new WatchViewStub.OnLayoutInflatedListener() {
            @Override
            public void onLayoutInflated(WatchViewStub stub) {
                counterLabel = (TextView) findViewById(R.id.counter);
            }
        });
    }
}
