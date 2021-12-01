/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metodoRemoto.testeRMI;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

/**
 * Classe teste do servidor RMI
 * @author ribei
 */
public class server extends UnicastRemoteObject implements adder {

    public server() throws RemoteException {
        super();
    }

    @Override
    public int add(int n1, int n2) throws RemoteException {
        return n1 + n2;
    }

    public static void main(String[] args) {
        try {
            Registry reg = LocateRegistry.createRegistry(4444);
            reg.rebind("Oi server!", new server());
            System.out.println("Server está pronto...");
        } catch (RemoteException e) {
            System.out.println("Exception"+e);
        }
    }
}
