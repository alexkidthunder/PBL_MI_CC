/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.CompanhiaControllerServer;
import controller.auxSys;
import java.net.MalformedURLException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;
import java.util.Scanner;
import metodoRemoto.adder;
import model.Caminho;

/**
 * Classe teste do servidor RMI
 *
 * @authors Alexandre & Bianca
 */
public class server extends UnicastRemoteObject implements adder {

    private static String companhia;
    CompanhiaControllerServer server;

    public server(String company) throws RemoteException {
        super();
        this.companhia = company;
        this.server = new CompanhiaControllerServer();
    }

    @Override
    public List<Caminho> add(String texto) throws RemoteException {

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

    public static void main(String[] args) throws MalformedURLException {
        auxSys auxiliar = auxSys.getAuxSys();

        try {
            //auxiliar.initServer(init());
            switch (init()) {
                case "AZUL":
                    Registry reg = LocateRegistry.createRegistry(4444);
                    reg.rebind("Registro 1", new server("AZUL"));
                    System.out.println("Server está pronto..." + companhia);
                    break;

                case "GOL":
                    Registry re = LocateRegistry.createRegistry(4445);
                    re.rebind("Registro 2", new server("GOL"));
                    System.out.println("Server " + companhia + " está pronto.");
                    break;

                case "TAM":
                    Registry r = LocateRegistry.createRegistry(4446);
                    r.rebind("Registro 3", new server("TAM"));
                    System.out.println("Server " + companhia + " está pronto.");
                    break;

                default:
                    System.out.println("Ocorreu algum problema na inicialização");
                    break;

            }
        } catch (RemoteException e) {
            System.out.println("Ocorreu a Exception" + e);
        }

    }
}
