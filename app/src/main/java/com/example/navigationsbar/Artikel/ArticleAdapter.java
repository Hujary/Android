package com.example.navigationsbar.Artikel;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.navigationsbar.R;

import java.util.List;

public class ArticleAdapter extends RecyclerView.Adapter<ArticleAdapter.ArticleViewHolder> {
    private List<Article> articles;
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
        holder.bind(article);
    }

    @Override
    public int getItemCount() {
        return articles.size();
    }

    public static class ArticleViewHolder extends RecyclerView.ViewHolder {
        private TextView titleTextView;
        private TextView ruleTextView;
        private TextView cardNumberTextView;
        private TextView playerNumberTextView;
        private TextView playTimeTextView;

        public ArticleViewHolder(@NonNull View itemView) { super(itemView);

                // Hier werden die Objekte erzeugt
            titleTextView = itemView.findViewById(R.id.titleTextView);
            ruleTextView = itemView.findViewById(R.id.ruleTextView);
            cardNumberTextView = itemView.findViewById(R.id.cardNumberTextView);
            playerNumberTextView = itemView.findViewById(R.id.playerNumberTextView);
            playTimeTextView = itemView.findViewById(R.id.playTimeTextView);
        }

        public void bind(Article article) {
                // Hier wird der angezeigte Text gesetzt
            titleTextView.setText("Spiel: " + article.getTitle());
            ruleTextView.setText("Regeln: " + article.getSpielregel());
            cardNumberTextView.setText("Benötigte Karten: " + String.valueOf(article.getBenötigtekarten()));
            playerNumberTextView.setText("Benötigte Spieler: " + String.valueOf(article.getSpieleranzahlMin()) + " - " +String.valueOf(article.getSpieleranzahlMax()) );
            playTimeTextView.setText("Spielzeit: " + String.valueOf(article.getSpieldauerMin()) + "min - " +String.valueOf(article.getSpieldauerMax()) + "min" );
        }
    }
}