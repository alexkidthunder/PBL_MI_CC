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
import java.util.Scanner;
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

    public static String init() {
        System.out.println("********************Seja bem vindo ao sistema********************");
        System.out.println("\n Digite a companhia para iniciar o servidor \n");
        System.out.println(" AZUL para o servidor AZUL ");
        System.out.println(" GOL para o servidor GOL ");
        System.out.println(" TAM para o servidor TAM ");

        Scanner in = new Scanner(System.in);
        return in.next();
    }

    public static void main(String[] args) {
//        try {
//            Registry reg = LocateRegistry.createRegistry(4444);
//            
//            reg.rebind("Oi server!", new server("AZUL"));
//            System.out.println("Server está pronto..." + companhia);
//            reg.rebind("Oi server2!", new server("GOL"));
//            System.out.println("Server está pronto..." + companhia);
//            reg.rebind("Oi server3!", new server("TAM"));            
//            System.out.println("Server está pronto..." + companhia);
//        } catch (RemoteException e) {
//            System.out.println("Exception" + e);
//        }

        try {
            //Registry reg = LocateRegistry.createRegistry(4444);

            switch (init()) {
                case "AZUL":
                    Registry reg = LocateRegistry.createRegistry(4444);
                    reg.rebind("Oi server!", new server("AZUL"));
                    System.out.println("Server está pronto..." + companhia);
                    break;

                case "GOL":
                    Registry re = LocateRegistry.createRegistry(4445);
                    re.rebind("Oi server2!", new server("GOL"));
                    System.out.println("Server está pronto..." + companhia);
                    break;

                case "TAM":
                    Registry r = LocateRegistry.createRegistry(4446);
                    r.rebind("Oi server3!", new server("TAM"));
                    System.out.println("Server está pronto..." + companhia);
                    break;

                default:
                    System.out.println("Ocorreu algum problema na inicialização");
                    break;

            }
        } catch (RemoteException e) {
            System.out.println("Exception" + e);
        }

    }
}
