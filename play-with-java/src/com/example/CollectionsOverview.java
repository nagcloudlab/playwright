package com.example;

import java.util.*;

class Product implements Comparable<Product> {
    private String name;
    private double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public int compareTo(Product o) {
        return this.name.compareTo(o.name);
    }
}


public class CollectionsOverview {
    public static void main(String[] args) {


        Product product1 = new Product("Laptop", 1000.0);
        Product product2 = new Product("Mobile", 500.0);
        Product product3 = new Product("Tablet", 300.0);
        Product product4 = new Product("Smart Watch", 200.0);

        //--------------------------------------------------------------------------------
        // List
        //--------------------------------------------------------------------------------

        List<Product> products = new ArrayList<>(); //
        products.add(product1);
        products.add(product2);
        products.add(product3);
        products.add(product4);
        products.add(product1);

       // loop / iterate

        // way-1: Manual iteration
        for (int i = 0; i < products.size(); i++) {
            Product product = products.get(i);
            System.out.println(product.getName() + " : " + product.getPrice());
        }

        System.out.println("----------------------------------------------------");

        // way-2: iterator
        Iterator<Product> iterator = products.iterator();
        while (iterator.hasNext()) {
            Product product = iterator.next();
            System.out.println(product.getName() + " : " + product.getPrice());
        }

        System.out.println("----------------------------------------------------");

        // way-3: for-each
        for (Product product : products) {
            System.out.println(product.getName() + " : " + product.getPrice());
        }

        System.out.println("----------------------------------------------------");

        //--------------------------------------------------------------------------------
        // Set
        // --

        Set<Product> productSet = new TreeSet<>();
        productSet.add(product1);
        productSet.add(product2);
        productSet.add(product3);
        productSet.add(product4);
        productSet.add(product1);

        for (Product product : productSet) {
            System.out.println(product.getName() + " : " + product.getPrice());
        }

        System.out.println("----------------------------------------------------");


        // delete an element from set collection

        // way-1: using remove method
        // productSet.remove(product1);

        // way-2: using iterator
        Iterator<Product> productIterator = productSet.iterator();
        while (productIterator.hasNext()) {
            Product product = productIterator.next();
            if (product.getName().equals("Mobile")) {
                productIterator.remove();
            }
        }

        // way-3: using Lambda expression (Java 8)
        productSet.removeIf(product -> product.getName().equals("Tablet"));

        System.out.println("----------------------------------------------------");

        //--------------------------------------------------------------------------------
        // Map
        // -------------------------------------------------------------------------------

        Map<String, Product> productMap = new HashMap<>();
        productMap.put("laptop", product1);
        productMap.put("mobile", product2);
        productMap.put("tablet", product3);

        Product product = productMap.get("laptop");
        System.out.println(product.getName() + " : " + product.getPrice());

        System.out.println("----------------------------------------------------");


        // -------------------------
        // Immutable Collections
        // -------------------------

        List<Product> immutableProducts = List.of(product1, product2, product3, product4);

    }
}
