package com.example.navigationsbar.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.navigationsbar.Items.Article.Article;
import com.example.navigationsbar.R;

import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class ArticleAdapter extends RecyclerView.Adapter<ArticleAdapter.ArticleViewHolder> {
    private final List<Article> articles;
    private final OnClickListener onClickListener;
    private final Context context;

    HashMap<String, Integer> cardImagesMap = new HashMap<>();

    public ArticleAdapter(List<Article> articles, OnClickListener onClickListener, Context context) {
        this.articles = articles;
        this.onClickListener = onClickListener;
        this.context = context;

// Hinzufügen von Schlüssel-Wert-Paaren zur HashMap für Herz-Karten
        cardImagesMap.put("Herz2", R.drawable.herz_zwei);
        cardImagesMap.put("Herz3", R.drawable.herz_drei);
        cardImagesMap.put("Herz4", R.drawable.herz_vier);
        cardImagesMap.put("Herz5", R.drawable.herz_fuenf);
        cardImagesMap.put("Herz6", R.drawable.herz_sechs);
        cardImagesMap.put("Herz7", R.drawable.herz_sieben);
        cardImagesMap.put("Herz8", R.drawable.herz_acht);
        cardImagesMap.put("Herz9", R.drawable.herz_neun);
        cardImagesMap.put("Herz10", R.drawable.herz_zehn);
        cardImagesMap.put("HerzB", R.drawable.herz_bube);
        cardImagesMap.put("HerzD", R.drawable.herz_dame);
        cardImagesMap.put("HerzK", R.drawable.herz_koenig);
        cardImagesMap.put("HerzA", R.drawable.herz_ass);

// Hinzufügen von Schlüssel-Wert-Paaren zur HashMap für Pik-Karten
        cardImagesMap.put("Pik2", R.drawable.pik_zwei);
        cardImagesMap.put("Pik3", R.drawable.pik_drei);
        cardImagesMap.put("Pik4", R.drawable.pik_vier);
        cardImagesMap.put("Pik5", R.drawable.pik_fuenf);
        cardImagesMap.put("Pik6", R.drawable.pik_sechs);
        cardImagesMap.put("Pik7", R.drawable.pik_sieben);
        cardImagesMap.put("Pik8", R.drawable.pik_acht);
        cardImagesMap.put("Pik9", R.drawable.pik_neun);
        cardImagesMap.put("Pik10", R.drawable.pik_zehn);
        cardImagesMap.put("PikB", R.drawable.pik_bube);
        cardImagesMap.put("PikD", R.drawable.pik_dame);
        cardImagesMap.put("PikK", R.drawable.pik_koenig);
        cardImagesMap.put("PikA", R.drawable.pik_ass);

// Hinzufügen von Schlüssel-Wert-Paaren zur HashMap für Kreuz-Karten
        cardImagesMap.put("Kreuz2", R.drawable.kreuz_zwei);
        cardImagesMap.put("Kreuz3", R.drawable.kreuz_drei);
        cardImagesMap.put("Kreuz4", R.drawable.kreuz_vier);
        cardImagesMap.put("Kreuz5", R.drawable.kreuz_fuenf);
        cardImagesMap.put("Kreuz6", R.drawable.kreuz_sechs);
        cardImagesMap.put("Kreuz7", R.drawable.kreuz_sieben);
        cardImagesMap.put("Kreuz8", R.drawable.kreuz_acht);
        cardImagesMap.put("Kreuz9", R.drawable.kreuz_neun);
        cardImagesMap.put("Kreuz10", R.drawable.kreuz_zehn);
        cardImagesMap.put("KreuzB", R.drawable.kreuz_bube);
        cardImagesMap.put("KreuzD", R.drawable.kreuz_dame);
        cardImagesMap.put("KreuzK", R.drawable.kreuz_koenig);
        cardImagesMap.put("KreuzA", R.drawable.kreuz_ass);

// Hinzufügen von Schlüssel-Wert-Paaren zur HashMap für Karo-Karten
        cardImagesMap.put("Karo2", R.drawable.karo_zwei);
        cardImagesMap.put("Karo3", R.drawable.karo_drei);
        cardImagesMap.put("Karo4", R.drawable.karo_vier);
        cardImagesMap.put("Karo5", R.drawable.karo_fuenf);
        cardImagesMap.put("Karo6", R.drawable.karo_sechs);
        cardImagesMap.put("Karo7", R.drawable.karo_sieben);
        cardImagesMap.put("Karo8", R.drawable.karo_acht);
        cardImagesMap.put("Karo9", R.drawable.karo_neun);
        cardImagesMap.put("Karo10", R.drawable.karo_zehn);
        cardImagesMap.put("KaroB", R.drawable.karo_bube);
        cardImagesMap.put("KaroD", R.drawable.karo_dame);
        cardImagesMap.put("KaroK", R.drawable.karo_koenig);
        cardImagesMap.put("KaroA", R.drawable.karo_ass);
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

        // Set random image
        setRandomImage(holder.imageView);

        holder.itemView.setAnimation(translate_anim);
    }

    @Override
    public int getItemCount() {
        return articles.size();
    }

    public class ArticleViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private final ImageView imageView;
        private final TextView titleTextView;
        private final TextView playerNumberTextView;
        private final TextView playTimeTextView;
        private final TextView difficultyTextView;

        public ArticleViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView2);
            titleTextView = itemView.findViewById(R.id.titleTextView);
            playerNumberTextView = itemView.findViewById(R.id.playerNumberTextView);
            playTimeTextView = itemView.findViewById(R.id.playTimeTextView);
            difficultyTextView = itemView.findViewById(R.id.difficultyTextView);
            itemView.setOnClickListener(this);
        }

        public void bindArticle(Article article) {
            // Werte des aktuellen Artikels im Layout hinzufügen
            titleTextView.setText(article.getTitle());
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

    private void setRandomImage(ImageView imageView) {
        String[] cardKeys = cardImagesMap.keySet().toArray(new String[0]);
        String randomKey = cardKeys[new Random().nextInt(cardKeys.length)];
        int randomImageResource = cardImagesMap.get(randomKey);
        imageView.setImageResource(randomImageResource);
    }
}