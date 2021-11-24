/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.Mqtt;

import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;

/**
 * Classe Publisher
 * @authors Alexandre & Bianca
 */
public class Publisher {

    public MqttClient clienteMqtt;
    public String urlBroker;
    public String topic;
    public String informacao;

    /**
     * Cria um Publisher passando como parametros url, topico, dados.
     *
     * @param url
     * @param topic
     * @param dados
     */
    public Publisher(String url, String topic, String dados) throws MqttException {
        this.topic = topic;
        this.informacao = dados;
        this.urlBroker = url;
        
        this.clienteMqtt = new MqttClient(this.urlBroker, "alexandre");
        this.clienteMqtt.connect();// Algum momento ele tem que desconectar

        MqttMessage enviarInfo = new MqttMessage((dados).getBytes());

        //System.out.println("Enviando dados ao tópico");
        try {
            clienteMqtt.publish(topic, enviarInfo);
        } catch (Exception e) {
            
        }
    }
}
