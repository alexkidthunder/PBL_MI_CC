/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metodoRemoto;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Classe servidor RMI.
 *
 * @authors Alexandre & Bianca
 */
public class servidorRMI {

    /**
     * servidor RMI que define as configurações do sistema, salva a porta do
     * servidor, define os serviços que serão acessados.
     *
     * @param companhia
     * @param host
     * @param port
     */
    public servidorRMI(String companhia, String host, int port) {
        try {
            //System.setProperty("java.rmi.server.hostname", host);// Configura o nome do host
            LocateRegistry.createRegistry(port);// Cria um registro rmi com a porta port
            
            
        } catch (RemoteException ex) {
            Logger.getLogger(servidorRMI.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
