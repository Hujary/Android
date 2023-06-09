package com.example.navigationsbar.Adapter;

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
import com.example.navigationsbar.Items.FilteredArticle.filteredArticle;
import com.example.navigationsbar.R;

import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class FilteredArticleAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private static final int VIEW_TYPE_ARTICLE = 1;
    private static final int VIEW_TYPE_FOOTER = 2;
    HashMap<String, Integer> cardImagesMap = new HashMap<>();

    private List<filteredArticle> articles;
    private OnClickListener onClickListener;

    public FilteredArticleAdapter(List<filteredArticle> articles, OnClickListener onClickListener) {
        this.articles = articles;
        this.onClickListener = onClickListener;

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

    @Override
    public int getItemViewType(int position) {
        if (position == articles.size()) {
            return VIEW_TYPE_FOOTER;
        } else {
            return VIEW_TYPE_ARTICLE;
        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());

        // Logik das unten das Textfeld erscheint.
        if (viewType == VIEW_TYPE_ARTICLE) {
            View view = inflater.inflate(R.layout.item_filtered_article, parent, false);
            return new ArticleViewHolder(view);
        } else {
            View view = inflater.inflate(R.layout.item_filtered_article_footer, parent, false);
            return new FooterViewHolder(view);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (getItemViewType(position) == VIEW_TYPE_ARTICLE) {
            ArticleViewHolder articleViewHolder = (ArticleViewHolder) holder;
            filteredArticle article = articles.get(position);
            articleViewHolder.bindArticle(article);

            // Set random image
            setRandomImage(articleViewHolder.imageView);

            // Animation für die gefilterten Artikel.
            Animation animation = AnimationUtils.loadAnimation(articleViewHolder.itemView.getContext(), android.R.anim.slide_in_left);
            articleViewHolder.itemView.startAnimation(animation);
        } else {
            // Handle the footer view here (if needed)
        }
    }

    @Override
    public int getItemCount() {
        return articles.size() + 1;
    }

    public class ArticleViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private final TextView titleTextView;
        private final TextView playerNumberTextView;
        private final TextView playTimeTextView;
        private final TextView difficultyTextView;
        private final ImageView imageView;

        public ArticleViewHolder(@NonNull View itemView) {
            super(itemView);
            titleTextView = itemView.findViewById(R.id.titleTextView);
            playerNumberTextView = itemView.findViewById(R.id.playerNumberTextView);
            playTimeTextView = itemView.findViewById(R.id.playTimeTextView);
            difficultyTextView = itemView.findViewById(R.id.difficultyTextView);
            imageView = itemView.findViewById(R.id.imageView2);

            itemView.setOnClickListener(this);
        }


        public void bindArticle(filteredArticle article) {
            titleTextView.setText(article.getTitle());
            playerNumberTextView.setText(article.getSpieleranzahlMin() + " - " + article.getSpieleranzahlMax());
            playTimeTextView.setText(article.getSpieldauerMin() + " - " + article.getSpieldauerMax());
            difficultyTextView.setText(article.getSchwierigkeitsgrad());
        }

        @Override
        public void onClick(View v) {
            int position = getAdapterPosition();
            if (position != RecyclerView.NO_POSITION) {
                filteredArticle article = articles.get(position);
                onClickListener.onItemClick(article);
            }
        }
    }

    public class FooterViewHolder extends RecyclerView.ViewHolder {
        public FooterViewHolder(@NonNull View itemView) {
            super(itemView);
            // Initialize the footer view components here (if needed)
        }
    }

    public interface OnClickListener {
        void onItemClick(filteredArticle article);

        void onFooterClick();
    }

    private void setRandomImage(ImageView imageView) {
        String[] cardKeys = cardImagesMap.keySet().toArray(new String[0]);
        String randomKey = cardKeys[new Random().nextInt(cardKeys.length)];
        int randomImageResource = cardImagesMap.get(randomKey);
        imageView.setImageResource(randomImageResource);
    }
}
