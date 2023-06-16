package com.example.navigationsbar.Activitys.Questions;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.navigationsbar.Activitys.GameDataSingelton;
import com.example.navigationsbar.Adapter.PlayCardAdapter;
import com.example.navigationsbar.Items.Spielkarten.SpielKarten;
import com.example.navigationsbar.R;

import java.util.ArrayList;
import java.util.List;

public class QuestionFourActivity extends AppCompatActivity {

    private RecyclerView herzRecyclerView, karoRecyclerView, pikRecyclerView, kreuzRecyclerView;
    private List<Integer> selectedHerzPositions = new ArrayList<>();
    private List<Integer> selectedKaroPositions = new ArrayList<>();
    private List<Integer> selectedPikPositions = new ArrayList<>();
    private List<Integer> selectedKreuzPositions = new ArrayList<>();
    private GameDataSingelton gameDataSingelton; // Das GameData-Objekt als Feld deklarieren

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.question4_layout);
        gameDataSingelton = GameDataSingelton.getInstance();

            // Herz RecyclerView
        herzRecyclerView = findViewById(R.id.HerzRecyclerView);
        herzRecyclerView.setHasFixedSize(true);
        herzRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        List<SpielKarten> herzList = new ArrayList<>();
        herzList.add(new SpielKarten(R.drawable.herz_zwei, "Herz Zwei"));
        herzList.add(new SpielKarten(R.drawable.herz_drei, "Herz Drei"));
        herzList.add(new SpielKarten(R.drawable.herz_vier, "Herz Vier"));
        herzList.add(new SpielKarten(R.drawable.herz_fuenf, "Herz Fünf"));
        herzList.add(new SpielKarten(R.drawable.herz_sechs, "Herz Sechs"));
        herzList.add(new SpielKarten(R.drawable.herz_sieben, "Herz Sieben"));
        herzList.add(new SpielKarten(R.drawable.herz_acht, "Herz Acht"));
        herzList.add(new SpielKarten(R.drawable.herz_neun, "Herz Neun"));
        herzList.add(new SpielKarten(R.drawable.herz_zehn, "Herz Zehn"));
        herzList.add(new SpielKarten(R.drawable.herz_bube, "Herz Bube"));
        herzList.add(new SpielKarten(R.drawable.herz_dame, "Herz Dame"));
        herzList.add(new SpielKarten(R.drawable.herz_koenig, "Herz König"));
        herzList.add(new SpielKarten(R.drawable.herz_ass, "Herz Ass"));
        PlayCardAdapter herzAdapter = new PlayCardAdapter(herzList);
        herzRecyclerView.setAdapter(herzAdapter);

            // Logik für Return button
        TextView buttonReturn = findViewById(R.id.textView_back);
        buttonReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

            // Logik für Confirm button
        Button button_confirm = findViewById(R.id.button_confirm2);
        button_confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startNextActivity();
            }
        });


        // -------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
        herzAdapter.setOnItemClickListener(new PlayCardAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(SpielKarten spielkarte, int position) {
                if (selectedHerzPositions.contains(position)) {
                    selectedHerzPositions.remove(Integer.valueOf(position));
                } else {
                    selectedHerzPositions.add(position);
                }
                herzAdapter.notifyDataSetChanged();
                gameDataSingelton.setSelectedHerzCards(selectedHerzPositions);
            }
        });

            // Karo RecyclerView
        karoRecyclerView = findViewById(R.id.KaroRecyclerView);
        karoRecyclerView.setHasFixedSize(true);
        karoRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        List<SpielKarten> karoList = new ArrayList<>();
        karoList.add(new SpielKarten(R.drawable.karo_zwei, "Karo Zwei"));
        karoList.add(new SpielKarten(R.drawable.karo_drei, "Karo Drei"));
        karoList.add(new SpielKarten(R.drawable.karo_vier, "Karo Vier"));
        karoList.add(new SpielKarten(R.drawable.karo_fuenf, "Karo Fünf"));
        karoList.add(new SpielKarten(R.drawable.karo_sechs, "Karo Sechs"));
        karoList.add(new SpielKarten(R.drawable.karo_sieben, "Karo Sieben"));
        karoList.add(new SpielKarten(R.drawable.karo_acht, "Karo Acht"));
        karoList.add(new SpielKarten(R.drawable.karo_neun, "Karo Neun"));
        karoList.add(new SpielKarten(R.drawable.karo_zehn, "Karo Zehn"));
        karoList.add(new SpielKarten(R.drawable.karo_bube, "Karo Bube"));
        karoList.add(new SpielKarten(R.drawable.karo_dame, "Karo Dame"));
        karoList.add(new SpielKarten(R.drawable.karo_koenig, "Karo König"));
        karoList.add(new SpielKarten(R.drawable.karo_ass, "Karo Ass"));
        PlayCardAdapter karoAdapter = new PlayCardAdapter(karoList);
        karoRecyclerView.setAdapter(karoAdapter);

        karoAdapter.setOnItemClickListener(new PlayCardAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(SpielKarten spielkarte, int position) {
                if (selectedKaroPositions.contains(position)) {
                    selectedKaroPositions.remove(Integer.valueOf(position));
                } else {
                    selectedKaroPositions.add(position);
                }
                karoAdapter.notifyDataSetChanged();
                gameDataSingelton.setSelectedKaroCards(selectedKaroPositions);
            }
        });

            // Pik RecyclerView
        pikRecyclerView = findViewById(R.id.PikRecyclerview);
        pikRecyclerView.setHasFixedSize(true);
        pikRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        List<SpielKarten> pikList = new ArrayList<>();
        pikList.add(new SpielKarten(R.drawable.pik_zwei, "Pik Zwei"));
        pikList.add(new SpielKarten(R.drawable.pik_drei, "Pik Drei"));
        pikList.add(new SpielKarten(R.drawable.pik_vier, "Pik Vier"));
        pikList.add(new SpielKarten(R.drawable.pik_fuenf, "Pik Fünf"));
        pikList.add(new SpielKarten(R.drawable.pik_sechs, "Pik Sechs"));
        pikList.add(new SpielKarten(R.drawable.pik_sieben, "Pik Sieben"));
        pikList.add(new SpielKarten(R.drawable.pik_acht, "Pik Acht"));
        pikList.add(new SpielKarten(R.drawable.pik_neun, "Pik Neun"));
        pikList.add(new SpielKarten(R.drawable.pik_zehn, "Pik Zehn"));
        pikList.add(new SpielKarten(R.drawable.pik_bube, "Pik Bube"));
        pikList.add(new SpielKarten(R.drawable.pik_dame, "Pik Dame"));
        pikList.add(new SpielKarten(R.drawable.pik_koenig, "Pik König"));
        pikList.add(new SpielKarten(R.drawable.pik_ass, "Pik Ass"));
        PlayCardAdapter pikAdapter = new PlayCardAdapter(pikList);
        pikRecyclerView.setAdapter(pikAdapter);

        pikAdapter.setOnItemClickListener(new PlayCardAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(SpielKarten spielkarte, int position) {
                if (selectedPikPositions.contains(position)) {
                    selectedPikPositions.remove(Integer.valueOf(position));
                } else {
                    selectedPikPositions.add(position);
                }
                pikAdapter.notifyDataSetChanged();
                gameDataSingelton.setSelectedPikCards(selectedPikPositions);
            }
        });

            // Kreuz RecyclerView
        kreuzRecyclerView = findViewById(R.id.KreuzRecyclerview);
        kreuzRecyclerView.setHasFixedSize(true);
        kreuzRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        List<SpielKarten> kreuzList = new ArrayList<>();
        kreuzList.add(new SpielKarten(R.drawable.kreuz_zwei, "Kreuz Zwei"));
        kreuzList.add(new SpielKarten(R.drawable.kreuz_drei, "Kreuz Drei"));
        kreuzList.add(new SpielKarten(R.drawable.kreuz_vier, "Kreuz Vier"));
        kreuzList.add(new SpielKarten(R.drawable.kreuz_fuenf, "Kreuz Fünf"));
        kreuzList.add(new SpielKarten(R.drawable.kreuz_sechs, "Kreuz Sechs"));
        kreuzList.add(new SpielKarten(R.drawable.kreuz_sieben, "Kreuz Sieben"));
        kreuzList.add(new SpielKarten(R.drawable.kreuz_acht, "Kreuz Acht"));
        kreuzList.add(new SpielKarten(R.drawable.kreuz_neun, "Kreuz Neun"));
        kreuzList.add(new SpielKarten(R.drawable.kreuz_zehn, "Kreuz Zehn"));
        kreuzList.add(new SpielKarten(R.drawable.kreuz_bube, "Kreuz Bube"));
        kreuzList.add(new SpielKarten(R.drawable.kreuz_dame, "Kreuz Dame"));
        kreuzList.add(new SpielKarten(R.drawable.kreuz_koenig, "Kreuz König"));
        kreuzList.add(new SpielKarten(R.drawable.kreuz_ass, "Kreuz Ass"));
        PlayCardAdapter kreuzAdapter = new PlayCardAdapter(kreuzList);
        kreuzRecyclerView.setAdapter(kreuzAdapter);

        kreuzAdapter.setOnItemClickListener(new PlayCardAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(SpielKarten spielkarte, int position) {
                if (selectedKreuzPositions.contains(position)) {
                    selectedKreuzPositions.remove(Integer.valueOf(position));
                } else {
                    selectedKreuzPositions.add(position);
                }
                kreuzAdapter.notifyDataSetChanged();
                gameDataSingelton.setSelectedKreuzCards(selectedKreuzPositions);
            }
        });
        // -------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    }


        // Start the intent and pass the value
    private void startNextActivity() {
        Intent intent = new Intent(QuestionFourActivity.this, QuestionFiveActivity.class);
        startActivity(intent);
    }
}
