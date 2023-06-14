package com.example.navigationsbar.Fragments;

import static androidx.core.app.ActivityCompat.recreate;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.navigationsbar.Database.AddActivity;
import com.example.navigationsbar.Adapter.AddRecyclerAdapter;
import com.example.navigationsbar.Database.MyDatabaseHelper;
import com.example.navigationsbar.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class AddFragment extends Fragment {

    RecyclerView recyclerView;
    FloatingActionButton add_button;
    ImageView empty_imageview;
    TextView no_data;

    MyDatabaseHelper myDB;
    ArrayList<String> game_id, game_title, game_spielregel, game_benötigteKarten, game_spieleranzahlMin, game_spieleranzahlMax, game_spieldauerMin, game_spieldauerMax, game_schwierigkeitsgrad, game_creator;
    AddRecyclerAdapter addRecyclerAdapter;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_add, container, false);

        recyclerView = root.findViewById(R.id.recyclerView);
        add_button = root.findViewById(R.id.add_button);
        empty_imageview = root.findViewById(R.id.empty_imageview);
        no_data = root.findViewById(R.id.no_data);
        add_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println("Add button funktioniert");
                Intent intentAdd = new Intent(requireActivity(), AddActivity.class);
                requireActivity().startActivity(intentAdd);
            }
        });

        myDB = new MyDatabaseHelper(requireActivity());
        game_id = new ArrayList<>();
        game_title = new ArrayList<>();
        game_spielregel = new ArrayList<>();
        game_benötigteKarten = new ArrayList<>();
        game_spieleranzahlMin = new ArrayList<>();
        game_spieleranzahlMax = new ArrayList<>();
        game_spieldauerMin = new ArrayList<>();
        game_spieldauerMax = new ArrayList<>();
        game_schwierigkeitsgrad = new ArrayList<>();
        game_creator = new ArrayList<>();

        storeDataInArrays();

        addRecyclerAdapter = new AddRecyclerAdapter(requireActivity(), getContext() , game_id, game_title, game_spielregel, game_benötigteKarten, game_spieleranzahlMin, game_spieleranzahlMax, game_spieldauerMin, game_spieldauerMax, game_schwierigkeitsgrad, game_creator);
        recyclerView.setAdapter(addRecyclerAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(requireActivity()));
        return root;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1) {
            requireActivity().recreate();
        }
    }


    void storeDataInArrays() {
        Cursor cursor = myDB.readUserAddedData();
        if (cursor.getCount() == 0) {
            empty_imageview.setVisibility(View.VISIBLE);
            no_data.setVisibility(View.VISIBLE);
        } else {
            while (cursor.moveToNext()) {
                game_id.add(cursor.getString(0));
                game_title.add(cursor.getString(1));
                game_spielregel.add(cursor.getString(2));
                game_benötigteKarten.add(cursor.getString(3));
                game_spieleranzahlMin.add(cursor.getString(4));
                game_spieleranzahlMax.add(cursor.getString(5));
                game_spieldauerMin.add(cursor.getString(6));
                game_spieldauerMax.add(cursor.getString(7));
                game_schwierigkeitsgrad.add(cursor.getString(8));
                game_creator.add(cursor.getString(9));
            }
            empty_imageview.setVisibility(View.GONE);
            no_data.setVisibility(View.GONE);
        }
    }
}