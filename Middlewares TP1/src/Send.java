import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

public class Send {
	
  static int temperature = 20;

  private final static String QUEUE_NAME = "zirmi";

  public static void main(String[] argv) throws Exception {
    while (true) {
    	
		ConnectionFactory factory = new ConnectionFactory();
		factory.setHost("52.49.154.179");
		Connection connection = factory.newConnection();
		Channel channel = connection.createChannel();
		
		
		Thread.sleep(1000);
		temperature += Math.ceil(Math.random()*3-2);
		
		channel.queueDeclare(QUEUE_NAME, false, false, false, null);
		String message = "La température de la pièce est de : " + Integer.toString(temperature) + "°C.";
		channel.basicPublish("", QUEUE_NAME, null, message.getBytes("UTF-8"));
		System.out.println(" [x] Sent '" + message + "'");
		channel.close();
		connection.close();
	}
  }
  
  
  
}