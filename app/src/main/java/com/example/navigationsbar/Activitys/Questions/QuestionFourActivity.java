package com.example.navigationsbar.Activitys.Questions;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.question4_layout);

        // Herz RecyclerView
        herzRecyclerView = findViewById(R.id.HerzRecyclerView);
        herzRecyclerView.setHasFixedSize(true);
        herzRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        List<SpielKarten> herzList = new ArrayList<>();
        herzList.add(new SpielKarten(R.drawable.herz_zwei));
        herzList.add(new SpielKarten(R.drawable.herz_drei));
        herzList.add(new SpielKarten(R.drawable.herz_vier));
        herzList.add(new SpielKarten(R.drawable.herz_fuenf));
        herzList.add(new SpielKarten(R.drawable.herz_sechs));
        herzList.add(new SpielKarten(R.drawable.herz_sieben));
        herzList.add(new SpielKarten(R.drawable.herz_acht));
        herzList.add(new SpielKarten(R.drawable.herz_neun));
        herzList.add(new SpielKarten(R.drawable.herz_zehn));
        herzList.add(new SpielKarten(R.drawable.herz_bube));
        herzList.add(new SpielKarten(R.drawable.herz_dame));
        herzList.add(new SpielKarten(R.drawable.herz_koenig));
        herzList.add(new SpielKarten(R.drawable.herz_ass));
        PlayCardAdapter herzAdapter = new PlayCardAdapter(herzList);
        herzRecyclerView.setAdapter(herzAdapter);

        herzAdapter.setOnItemClickListener(new PlayCardAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(SpielKarten spielkarte, int position) {
                if (selectedHerzPositions.contains(position)) {
                    selectedHerzPositions.remove(Integer.valueOf(position));
                } else {
                    selectedHerzPositions.add(position);
                }
                herzAdapter.notifyDataSetChanged();

                // Ausgabe der ausgewählten Positionen der Herz-Karten
                StringBuilder selectedPositions = new StringBuilder("Selected Herz Positions: ");
                for (Integer selectedPosition : selectedHerzPositions) {
                    selectedPositions.append(selectedPosition).append(", ");
                }
                Log.d("QuestionFourActivity", selectedPositions.toString());
                Toast.makeText(QuestionFourActivity.this, selectedPositions.toString(), Toast.LENGTH_SHORT).show();
            }
        });

        // Karo RecyclerView
        karoRecyclerView = findViewById(R.id.KaroRecyclerView);
        karoRecyclerView.setHasFixedSize(true);
        karoRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        List<SpielKarten> karoList = new ArrayList<>();
        karoList.add(new SpielKarten(R.drawable.karo_zwei));
        karoList.add(new SpielKarten(R.drawable.karo_drei));
        karoList.add(new SpielKarten(R.drawable.karo_vier));
        karoList.add(new SpielKarten(R.drawable.karo_fuenf));
        karoList.add(new SpielKarten(R.drawable.karo_sechs));
        karoList.add(new SpielKarten(R.drawable.karo_sieben));
        karoList.add(new SpielKarten(R.drawable.karo_acht));
        karoList.add(new SpielKarten(R.drawable.karo_neun));
        karoList.add(new SpielKarten(R.drawable.karo_zehn));
        karoList.add(new SpielKarten(R.drawable.karo_bube));
        karoList.add(new SpielKarten(R.drawable.karo_dame));
        karoList.add(new SpielKarten(R.drawable.karo_koenig));
        karoList.add(new SpielKarten(R.drawable.karo_ass));
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

                // Ausgabe der ausgewählten Positionen der Karo-Karten
                StringBuilder selectedPositions = new StringBuilder("Selected Karo Positions: ");
                for (Integer selectedPosition : selectedKaroPositions) {
                    selectedPositions.append(selectedPosition).append(", ");
                }
                Log.d("QuestionFourActivity", selectedPositions.toString());
                Toast.makeText(QuestionFourActivity.this, selectedPositions.toString(), Toast.LENGTH_SHORT).show();
            }
        });

        // Pik RecyclerView
        pikRecyclerView = findViewById(R.id.PikRecyclerview);
        pikRecyclerView.setHasFixedSize(true);
        pikRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        List<SpielKarten> pikList = new ArrayList<>();
        pikList.add(new SpielKarten(R.drawable.pik_zwei));
        pikList.add(new SpielKarten(R.drawable.pik_drei));
        pikList.add(new SpielKarten(R.drawable.pik_vier));
        pikList.add(new SpielKarten(R.drawable.pik_fuenf));
        pikList.add(new SpielKarten(R.drawable.pik_sechs));
        pikList.add(new SpielKarten(R.drawable.pik_sieben));
        pikList.add(new SpielKarten(R.drawable.pik_acht));
        pikList.add(new SpielKarten(R.drawable.pik_neun));
        pikList.add(new SpielKarten(R.drawable.pik_zehn));
        pikList.add(new SpielKarten(R.drawable.pik_bube));
        pikList.add(new SpielKarten(R.drawable.pik_dame));
        pikList.add(new SpielKarten(R.drawable.pik_koenig));
        pikList.add(new SpielKarten(R.drawable.pik_ass));
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

                // Ausgabe der ausgewählten Positionen der Pik-Karten
                StringBuilder selectedPositions = new StringBuilder("Selected Pik Positions: ");
                for (Integer selectedPosition : selectedPikPositions) {
                    selectedPositions.append(selectedPosition).append(", ");
                }
                Log.d("QuestionFourActivity", selectedPositions.toString());
                Toast.makeText(QuestionFourActivity.this, selectedPositions.toString(), Toast.LENGTH_SHORT).show();
            }
        });

        // Kreuz RecyclerView
        kreuzRecyclerView = findViewById(R.id.KreuzRecyclerview);
        kreuzRecyclerView.setHasFixedSize(true);
        kreuzRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        List<SpielKarten> kreuzList = new ArrayList<>();
        kreuzList.add(new SpielKarten(R.drawable.kreuz_zwei));
        kreuzList.add(new SpielKarten(R.drawable.kreuz_drei));
        kreuzList.add(new SpielKarten(R.drawable.kreuz_vier));
        kreuzList.add(new SpielKarten(R.drawable.kreuz_fuenf));
        kreuzList.add(new SpielKarten(R.drawable.kreuz_sechs));
        kreuzList.add(new SpielKarten(R.drawable.kreuz_sieben));
        kreuzList.add(new SpielKarten(R.drawable.kreuz_acht));
        kreuzList.add(new SpielKarten(R.drawable.kreuz_neun));
        kreuzList.add(new SpielKarten(R.drawable.kreuz_zehn));
        kreuzList.add(new SpielKarten(R.drawable.kreuz_bube));
        kreuzList.add(new SpielKarten(R.drawable.kreuz_dame));
        kreuzList.add(new SpielKarten(R.drawable.kreuz_koenig));
        kreuzList.add(new SpielKarten(R.drawable.kreuz_ass));
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

                // Ausgabe der ausgewählten Positionen der Kreuz-Karten
                StringBuilder selectedPositions = new StringBuilder("Selected Kreuz Positions: ");
                for (Integer selectedPosition : selectedKreuzPositions) {
                    selectedPositions.append(selectedPosition).append(", ");
                }
                Log.d("QuestionFourActivity", selectedPositions.toString());
                Toast.makeText(QuestionFourActivity.this, selectedPositions.toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
