package ru.netology;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        CatFactsFetcher fetcher = new CatFactsFetcher();

        try {
            List<CatFact> catFacts = fetcher.fetchCatFacts();

            List<CatFact> filteredCatFacts = catFacts.stream()
                    .filter(fact -> fact.getUpvotes() != null && fact.getUpvotes() > 0)
                    .collect(Collectors.toList());

            for (CatFact fact : filteredCatFacts) {
                System.out.println("Факт: " + fact.getText());
                System.out.println("Количество голосов: " + fact.getUpvotes());
                System.out.println(); // Пустая строка для разделения фактов
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}