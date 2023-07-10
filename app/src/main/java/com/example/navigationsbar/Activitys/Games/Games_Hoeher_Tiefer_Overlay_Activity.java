package com.example.navigationsbar.Activitys.Games;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import com.example.navigationsbar.R;

import java.util.Timer;
import java.util.TimerTask;

public class Games_Hoeher_Tiefer_Overlay_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_hoeher_tiefer_overlay);

        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                finish();
            }
        }, 3000);
    }
}
