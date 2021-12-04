/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metodoRemoto.testeRMI;

import controller.CompanhiaControllerServer;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;
import model.Caminho;

/**
 * Teste interface RMI
 * @author ribei
 */
public interface adder extends Remote{
    public List<Caminho> add(String texto) throws RemoteException;
}
