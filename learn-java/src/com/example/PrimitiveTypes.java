package com.example;

public class PrimitiveTypes {
    public static void main(String[] args) {


        // Primitive types
        byte byteValue = 10; // -12 to 127  - 8 bits
        short shortValue = 20; // -32,768 to 32,767 - 16 bits
        int intValue = 30; // -2,147,483,648 to 2,147,483,647 - 32 bits
        long longValue = 234234234234234234L; // -9,223,372,036,854,775,808 to 9,223,372,036,854,775,807 - 64 bits
        float floatValue = 50.0F; // 32 bits
        double doubleValue = 60.0; // 64 bits
        char charValue1 = 'A'; // 16 bits
        char charValue2 = 65; // 16 bits
        char charValue3 = '\u0041'; // 16 bits
        boolean booleanValue = true;  // 1 bit

        System.out.println("byteValue: " + byteValue);
        System.out.println("shortValue: " + shortValue);
        System.out.println("intValue: " + intValue);
        System.out.println("longValue: " + longValue);
        System.out.println("floatValue: " + floatValue);
        System.out.println("doubleValue: " + doubleValue);
        System.out.println("charValue: " + charValue1);
        System.out.println("charValue: " + charValue2);
        System.out.println("charValue: " + charValue3);
        System.out.println("booleanValue: " + booleanValue);


        long largeAmount = 100_000_000;
        System.out.println("amount: " + largeAmount);




    }
}
