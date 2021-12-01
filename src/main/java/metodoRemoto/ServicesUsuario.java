/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metodoRemoto;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;
import model.Caminho;

/**
 *
 * @authors Alexandre & Bianca
 */
public class ServicesUsuario extends UnicastRemoteObject implements InterfServerToUser {

    @Override
    public Caminho getCaminhos(String origem, String destino) throws RemoteException {
        return null;
    }

    @Override
    public boolean comprarCaminhos(List<String> rotas) throws RemoteException {
        return false;
    }
}
