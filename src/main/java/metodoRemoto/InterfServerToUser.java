/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metodoRemoto;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;
import util.Vertice;

/**
 *
 * @authors Alexandre & Bianca
 */
public interface InterfServerToUser extends Remote {

    public ArrayList<Vertice> getCaminhos(String origem, String destino) throws RemoteException;

    public boolean comprarCaminhos(List<String> rotas) throws RemoteException;

}
