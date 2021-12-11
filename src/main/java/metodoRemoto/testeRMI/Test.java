/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metodoRemoto.testeRMI;

import controller.auxSys;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

/**
 * Classe teste do cliente RMI
 *
 * @author ribei
 */
public class Test {

    public static void main(String args[]) throws RemoteException, MalformedURLException, NotBoundException {
        String server = connectRemote();

        auxSys auxiliar = auxSys.getAuxSys();
        auxiliar.initServer(server);
        Registry reg = LocateRegistry.getRegistry(1099);
        String[] ativo = reg.list();
        System.out.println(ativo);
        
        System.out.println(auxiliar.getGrafo().grafo.getVertices());
        System.out.println(auxiliar.getGrafo().grafo.getArestas());


    }

    public static String connectRemote() throws RemoteException {

        System.out.println("********************Seja bem vindo ao sistema********************");
        System.out.println("\n Digite a companhia para iniciar o servidor \n");
        System.out.println(" AZUL para o servidor AZUL ");
        System.out.println(" GOL para o servidor GOL ");
        System.out.println(" TAM para o servidor TAM ");

        Scanner in = new Scanner(System.in);
        return in.next();
//        try {
//            Registry reg = LocateRegistry.getRegistry("localhost", 4444);
//            List<Caminho> array = new ArrayList<Caminho>();
//
//            // Pegar informações da companhia AZUL
//            adder ad = (adder) reg.lookup("Oi server!");
//            array.addAll(ad.add("AZUL"));
//            //System.out.println("addition 1:" + ad.add("AZUL").get(0).getPrecoBilhete());
//
//            // Pegar informações da companhia GOL
////            adder a2 = (adder) reg.lookup("Oi server2!");
////            array.addAll(ad.add("GOL"));
////            System.out.println("addition 1:" + a2.add("GOL").get(0).getPrecoBilhete());
////
//            // Pegar informações da companhia TAM
////            adder a3 = (adder) reg.lookup("Oi server3!");
////            array.addAll(ad.add("TAM"));
////            System.out.println("addition 1:" + a3.add("TAM").get(0).getPrecoBilhete());
//
//            GrafoController cont = new GrafoController();
//            cont.pegarInformações(array);
//            
//            System.out.println(cont.grafo.getArestas());
//        } catch (NotBoundException | RemoteException e) {
//            System.out.println("Exception:" + e);
//        }

    }
}
