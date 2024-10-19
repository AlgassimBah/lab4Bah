import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.Channel;
import com.rabbitmq.tools.jsonrpc.JsonRpcClient;

public class Send {
    private final static String QUEUE_NAME = "pizzaQueue";
    public static void main(String[] args) throws Exception {

        Pizza pizza = new Pizza("Meat Lovers","Medium","sausage,chicken & beef",11.25);
        Json json = new Json();
        String message = json.toJson(pizza);

        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        try (Connection connection = factory.newConnection();
             Channel channel = connection.createChannel()) {
            channel.queueDeclare(QUEUE_NAME, false, false, false, null);
            String message = "Hello World!";
            channel.basicPublish("", QUEUE_NAME, null, message.getBytes());
            System.out.println(" [x] Sent '" + message + "'");

        }
    }
}
