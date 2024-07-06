package com.example;

import java.util.List;

class Dish {
    private String name;
    private int calories;
    private boolean vegetarian;
    private Type type;

    public Dish(String name, int calories, boolean vegetarian, Type type) {
        this.name = name;
        this.calories = calories;
        this.vegetarian = vegetarian;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public int getCalories() {
        return calories;
    }

    public boolean isVegetarian() {
        return vegetarian;
    }

    public Type getType() {
        return type;
    }

    public enum Type {
        MEAT, FISH, OTHER
    }


}


public class StreamsApi {
    public static void main(String[] args) {

        List<Dish> menu = List.of(
                new Dish("pork", 800, false, Dish.Type.MEAT),
                new Dish("beef", 700, false, Dish.Type.MEAT),
                new Dish("chicken", 400, false, Dish.Type.MEAT),
                new Dish("french fries", 530, true, Dish.Type.OTHER),
                new Dish("rice", 350, true, Dish.Type.OTHER),
                new Dish("season fruit", 120, true, Dish.Type.OTHER),
                new Dish("pizza", 550, true, Dish.Type.OTHER),
                new Dish("prawns", 300, false, Dish.Type.FISH),
                new Dish("salmon", 450, false, Dish.Type.FISH)
        );

        // get all dish names in sorted order where calories are less than 400

        System.out.println(
        menu.stream()
                .filter(dish -> dish.getCalories() < 400)
                .map(dish->dish.getName())
                .sorted()
                .collect(java.util.stream.Collectors.toList())
        );

    }
}
