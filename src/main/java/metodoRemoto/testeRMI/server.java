/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metodoRemoto.testeRMI;

import controller.CompanhiaControllerServer;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;
import model.Caminho;

/**
 * Classe teste do servidor RMI
 *
 * @author ribei
 */
public class server extends UnicastRemoteObject implements adder {

    private static String companhia;

    public server(String company) throws RemoteException {
        super();
        this.companhia = company;
    }

    
    @Override
    public List<Caminho> add(String texto) throws RemoteException {
        CompanhiaControllerServer server = new CompanhiaControllerServer();

        switch (texto) {
            case "AZUL":

               System.out.println("No AZUL");
            return server.PegarInformacoesServidores("AZUL");

            case "GOL":

                System.out.println("Na GOL");
            return server.PegarInformacoesServidores("GOL");

            case "TAM":         

               System.out.println("Na TAM");
            return server.PegarInformacoesServidores("TAM");
                
             default:
                 return null;
        }
    }
    

    public static void main(String[] args) {
        try {
            Registry reg = LocateRegistry.createRegistry(4444);
            
            reg.rebind("Oi server!", new server("AZUL"));
            System.out.println("Server está pronto..." + companhia);
            reg.rebind("Oi server2!", new server("GOL"));
            System.out.println("Server está pronto..." + companhia);
            reg.rebind("Oi server3!", new server("TAM"));            
            System.out.println("Server está pronto..." + companhia);
        } catch (RemoteException e) {
            System.out.println("Exception" + e);
        }
    }
}
