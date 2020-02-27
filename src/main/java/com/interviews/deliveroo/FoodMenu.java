package com.interviews.deliveroo;

import java.util.*;

public class FoodMenu {

    public static final List<String> STARTER_LIST = Arrays.asList(
            "bread", "salad", "peanuts", "dumplings"
    );
    public static final List<String> MAIN_LIST = Arrays.asList(
            "steak", "bento", "chicken", "pizza", "sandwich", "wrap",
            "sushi", "burger", "hotdog", "pasta", "burrito", "taco", "rice"
    );
    public static final List<String> DESERT_LIST = Arrays.asList(
            "apples", "strawberries", "cheese", "ice-cream", "pie", "cake"
    );
    static final Map<String, List<String>> FOOD_CATEGORIES = new HashMap<>(3);

    static {
        FOOD_CATEGORIES.put("starters", STARTER_LIST);
        FOOD_CATEGORIES.put("mains", MAIN_LIST);
        FOOD_CATEGORIES.put("desserts", DESERT_LIST);
    }

    static final List<String> CHEF_DISHES = Arrays.asList(
            "strawberries", "dumplings", "pasta", "rice", "apples", "salad",
            "peanuts", "cheese", "bento", "sushi"
    );

    static final Set<String> CHEF_DISHES_SET = new HashSet<>(CHEF_DISHES);

    static final List<String> MENU_COURSES = Arrays.asList("Starters", "Mains", "Desserts");
    // ==== Just Falafs ====
    //       ~ Menu ~
    // Starters
    // dumplings, peanuts or salad
    // Mains
    // bento, sushi, pasta or rice
    // bento, sushi, pasta, rice
    // Desserts
    // apples, strawberries or cheese

    public static void main(String[] args) {
        List<String> response = new ArrayList<>();
        response.add("==== Just Falafs ====");
        response.add("~ Menu ~");

        for (String category : MENU_COURSES) {
            response.add(category);

            List<String> categoryItems = FOOD_CATEGORIES.get(category.toLowerCase());
            List<String> itemsAvailable = new ArrayList<>();

            for (String item : categoryItems) {
                if (CHEF_DISHES_SET.contains(item)) {
                    itemsAvailable.add(item);
                }
            }

            if (!itemsAvailable.isEmpty()) {
                String result = String.join(", ", itemsAvailable);
                int index = result.lastIndexOf(",");
                if (index != -1) {
                    String subString = " or ";
                    result = result.substring(0, index) + subString
                            + result.substring(index + 2);
                }
                // replace last , with or
                response.add(result);
            }
        }

        for (String s : response) {
            System.out.println(s);
        }
    }
}


/* 
Your previous Plain Text content is preserved below:

This is just a simple shared plaintext pad, with no execution capabilities.

When you know what language you'd like to use for your interview,
simply choose it from the dropdown in the top bar.

You can also change the default language your pads are created with
in your account settings: https://coderpad.io/settings

Enjoy your interview!

hi

 */