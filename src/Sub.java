import org.eclipse.paho.client.mqttv3.*;

public class Sub implements MqttCallback {

    public static void main(String[] args) throws MqttException {
        new Sub().demo();
    }

    public void demo() throws MqttException
    {
        String topic = "topic1";
        String broker = "tcp://localhost";

        MqttClient client = new MqttClient(broker, MqttClient.generateClientId());
        client.connect();
        System.out.println("Le subscriber écoute");

        client.subscribe(topic);
        client.setCallback(this);
    }

    @Override
    public void connectionLost(Throwable throwable) {

    }

    @Override
    public void messageArrived(String s, MqttMessage mqttMessage) throws Exception {
        System.out.println(mqttMessage);
    }

    @Override
    public void deliveryComplete(IMqttDeliveryToken iMqttDeliveryToken) {

    }
}
