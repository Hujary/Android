package com.example.navigationsbar.Fragments;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.LayoutInflater;
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
import com.example.navigationsbar.Adapter.DatabaseAdapter;
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
    ArrayList<String> game_id, game_title, user;
    DatabaseAdapter databaseAdapter;

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
                Intent intent = new Intent(requireActivity(), AddActivity.class);
                startActivityForResult(intent, 1);
            }
        });

        myDB = new MyDatabaseHelper(requireActivity());
        game_id = new ArrayList<>();
        game_title = new ArrayList<>();
        user = new ArrayList<>(); // Initialize the user ArrayList
        storeDataInArrays();

            //  hier wird dem Adapter der Wert des aktuellen  Spiels übergeben
        databaseAdapter = new DatabaseAdapter(requireActivity(), getContext(), game_id, game_title, user);
        recyclerView.setAdapter(databaseAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(requireActivity()));
        return root;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1) {
            if (resultCode == AddActivity.RESULT_OK) {
                storeDataInArrays();
                databaseAdapter.notifyDataSetChanged();
            }
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        storeDataInArrays();
        databaseAdapter.notifyDataSetChanged();
    }

    void storeDataInArrays() {
        Cursor cursor = myDB.readUserAddedData();  // Get the latest data from the database

        game_id.clear();
        game_title.clear();
        user.clear();

        if (cursor != null && cursor.moveToFirst()) {
            int columnCount = cursor.getColumnCount();
            do {
                for (int i = 0; i < columnCount; i++) {
                    String value = cursor.getString(i);
                    System.out.println("Column " + i + ": " + value);
                    //game_id.add(cursor.getString(0));
                    //game_title.add(cursor.getString(1));
                    //user.add(cursor.getString(4));
                }
            } while (cursor.moveToNext());
            cursor.close();
        }

            //  prüfe ob noch ein Element in der Liste ist
        if (game_id.isEmpty()) {
            empty_imageview.setVisibility(View.VISIBLE);
            no_data.setVisibility(View.VISIBLE);
        } else {
            empty_imageview.setVisibility(View.GONE);
            no_data.setVisibility(View.GONE);
        }
    }

        //  Aktuallisiere den Fragment
    public void refreshFragment() {
        storeDataInArrays();
        databaseAdapter.notifyDataSetChanged();
    }
}