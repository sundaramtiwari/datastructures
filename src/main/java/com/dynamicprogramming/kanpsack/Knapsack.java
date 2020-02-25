package com.dynamicprogramming.kanpsack;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static java.util.Arrays.asList;

public class Knapsack {
    public static void main(String[] args) {
        System.out.println(knapsack(8, asList(
                Item.of(2, 10),
                Item.of(5, 12),
                Item.of(8, 21),
                Item.of(3, 25),
                Item.of(6, 126))));
    }

    private static int knapsack(int knapsackWeight, List<Item> itemList) {
        List<Item> result = new ArrayList<>(itemList.size());

        for (int i = 0; i < itemList.size(); i++) {
            Item item = itemList.get(i);
            for (int j = 1; j <= knapsackWeight; j++) {
                List<Item> tempList = new ArrayList<>(itemList);
                tempList.remove(item);
                if ( j - item.getWeight() > 0 &&
                        item.getValue() + knapsack(i-item.getWeight(), tempList)
                                > knapsack(i-1, tempList)) {
                    //result.add(i, item.getValue());
                }
            }
        }

        return result.get(result.size() - 1).getValue();
    }
}

class Item {
    private int weight;
    private int value;

    public static Item of(int weight, int value) {
        return new Item(weight, value);
    }

    public Item(int weight, int value) {
        this.weight = weight;
        this.value = value;
    }

    public Integer getWeight() {
        return weight;
    }

    public int getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return weight == item.weight &&
                value == item.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(weight, value);
    }
}
