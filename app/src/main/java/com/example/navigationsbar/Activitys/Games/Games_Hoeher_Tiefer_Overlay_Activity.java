package com.example.navigationsbar.Activitys.Games;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import com.example.navigationsbar.R;

import java.io.PrintStream;
import java.util.Timer;
import java.util.TimerTask;

public class Games_Hoeher_Tiefer_Overlay_Activity extends AppCompatActivity {

    private TextView textViewHighStreak;

    private ImageView imageViewCard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_hoeher_tiefer_overlay);
        textViewHighStreak = findViewById(R.id.textView17);
        imageViewCard = findViewById(R.id.imageViewKarten2);

        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                finish();
            }
        }, 3000);

        Intent intent = getIntent();
        int num = intent.getIntExtra("highStreak", 0);
        int rec = intent.getIntExtra("resourceID", 0);

        textViewHighStreak.setText("Deine beste Streak war: " + num);
        imageViewCard.setImageResource(rec);

    }

}
