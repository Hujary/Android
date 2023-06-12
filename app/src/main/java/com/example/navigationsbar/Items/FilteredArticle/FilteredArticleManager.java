package com.example.navigationsbar.Items.FilteredArticle;

import java.util.ArrayList;
import java.util.List;

public class FilteredArticleManager {
    public static List<filteredArticle> getFilteredArticles(int numberOfPlayers, boolean haveCards, boolean missingCards, String difficulty) {
        List<filteredArticle> filteredGamesList = new ArrayList<>();

            // Eror handling
        if (difficulty == null) {
            difficulty = "Egal";
        }
                        // Artikel hinzufügen, die den Bedingungen entsprechen
                    if (difficulty.equals("Einfach")) {
                        System.out.println("Schwierigkeit: Einfach");
                        filteredGamesList.add(new filteredArticle("Schwieirigkeit Leicht Example", "Spielregeln", "5", 6, 5, 20, 30, "leicht"));
                        filteredGamesList.add(new filteredArticle("Schwieirigkeit Leicht Example", "Spielregeln", "5", 6, 5, 20, 30, "leicht"));
                    } else if (difficulty.equals("Medium")) {
                        System.out.println("Schwierigkeit: Medium");
                        filteredGamesList.add(new filteredArticle("Schwieirigkeit Mittel Example", "Spielregeln", "5", 6, 5, 20, 30, "mittel"));
                        filteredGamesList.add(new filteredArticle("Schwieirigkeit Mittel Example", "Spielregeln", "5", 6, 5, 20, 30, "mittel"));
                    } else if (difficulty.equals("Schwer")) {
                        System.out.println("Schwierigkeit: Schwer");
                        filteredGamesList.add(new filteredArticle("Schwieirigkeit Schwer Example", "Spielregeln", "5", 6, 5, 20, 30, "schwer"));
                        filteredGamesList.add(new filteredArticle("Schwieirigkeit Schwer Example", "Spielregeln", "5", 6, 5, 20, 30, "schwer"));
                    } else if (difficulty.equals("Extrem")) {
                        System.out.println("Schwierigkeit: Extrem");
                        filteredGamesList.add(new filteredArticle("Schwieirigkeit Extrem Example", "Spielregeln", "5", 6, 5, 20, 30, "Extrem"));
                        filteredGamesList.add(new filteredArticle("Schwieirigkeit Extrem Example", "Spielregeln", "5", 6, 5, 20, 30, "Extrem"));
                    } else if (difficulty.equals("Egal")) {
                        System.out.println("Schwierigkeit: Egal");
                        filteredGamesList.add(new filteredArticle("Titel1", "Spielregeln", "16", 3, 6, 20, 30, "leicht"));
                        filteredGamesList.add(new filteredArticle("Titel2", "Spielregeln", "16", 3, 8, 20, 30, "leicht"));
                        filteredGamesList.add(new filteredArticle("Titel3", "Spielregeln", "12", 3, 10, 20, 30, "mittel"));
                        filteredGamesList.add(new filteredArticle("Titel4", "Spielregeln", "32", 2, 6, 20, 30, "mittel"));
                        filteredGamesList.add(new filteredArticle("Titel5", "Spielregeln", "32", 3, 8, 20, 30, "schwer"));
                        filteredGamesList.add(new filteredArticle("Titel6", "Spielregeln", "12", 3, 10, 20, 30, "schwer"));
                        filteredGamesList.add(new filteredArticle("Titel5", "Spielregeln", "32", 2, 10, 20, 30, "Extrem"));
                        filteredGamesList.add(new filteredArticle("Titel6", "Spielregeln", "16", 2, 8, 20, 30, "Extrem"));
                     }
        return filteredGamesList;
    }
}