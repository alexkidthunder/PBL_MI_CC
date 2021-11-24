/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.Mqtt;

import java.util.Arrays;
import java.util.UUID;
import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallbackExtended;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;

/**
 * Classe Subscriber
 * @authors Alexandre & Bianca
 */
public class Subscriber implements MqttCallbackExtended {

    public MqttClient clienteMqtt;
    private final MqttConnectOptions mqttOptions;
    private String userName;
    private String passWord;
    public String urlBroker;
    public String topic;
    public String mensagem = "";

    /**
     * Função Subscriber
     *
     * @param url
     * @param topic
     * @throws MqttException
     */
    public Subscriber(String url, String topic) throws MqttException {
        this.urlBroker = url;
        this.topic = topic;
        String clientId = UUID.randomUUID().toString();
        this.clienteMqtt = new MqttClient(this.urlBroker, clientId); //Definir URL da rota e a identificação

        mqttOptions = new MqttConnectOptions();
        mqttOptions.setMaxInflight(200);
        mqttOptions.setConnectionTimeout(3);
        mqttOptions.setKeepAliveInterval(10);
        mqttOptions.setAutomaticReconnect(true); //Caso a conexão seja perdida, ele se reconecta automaticamente
        mqttOptions.setCleanSession(false);
        mqttOptions.setUserName("alexandre"); //Definir username da conexão
        mqttOptions.setPassword("pQ26q3V".toCharArray()); //Definir password da conexão

        this.clienteMqtt.setCallback(this);
        this.clienteMqtt.connect(mqttOptions);

        this.clienteMqtt.subscribe(topic, 0);

    }

    /**
     * Função que configura a URL
     *
     * @param urlBroker
     */
    public void setUrlBroker(String urlBroker) {
        this.urlBroker = urlBroker;
    }

    /**
     * Função que pega a URL
     *
     * @return
     */
    public String getUrlBroker() {
        return urlBroker;
    }

    /**
     * Função que configura o tópico
     *
     * @param topic
     * @throws MqttException
     */
    public void setTopic(String topic) throws MqttException { //Seta um tópico para ser ouvido
        this.topic = topic;
        this.clienteMqtt.subscribe(topic, 0);
        System.out.println("O cliente se increveu no tópico:" + topic);
    }

    /**
     * Função que pega o tópico
     *
     * @return
     */
    public String getTopic() {
        return topic;
    }

    /**
     * Função que define a mensagem
     *
     * @param mensagem
     */
    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    /**
     * Função que pega a mensagem
     *
     * @return
     */
    public String getMensagem() {
        return this.mensagem;
    }

    /**
     * Função que envia a mensagem
     *
     * @param mensagem
     * @param topico
     * @throws MqttException
     */
    public void mandaMensagem(String mensagem, String topico) throws MqttException {
        mensagemEnviada(mensagem.getBytes(), topico, 0, false);
    }

    /**
     * Função que envia a mensagem com o retido fixo no falso
     *
     * @param payload
     * @param topic
     * @param qos
     * @param retained
     * @throws MqttException
     */
    public synchronized void mensagemEnviada(byte[] payload, String topic, int qos, boolean retained) throws MqttException {
        try {
            if (this.clienteMqtt.isConnected()) {
                this.clienteMqtt.publish(topic, payload, qos, retained);
                System.out.println(String.format("Tópico %s publicado. %s", topic, payload));
            } else {
                System.out.println("Cliente desconectado, não foi possível publicar o tópico " + topic);
            }
        } catch (MqttException ex) {
            System.out.println("Erro ao publicar " + topic + " - " + ex);
        }
    }

    /**
     * Função que Informa se a conexão está ativa
     *
     * @return
     */
    public boolean isConected() {
        return this.clienteMqtt.isConnected();
    }

    /**
     * Função que informa se a conexão foi perdida
     *
     * @param cause
     */
    @Override
    public void connectionLost(Throwable cause) {
        System.out.println("Conexão perdida na causa \""
                + cause.getMessage() + "\" codigo "
                + ((MqttException) cause).getReasonCode() + "\" Causa: \""
                + ((MqttException) cause).getCause() + "\"");
        cause.printStackTrace();
    }

    /**
     * Função que mostra as mensagens que chegam
     *
     * @param topico
     * @param message
     * @throws Exception
     */
    @Override
    public void messageArrived(String topico, MqttMessage message) throws Exception {
        this.mensagem = new String(message.getPayload());
        try {
            System.out.println("Mensagem: \"" + message.toString()
                    + "\" no tópico \"" + topic.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Função que mostra a entrega foi completada
     *
     * @param token
     */
    @Override
    public void deliveryComplete(IMqttDeliveryToken token) {
        try {
            System.out.println("Delivery token \"" + token.hashCode());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Função que checa se a conexão foi completada
     *
     * @param reconnect
     * @param serverURI
     */
    @Override
    public void connectComplete(boolean reconnect, String serverURI) {
        System.out.println("Cliente MQTT " + (reconnect ? "reconectado" : "conectado")
                + " com o broker " + serverURI);
    }

    /**
     * Função para Cancelar subscrição
     *
     * @param topicos
     */
    public void unsubscribe(String... topicos) {
        if (clienteMqtt == null || !clienteMqtt.isConnected() || topicos.length == 0) {
            return;
        }
        try {
            clienteMqtt.unsubscribe(topicos);
        } catch (MqttException ex) {
            System.out.println(String.format("Erro ao se desinscrever no tópico %s - %s", Arrays.asList(topicos), ex));
        }
    }

    /**
     * Função que finaliza o MqttClient
     */
    public void finalizar() {
        if (clienteMqtt == null || !clienteMqtt.isConnected()) {
            return;
        }
        try {
            clienteMqtt.disconnect();
            clienteMqtt.close();
        } catch (MqttException ex) {
            System.out.println(" Erro ao desconectar do broker mqtt - " + ex);
        }
    }
}
