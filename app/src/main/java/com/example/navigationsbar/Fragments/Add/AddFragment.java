package com.example.navigationsbar.Fragments.Add;

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
    ArrayList<String> book_id, book_title, book_author, book_pages, user;
    DatabaseAdapter databaseAdapter;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_add, container, false);

        recyclerView = root.findViewById(R.id.recyclerView);
        add_button = root.findViewById(R.id.add_button);
        empty_imageview = root.findViewById(R.id.empty_imageview);
        no_data = root.findViewById(R.id.no_data);
        add_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(requireActivity(), AddActivity.class);
                startActivity(intent);
            }
        });

        myDB = new MyDatabaseHelper(requireActivity());
        book_id = new ArrayList<>();
        book_title = new ArrayList<>();
        book_author = new ArrayList<>();
        book_pages = new ArrayList<>();

        storeDataInArrays();

        databaseAdapter = new DatabaseAdapter(requireActivity(), getContext(), book_id, book_title, user);
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

    void storeDataInArrays() {
        Cursor cursor = myDB.readAllData();
        if (cursor.getCount() == 0) {
            empty_imageview.setVisibility(View.VISIBLE);
            no_data.setVisibility(View.VISIBLE);
        } else {
            empty_imageview.setVisibility(View.GONE);
            no_data.setVisibility(View.GONE);
            book_id.clear();
            book_title.clear();
            book_author.clear();
            book_pages.clear();
            while (cursor.moveToNext()) {
                book_id.add(cursor.getString(0));
                book_title.add(cursor.getString(1));
                book_author.add(cursor.getString(2));
                book_pages.add(cursor.getString(3));
            }
        }
    }
}