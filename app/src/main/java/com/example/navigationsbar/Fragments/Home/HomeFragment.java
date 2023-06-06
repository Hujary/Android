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
    private RecyclerView recyclerView;
    private ArticleAdapter articleAdapter;
    private Resources resources;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel = new ViewModelProvider(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);

        // Objekte erzeugen
        Button myButton = root.findViewById(R.id.button);
        TextView T2 = root.findViewById(R.id.textView3);
        ImageView IV = root.findViewById(R.id.imageView);
        IV.setImageResource(R.drawable.spielkarten);

        resources = getResources(); // Get the resources object

        try {
            // Hier wird die Methode um Artikel zu erstellen aufgerufen
            recyclerView = root.findViewById(R.id.articleRecyclerView);
            recyclerView.setLayoutManager(new LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false));
            ArticleCreator articleCreator = new ArticleCreator(resources);
            List<Article> articles = articleCreator.createArticles();
            articleAdapter = new ArticleAdapter(articles);
            recyclerView.setAdapter(articleAdapter);
        } catch (Exception e) {
            e.printStackTrace();
            T2.setText("Error" + e);
        }

        // Intent für Question View -> Lambda Function
        Intent intent = new Intent(requireActivity(), QuestionOneActivity.class);
        myButton.setOnClickListener(v -> startActivity(intent));

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        recyclerView.setAdapter(null);
    }
}