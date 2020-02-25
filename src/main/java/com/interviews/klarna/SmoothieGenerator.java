package com.interviews.klarna;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.lang.String.join;
import static java.util.Arrays.asList;
import static java.util.Arrays.stream;
import static java.util.Objects.isNull;

public class SmoothieGenerator {

    public static void main(String[] args) {
        System.out.println(ingredients("Freezie,-blackberry"));
    }

    private static final Map<String, List<String>> smoothieMap = new HashMap<>();

    static {
        smoothieMap.put("Classic", asList("banana", "honey", "mango", "peach", "pineapple", "strawberry"));
        smoothieMap.put("Freezie", asList("black currant", "blackberry", "blueberry", "frozen yogurt", "grape juice"));
        smoothieMap.put("Greenie", asList("apple juice", "avocado", "green apple", "ice", "lime", "spinach"));
        smoothieMap.put("Just Desserts", asList("banana", "cherry", "chocolate", "ice cream", "peanut"));
    }

    public static String ingredients(String order) {
        if (isNull(order) || order.isEmpty())
            throw new IllegalArgumentException("Invalid order received: " + order);

        String[] orderContents = order.split(",");
        String smoothie = orderContents[0];

        if (!smoothieMap.containsKey(smoothie))
            throw new IllegalArgumentException("Invalid smoothie requested: " + smoothie);

        List<String> ingredientList = smoothieMap.get(smoothie).stream().collect(Collectors.toList());

        // if order contains additional inputs additions/allergens 
        if (orderContents.length > 1) {
            stream(orderContents)
                    .skip(1)
                    .filter(content -> !content.contains("-"))
                    .findFirst()
                    .ifPresent(item -> {
                        throw new IllegalArgumentException("Adding new ingredients is not supported yet: " + item);
                    });

            stream(orderContents)
                    .skip(1)
                    .forEach(ingredient -> ingredientList.remove(ingredient.replaceFirst("-", "")));
        }

        return join(",", ingredientList);
    }
}
