import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;

public class Pub {
    public static void main(String[] args) throws MqttException {
        String topic = "topic1";
        String content = "Message de test";
        String broker = "tcp://localhost";

        MqttClient client = new MqttClient(broker, MqttClient.generateClientId());

        client.connect();
        System.out.println("Le publisher envoie !");

        MqttMessage message = new MqttMessage(content.getBytes());
        message.setRetained(false);

        client.publish(topic, message);
    }
}
