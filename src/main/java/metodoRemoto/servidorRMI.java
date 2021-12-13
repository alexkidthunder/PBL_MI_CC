/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metodoRemoto;

import java.rmi.Naming;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.net.MalformedURLException;

/**
 * Classe servidor RMI.
 *
 * @authors Alexandre & Bianca
 */
public class servidorRMI {

    /**
     * Servidor RMI que define as configurações do sistema, salva a porta do
     * servidor, define os serviços que serão acessados.Ele faz a chamadas das
     * classes usadas entre servidot-servidor e cliente-servidor
     *
     * @param companhia
     * @param host
     * @param port
     * @throws java.net.MalformedURLException
     */
    public servidorRMI(String companhia, String host, int port) throws MalformedURLException {
        try {
            System.setProperty("java.rmi.server.hostname", host);// Configura o nome do host
            LocateRegistry.createRegistry(port);// Cria um registro rmi com a porta port

            ServicesServer InterServers = new ServicesServer(companhia);
            //método vincula o nome da companhia com o objeto remoto
            Naming.rebind("ServiceServer_" + companhia, (Remote) InterServers);
            System.out.println("Foi realizado o bind no registro entre os servidore com sucesso...");

            ServicesUsuario user = new ServicesUsuario();
            Naming.rebind("UserService_" + companhia, (Remote) user);
            System.out.println("Foi realizado o bind para os clientes no registro com sucesso...");

            System.out.println("O servidor da companhia " + companhia + " está pronto para trocar informações.");

        } catch (RemoteException ex) {
            System.out.println(ex);
        }

    }

}
