package com.example.navigationsbar.Fragments.Games;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.navigationsbar.Activitys.Games.Games_HoeherTiefer_Activity;
import com.example.navigationsbar.Artikel.Article;
import com.example.navigationsbar.Artikel.ArticleAdapter;
import com.example.navigationsbar.Artikel.ArticleCreator;
import com.example.navigationsbar.R;
import com.example.navigationsbar.databinding.FragmentGamesBinding;

import java.util.List;

public class GamesFragment extends Fragment {

    private FragmentGamesBinding binding;
    private RecyclerView recyclerView;
    private ArticleAdapter articleAdapter;
    private Resources resources;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        GamesViewModel dashboardViewModel = new ViewModelProvider(this).get(GamesViewModel.class);
        binding = FragmentGamesBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        resources = getResources(); // Get the resources object

        try {
            // Here, the method to create articles is called
            recyclerView = root.findViewById(R.id.articleRecyclerView);
            recyclerView.setLayoutManager(new LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false));
            ArticleCreator articleCreator = new ArticleCreator(resources);
            List<Article> articles = articleCreator.createArticles();
            articleAdapter = new ArticleAdapter(articles);
            recyclerView.setAdapter(articleAdapter);
        } catch (Exception e) {
            e.printStackTrace();
        }

        Button buttonGame1 = root.findViewById(R.id.button3);
        buttonGame1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Games_HoeherTiefer_Activity.class);
                startActivity(intent);
            }
        });

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
