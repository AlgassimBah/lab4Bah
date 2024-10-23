import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Pizza {

    public static class Pizza {
        private String name;
        private String size;
        private String toppings;
        private double price;

        public Pizza(String name, String size, String toppings, double price) {
            this.name = name;
            this.size = size;
            this.toppings = toppings;
            this.price = price;
        }


        public String toFixedFormatString() {
            return String.format("%-15s%-10s%-30s%-10.2f", name, size, toppings, price);
        }


        public static Pizza fromFixedFormatString(String line) {
            String name = line.substring(0, 15).trim();
            String size = line.substring(15, 25).trim();
            String toppings = line.substring(25, 55).trim();
            double price = Double.parseDouble(line.substring(55, 65).trim());
            return new Pizza(name, size, toppings, price);
        }

        @Override
        public String toString() {
            return "Pizza{name='" + name + "', size='" + size + "', toppings='" + toppings + "', price=" + price + "}";
        }
    }

    public static void main(String[] args) {
        // Example pizzas
        List<Pizza> pizzas = new ArrayList<>();
        pizzas.add(new Pizza("Meat Lovers", "Medium", "Sausage, Chicken, Beef", 11.25));
        pizzas.add(new Pizza("Veggie", "Large", "Tomato, Onion, Peppers", 9.75));

        // Write pizzas to a flat file
        try (PrintWriter writer = new PrintWriter(new FileWriter("pizzas.txt"))) {
            for (Pizza pizza : pizzas) {
                writer.println(pizza.toFixedFormatString());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Read pizzas from the flat file
        List<Pizza> loadedPizzas = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader("pizzas.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                loadedPizzas.add(Pizza.fromFixedFormatString(line));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Display loaded pizzas
        for (Pizza pizza : loadedPizzas) {
            System.out.println(pizza);
        }
    }
}
