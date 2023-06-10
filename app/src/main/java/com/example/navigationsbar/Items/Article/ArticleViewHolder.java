package com.example.navigationsbar.Items.Article;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.navigationsbar.Items.Article.Article;
import com.example.navigationsbar.R;

public class ArticleViewHolder extends RecyclerView.ViewHolder {
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

    public void bindLeftArticle(Article article) {
        titleTextView.setText("Spiel: " + article.getTitle());
        cardNumberTextView.setText("Benötigte Karten: " + article.getBenötigteKarten());
        playerNumberTextView.setText("Benötigte Spieler: " + article.getSpieleranzahlMin() + " - " + article.getSpieleranzahlMax());
        playTimeTextView.setText("Spielzeit: " + article.getSpieldauerMin() + "min - " + article.getSpieldauerMax() + "min");
        difficultyTextView.setText(article.getSchwierigkeitsgrad());
    }
}