package com.example.navigationsbar.Fragments.Games;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.navigationsbar.Artikel.Article;
import com.example.navigationsbar.Activitys.Adapter.ArticleAdapter;
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
        binding = FragmentGamesBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        resources = getResources(); // Get the resources object

        try {
                // Here, the method to create articles is called
            recyclerView = root.findViewById(R.id.articleRecyclerView);
            recyclerView.setLayoutManager(new LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false));
            ArticleCreator articleCreator = new ArticleCreator(resources);
            List<Article> articles = articleCreator.createArticles();
            articleAdapter = new ArticleAdapter(articles);
            recyclerView.setAdapter(articleAdapter);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
