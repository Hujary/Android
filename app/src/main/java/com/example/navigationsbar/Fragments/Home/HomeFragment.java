package com.example.navigationsbar.Fragments.Home;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.navigationsbar.Activitys.Questions.QuestionOneActivity;
import com.example.navigationsbar.Artikel.ArticleCreator;
import com.example.navigationsbar.R;
import com.example.navigationsbar.Artikel.Article;
import com.example.navigationsbar.Artikel.ArticleAdapter;

import java.util.List;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    private Resources resources;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel = new ViewModelProvider(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);

            // Objekte erzeugen
        Button myButton = root.findViewById(R.id.button);

        resources = getResources(); // Get the resources object

            // Intent für Question View -> Lambda Function
        Intent intent = new Intent(requireActivity(), QuestionOneActivity.class);
        myButton.setOnClickListener(v -> startActivity(intent));

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }
}