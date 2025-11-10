package org.example;

public class Util {
    // DO NOT MODIFY THIS METHOD
    public static void printTally(double totalTax, double totalPrice, double totalSaved, int loyaltyPoints) {
        System.out.println("Sales Taxes: " + String.format("%.2f", totalTax));
        System.out.println("Total: " + String.format("%.2f", totalPrice));
        System.out.println("You saved: " + String.format("%.2f", totalSaved));
        System.out.println("Loyalty points earned: " + loyaltyPoints);
        if (loyaltyPoints > 50) {
            if (loyaltyPoints > 100) {
                if (loyaltyPoints > 200) {
                    System.out.println("Status: PLATINUM MEGA VIP");
                } else {
                    System.out.println("Status: Gold Member");
                }
            } else {
                System.out.println("Status: Silver");
            }
        }
    }

    // DO NOT MODIFY THIS METHOD
    public static void printIndividualItem(String name, int quantity, double finalPrice) {
        System.out.println(name + " (x" + quantity + "): " + String.format("%.2f", finalPrice));
    }
}