package com.example;


import java.util.List;
import java.util.function.Predicate;

class Apple {
    private String color;
    private int weight;

    public Apple(String color, int weight) {
        this.color = color;
        this.weight = weight;
    }

    public String getColor() {
        return this.color;
    }

    public int getWeight() {
        return this.weight;
    }

    @Override
    public String toString() {
        return "Apple{" +
                "color='" + color + '\'' +
                ", weight=" + weight +
                '}';
    }
}


// style of programming :
//1. imperative style
// solving any problem step by step
// intention & implementation are mixed

//2. declarative style
// intention & implementation are separated


public class LambdaExpression {
    public static void main(String[] args) {

        List<Apple> appleInventory = List.of(
                new Apple("Red", 100),
                new Apple("Green", 200),
                new Apple("Red", 300)
        );


        // Req-1 : get all red apples
        System.out.println(
                filterApples(appleInventory, apple -> apple.getColor().equals("Red"))
        );

        // Req-2 : get all green apples
        System.out.println(
                filterApples(appleInventory, apple -> apple.getColor().equals("Green"))
        );

        // Req-3 : get all apples with weight > 150
        System.out.println(
                filterApples(appleInventory, apple -> {
                    return apple.getWeight() > 150;
                })
        );

        // Req-4 : get all apples with weight > 150 and color is red
        System.out.println(
                filterApples(appleInventory, apple -> apple.getWeight() > 150 && apple.getColor().equals("Red"))
        );
    }

    // Behavior parameterization
    private static List<Apple> filterApples(List<Apple> appleInventory, Predicate<Apple> predicate) {
        List<Apple> filteredResult = new java.util.ArrayList<>();
        for (Apple apple : appleInventory) {
            if (predicate.test(apple)) {
                filteredResult.add(apple);
            }
        }
        return filteredResult;
    }

}
