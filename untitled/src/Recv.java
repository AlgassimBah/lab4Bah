import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.DeliverCallback;

public class Recv {

    private final static String QUEUE_NAME = "pizzaQueue";

    public static class Pizza {
        private String name;
        private String size;
        private String toppings;
        private double price;

        // Default constructor
        public Pizza() {}

        // Constructor with fields
        public Pizza(String name, String size, String toppings, double price) {
            this.name = name;
            this.size = size;
            this.toppings = toppings;
            this.price = price;
        }

        // Getters and setters
        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getSize() {
            return size;
        }

        public void setSize(String size) {
            this.size = size;
        }

        public String getToppings() {
            return toppings;
        }

        public void setToppings(String toppings) {
            this.toppings = toppings;
        }

        public double getPrice() {
            return price;
        }

        public void setPrice(double price) {
            this.price = price;
        }

        @Override
        public String toString() {
            return "Pizza{name='" + name + "', size='" + size + "', toppings='" + toppings + "', price=" + price + "}";
        }
    }
    public static Pizza fromJsonString(String json) {
        Pizza pizza = new Pizza();
        json = json.replaceAll("[{}\"]", ""); // Remove JSON curly braces and quotes
        String[] fields = json.split(",");    // Split key-value pairs

        for (String field : fields) {
            String[] keyValue = field.split(":");
            String key = keyValue[0].trim();
            String value = keyValue[1].trim();

            switch (key) {
                case "name":
                    pizza.setName(value);
                    break;
                case "size":
                    pizza.setSize(value);
                    break;
                case "toppings":
                    pizza.setToppings(value);
                    break;
                case "price":
                    pizza.setPrice(Double.parseDouble(value));
                    break;
            }
        }
        return pizza;
    }
}


public static void main(String[] argv) throws Exception {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();

        channel.queueDeclare(QUEUE_NAME, false, false, false, null);
        System.out.println(" [*] Waiting for messages. To exit press CTRL+C");

        DeliverCallback deliverCallback = (consumerTag, delivery) -> {
            String message = new String(delivery.getBody(), "UTF-8");
            System.out.println(" [x] Received message: '" + message + "'");

            Pizza pizza = Pizza.fromJsonString(message);

            // Print the deserialized Pizza object
            System.out.println("Pizza Object: " + pizza);
        };

        channel.basicConsume(QUEUE_NAME, true, deliverCallback, consumerTag -> {});
    }
}
