/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metodoRemoto.testeRMI;

import controller.CompanhiaControllerServer;
import controller.GrafoController;
import controller.auxSys;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import java.util.List;
import model.Caminho;

/**
 * Classe teste do cliente RMI
 *
 * @author ribei
 */
public class client {
        private final auxSys auxiliar;

    public client() {
        auxiliar = auxSys.getAuxSys();
    }
        

    public static void main(String args[]) throws RemoteException {
        client c = new client();        
        c.connectRemote();
        
    }

    private void connectRemote() throws RemoteException {
        try {
            Registry reg = LocateRegistry.getRegistry("localhost", 4444);
            List<Caminho> array = new ArrayList<Caminho>();

            // Pegar informações da companhia AZUL
            adder ad = (adder) reg.lookup("Oi server!");
            array.addAll(ad.add("AZUL"));
            //System.out.println("addition 1:" + ad.add("AZUL").get(0).getPrecoBilhete());

            // Pegar informações da companhia GOL
//            adder a2 = (adder) reg.lookup("Oi server2!");
//            array.addAll(ad.add("GOL"));
//            System.out.println("addition 1:" + a2.add("GOL").get(0).getPrecoBilhete());
//
            // Pegar informações da companhia TAM
//            adder a3 = (adder) reg.lookup("Oi server3!");
//            array.addAll(ad.add("TAM"));
//            System.out.println("addition 1:" + a3.add("TAM").get(0).getPrecoBilhete());

            GrafoController cont = new GrafoController();
            cont.pegarInformações(array);
            
            System.out.println(cont.grafo.getArestas());
        } catch (NotBoundException | RemoteException e) {
            System.out.println("Exception:" + e);
        }

    }
}
