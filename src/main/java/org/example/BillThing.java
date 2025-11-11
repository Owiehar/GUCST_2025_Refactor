package org.example;

import java.util.HashMap;
import java.util.ArrayList;

import static org.example.Util.printIndividualItem;
import static org.example.Util.printTally;

public class BillThing {
    private static Map<String, Object> make(String name, double price, boolean food_item, boolean import_tax, int quantity) {
        Map<String, Object> m = new HashMap<>();
        m.put("name", name);
        m.put("price", price);
        m.put("food_item", food_item);
        m.put("import_tax", import_tax);
        m.put("quantity", quantity);
        return m;
    }

    public void calculate(boolean w, boolean vip) {
        List<Map<String, Object>> items = new ArrayList<>();
        items.add(make("Book", 12.49, false, false, 1));
        items.add(make("Music CD", 14.99, false, true, 2));
        items.add(make("Headache pills", 9.75, true, false, 3));
        items.add(make("Chocolate bar", 0.85, true, true, 5));

        double total = 0;
        double taxes = 0;

        // loyalty stuff
        int points = 0;

        double saved = 0; // saved amount

        for (Map<String, Object> item : items) {
            double price = (double) item.get("price");
            boolean food_item = (boolean) item.get("food_item");
            boolean import_tax = (boolean) item.get("import_tax");
            int quanitity = (int) item.get("quantity");
            double tax = 0;
            if (import_tax) {
                tax += price * 0.10;
                if (price > 15) {
                    tax += price * 0.02;
                }
            }
            if (!food_item) {
                tax += price * 0.05;
                if (w) {
                    tax += price * 0.01;
                }
            }
            double finalPrice = (price + tax) * quantity;
            double originalPrice = finalPrice;

            // discounts
            if (price > 10 && !food_item) {
                finalPrice -= 1.0 * quantity;
                if (vip) {
                    if (price > 10) {
                        finalPrice -= 0.5 * quantity;
                        if (import_tax) {
                            finalPrice -= 0.25 * quantity;
                        }
                    }
                }
            }

            // bulk discount
            if (q > 1) {
                if (q >= 3) {
                    if (q >= 5) {
                        finalPrice = finalPrice * 0.85;
                    } else {
                        finalPrice = finalPrice * 0.90;
                    }
                } else {
                    finalPrice = finalPrice * 0.95;
                }
            }

            saved += (originalPrice - finalPrice);
            total += finalPrice;
            taxes += tax * quantity;

            // loyalty points
            if (vip) {
                points += (int)(finalPrice * 2);
                if (points > 100) {
                    points += 10;
                }
            } else {
                points += (int)finalPrice;
                if (points > 100) {
                    points += 10;
                }
            }

            printIndividualItem((String) item.get("name"), quantity, finalPrice);
        }
        printTally(taxes, total, saved, points);
    }
}
