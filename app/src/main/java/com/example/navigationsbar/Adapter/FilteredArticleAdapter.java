package com.example.navigationsbar.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.navigationsbar.Items.Article.Article;
import com.example.navigationsbar.Items.FilteredArticle.filteredArticle;
import com.example.navigationsbar.R;

import java.util.List;

public class FilteredArticleAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private static final int VIEW_TYPE_ARTICLE = 1;
    private static final int VIEW_TYPE_FOOTER = 2;

    private List<filteredArticle> articles;
    private OnClickListener onClickListener;

    public FilteredArticleAdapter(List<filteredArticle> articles, OnClickListener onClickListener) {
        this.articles = articles;
        this.onClickListener = onClickListener;
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

            Animation animation = AnimationUtils.loadAnimation(articleViewHolder.itemView.getContext(), android.R.anim.slide_in_left);
            articleViewHolder.itemView.startAnimation(animation);
        } else {
            // Handle the footer view here (if needed)
        }
    }

    @Override
    public int getItemCount() {
            // Add 1 for the footer view
        return articles.size() + 1;
    }

    public class ArticleViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private final TextView titleTextView;
        private final TextView playerNumberTextView;
        private final TextView playTimeTextView;
        private final TextView difficultyTextView;

        public ArticleViewHolder(@NonNull View itemView) {
            super(itemView);
            titleTextView = itemView.findViewById(R.id.titleTextView);
            playerNumberTextView = itemView.findViewById(R.id.playerNumberTextView);
            playTimeTextView = itemView.findViewById(R.id.playTimeTextView);
            difficultyTextView = itemView.findViewById(R.id.difficultyTextView);

            itemView.setOnClickListener(this);
        }

        public void bindArticle(filteredArticle article) {
            titleTextView.setText("Spiel: " + article.getTitle());
            playerNumberTextView.setText("Benötigte Spieler: " + article.getSpieleranzahlMin() + " - " + article.getSpieleranzahlMax());
            playTimeTextView.setText("Spielzeit: " + article.getSpieldauerMin() + "min - " + article.getSpieldauerMax() + "min");
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
}