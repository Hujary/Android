package com.example.navigationsbar.Artikel;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.navigationsbar.R;

public class ArticleViewHolder extends RecyclerView.ViewHolder {
    private TextView titleTextView;
    private TextView cardNumberTextView;
    private TextView playerNumberTextView;
    private TextView playTimeTextView;
    private TextView difficultyTextView;
    private LinearLayout secondArticleLayout;
    private TextView titleTextView2;
    private TextView cardNumberTextView2;
    private TextView playerNumberTextView2;
    private TextView playTimeTextView2;
    private TextView difficultyTextView2;

    public ArticleViewHolder(@NonNull View itemView) {
        super(itemView);
        titleTextView = itemView.findViewById(R.id.titleTextView);
        cardNumberTextView = itemView.findViewById(R.id.cardNumberTextView);
        playerNumberTextView = itemView.findViewById(R.id.playerNumberTextView);
        playTimeTextView = itemView.findViewById(R.id.playTimeTextView);
        difficultyTextView = itemView.findViewById(R.id.difficultyTextView);
        secondArticleLayout = itemView.findViewById(R.id.secondArticleLayout);
        titleTextView2 = itemView.findViewById(R.id.titleTextView2);
        cardNumberTextView2 = itemView.findViewById(R.id.cardNumberTextView2);
        playerNumberTextView2 = itemView.findViewById(R.id.playerNumberTextView2);
        playTimeTextView2 = itemView.findViewById(R.id.playTimeTextView2);
        difficultyTextView2 = itemView.findViewById(R.id.difficultyTextView2);
    }

    public void bindLeftArticle(Article article) {
        titleTextView.setText("Spiel: " + article.getTitle());
        cardNumberTextView.setText("Benötigte Karten: " + article.getBenötigteKarten());
        playerNumberTextView.setText("Benötigte Spieler: " + article.getSpieleranzahlMin() + " - " + article.getSpieleranzahlMax());
        playTimeTextView.setText("Spielzeit: " + article.getSpieldauerMin() + "min - " + article.getSpieldauerMax() + "min");
        difficultyTextView.setText(article.getSchwierigkeitsgrad());
    }

    public void bindRightArticle(Article article) {
        titleTextView2.setText("Spiel: " + article.getTitle());
        cardNumberTextView2.setText("Benötigte Karten: " + article.getBenötigteKarten());
        playerNumberTextView2.setText("Benötigte Spieler: " + article.getSpieleranzahlMin() + " - " + article.getSpieleranzahlMax());
        playTimeTextView2.setText("Spielzeit: " + article.getSpieldauerMin() + "min - " + article.getSpieldauerMax() + "min");
        difficultyTextView2.setText(article.getSchwierigkeitsgrad());
    }

    public void hideRightArticleLayout() {
        secondArticleLayout.setVisibility(View.GONE);
    }
}