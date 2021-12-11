/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metodoRemoto;

import controller.auxSys;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import util.Vertice;

/**
 * Classe das funções principais que o Usuário tem no sistema.
 *
 * @authors Alexandre & Bianca
 */
public class ServicesUsuario extends UnicastRemoteObject implements InterfServerToUser {

    private final auxSys auxsys;

    public ServicesUsuario() throws RemoteException {
        super();
        auxsys = auxSys.getAuxSys();
    }

    @Override
    public ArrayList<Vertice> getCaminhos(String origem, String destino) throws RemoteException {
        try {
            return auxsys.getPossiveisCaminhosCombinados(destino, origem);
        } catch (NotBoundException ex) {
            Logger.getLogger(ServicesUsuario.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MalformedURLException ex) {
            Logger.getLogger(ServicesUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public boolean comprarCaminhos(List<String> caminhos) throws RemoteException {
        try {
            return auxsys.comprarTrechos(caminhos);
        } catch (NotBoundException ex) {
            Logger.getLogger(ServicesUsuario.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MalformedURLException ex) {
            Logger.getLogger(ServicesUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
}
