package com.interviews.amazon;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        List<String> competitors = Arrays.asList("anacell", "betacellular", "cetracular", "deltacellular", "eurocell");
        List<String> reviews = Arrays.asList("I love anacell Best services provided by anacell in the town",
                "betacellular has great services",
                "deltacellular provides much betacellular", "cetracular is worse than eurocell",
                "betacellular is better than deltacellular");
        ArrayList<String> strings = topNCompetitors(6, 2, competitors, 6, reviews);
        System.out.print(strings);
    }

    static public ArrayList<String> topNCompetitors(int numCompetitors,
                                                    int topNCompetitors,
                                                    List<String> competitors,
                                                    int numReviews,
                                                    List<String> reviews) {
        if (Objects.isNull(reviews) || reviews.isEmpty()
                || Objects.isNull(competitors) || competitors.isEmpty()
                || numReviews < 1 || numCompetitors < 1)
            return new ArrayList<>();

        ArrayList<String> topNCompetitorsList = new ArrayList<>(topNCompetitors);

        Set<String> competitorsSet = new HashSet<>(competitors);
        Map<String, Integer> topCompetitorsMap = new HashMap<>();

        // clean the reviews first: lowercase, remove special characters and split by spaces.
        reviews.forEach(review -> {
            String[] reviewArray = review.toLowerCase().replaceAll("[^a-zA-Z0-9 ]", "").split(" ");
            if (reviewArray.length > 0) {
                Set<String> tempCompetitorSet = new HashSet<>();

                for (String text : reviewArray) {
                    if (competitorsSet.contains(text) && !tempCompetitorSet.contains(text)) {
                        tempCompetitorSet.add(text);
                        if (topCompetitorsMap.containsKey(text)) {
                            topCompetitorsMap.put(text, topCompetitorsMap.get(text) + 1);
                        } else {
                            topCompetitorsMap.put(text, 1);
                        }
                    }
                }
            }
        });

        List<Map.Entry<String, Integer>> list = new ArrayList<>(topCompetitorsMap.entrySet());
        list.sort(new ValueThenKeyComparator<>());

        for (int i = 0; i < list.size(); i++) {
            if (topNCompetitorsList.size() < topNCompetitors)
                topNCompetitorsList.add(list.get(i).getKey());
            else
                break;
        }

        return topNCompetitorsList;
    }

    static class ValueThenKeyComparator<K extends Comparable<? super K>,
            V extends Comparable<? super V>>
            implements Comparator<Map.Entry<K, V>> {

        public int compare(Map.Entry<K, V> a, Map.Entry<K, V> b) {
            int cmp1 = b.getValue().compareTo(a.getValue());
            if (cmp1 != 0) {
                return cmp1;
            } else {
                return a.getKey().compareTo(b.getKey());
            }
        }
    }
}
