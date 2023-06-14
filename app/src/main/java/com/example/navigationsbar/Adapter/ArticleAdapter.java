package com.example.navigationsbar.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.navigationsbar.Items.Article.Article;
import com.example.navigationsbar.R;

import java.util.List;

public class ArticleAdapter extends RecyclerView.Adapter<ArticleAdapter.ArticleViewHolder> {
    private final List<Article> articles;
    private final OnClickListener onClickListener;
    private final Context context;

    public ArticleAdapter(List<Article> articles, OnClickListener onClickListener, Context context) {
        this.articles = articles;
        this.onClickListener = onClickListener;
        this.context = context;
    }

    @NonNull
    @Override
    public ArticleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_article, parent, false);
        return new ArticleViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ArticleViewHolder holder, int position) {
        Animation translate_anim = AnimationUtils.loadAnimation(holder.itemView.getContext(), R.anim.translate_anim);
        Article article = articles.get(position);
        holder.bindArticle(article);
        holder.itemView.setAnimation(translate_anim);
    }

    @Override
    public int getItemCount() {
        return articles.size();
    }

    public class ArticleViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private final TextView titleTextView;
        private final TextView cardNumberTextView;
        private final TextView playerNumberTextView;
        private final TextView playTimeTextView;
        private final TextView difficultyTextView;

        public ArticleViewHolder(@NonNull View itemView) {
            super(itemView);
            titleTextView = itemView.findViewById(R.id.titleTextView);
            cardNumberTextView = itemView.findViewById(R.id.cardNumberTextView);
            playerNumberTextView = itemView.findViewById(R.id.playerNumberTextView);
            playTimeTextView = itemView.findViewById(R.id.playTimeTextView);
            difficultyTextView = itemView.findViewById(R.id.difficultyTextView);
            itemView.setOnClickListener(this);
        }

        public void bindArticle(Article article) {
            // Werte des Aktuellen Artikels im Layout hinzufügen
            titleTextView.setText("Spiel: " + article.getTitle());
            cardNumberTextView.setText("Benötigte Karten: " + article.getBenötigteKarten());
            playerNumberTextView.setText("Benötigte Spieler: " + article.getSpieleranzahlMin() + " - " + article.getSpieleranzahlMax());
            playTimeTextView.setText("Spielzeit: " + article.getSpieldauerMin() + "min - " + article.getSpieldauerMax() + "min");
            difficultyTextView.setText(article.getSchwierigkeitsgrad());
        }

        @Override
        public void onClick(View v) {
            int position = getAdapterPosition();
            if (position != RecyclerView.NO_POSITION) {
                Article article = articles.get(position);
                onClickListener.onItemClick(article);
            }
        }
    }

    public interface OnClickListener {
        void onItemClick(Article article);
    }
}