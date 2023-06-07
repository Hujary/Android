package com.example.navigationsbar.Activitys.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.navigationsbar.Artikel.Article;
import com.example.navigationsbar.R;

import java.util.List;

public class ArticleAdapter extends RecyclerView.Adapter<ArticleAdapter.ArticleViewHolder> {
    private final List<Article> articles;

    public ArticleAdapter(List<Article> articles) {
        this.articles = articles;
    }

    @NonNull
    @Override
    public ArticleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_article, parent, false);
        return new ArticleViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ArticleViewHolder holder, int position) {
        Article article = articles.get(position);
        holder.bindArticle(article);
    }

    @Override
    public int getItemCount() {
        return articles.size();
    }

    public static class ArticleViewHolder extends RecyclerView.ViewHolder {
        private TextView titleTextView;
        private TextView cardNumberTextView;
        private TextView playerNumberTextView;
        private TextView playTimeTextView;
        private TextView difficultyTextView;

        public ArticleViewHolder(@NonNull View itemView) {
            super(itemView);
            titleTextView = itemView.findViewById(R.id.titleTextView);
            cardNumberTextView = itemView.findViewById(R.id.cardNumberTextView);
            playerNumberTextView = itemView.findViewById(R.id.playerNumberTextView);
            playTimeTextView = itemView.findViewById(R.id.playTimeTextView);
            difficultyTextView = itemView.findViewById(R.id.difficultyTextView);
        }

        public void bindArticle(Article article) {
            titleTextView.setText("Spiel: " + article.getTitle());
            cardNumberTextView.setText("Benötigte Karten: " + article.getBenötigteKarten());
            playerNumberTextView.setText("Benötigte Spieler: " + article.getSpieleranzahlMin() + " - " + article.getSpieleranzahlMax());
            playTimeTextView.setText("Spielzeit: " + article.getSpieldauerMin() + "min - " + article.getSpieldauerMax() + "min");
            difficultyTextView.setText(article.getSchwierigkeitsgrad());
        }
    }
}