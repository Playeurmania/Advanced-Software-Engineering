import com.rabbitmq.client.*;

import java.io.IOException;

public class Régulateur {
  private static final String EXCHANGE_NAME = "regulator_zirmi";
  private final static String QUEUE_NAME = "zirmi";

  public static void main(String[] argv) throws Exception {
    ConnectionFactory factory = new ConnectionFactory();
    factory.setHost("52.49.154.179");
    Connection connection = factory.newConnection();
    Channel channel = connection.createChannel();
    
    
    channel.queueDeclare(QUEUE_NAME, false, false, false, null);
    System.out.println(" [*] Waiting for messages from the queue. To exit press CTRL+C");
    
    Consumer consumer = new DefaultConsumer(channel) {
        @Override
        public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body)
            throws IOException {
          String message = new String(body, "UTF-8");
          System.out.println(" [x] Received '" + message + "'");
        }
      };
      channel.basicConsume(QUEUE_NAME, true, consumer);
    

    channel.exchangeDeclare(EXCHANGE_NAME, "fanout");
    
    String message = getMessage(argv);

    channel.basicPublish(EXCHANGE_NAME, "", null, message.getBytes("UTF-8"));
    System.out.println(" [x] Sent '" + message + "'");  
    
    /*
    channel.close();
    connection.close();
    */
  }
  
  
  private static String getMessage(String[] strings){
	    if (strings.length < 1)
	    	    return "info: Hello World!";
	    return joinStrings(strings, " ");
	  }

	  private static String joinStrings(String[] strings, String delimiter) {
	    int length = strings.length;
	    if (length == 0) return "";
	    StringBuilder words = new StringBuilder(strings[0]);
	    for (int i = 1; i < length; i++) {
	        words.append(delimiter).append(strings[i]);
	    }
	    return words.toString();
	  }
  
}