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

    /**
     * Construtor da classe ServicesUsuario
     *
     * @throws RemoteException
     */
    public ServicesUsuario() throws RemoteException {
        super();
        auxsys = auxSys.getAuxSys();
    }

    /**
     * Função que compra o caminho passando a lita dos caminhos selecionados.
     *
     * @param caminhos
     * @return
     * @throws RemoteException
     */
    @Override
    public boolean comprarCaminhos(List<String> caminhos) throws RemoteException {
        try {
            return auxsys.comprarCaminhos(caminhos);
        } catch (NotBoundException ex) {
            System.err.println(ex);
        } catch (MalformedURLException ex) {
            System.err.println(ex);
        }
        return false;
    }

    /**
     * Função que pega os caminhos passando a origem e o destino.
     *
     * @param origem
     * @param destino
     * @return
     * @throws RemoteException
     */
    @Override
    public ArrayList<Vertice> getCaminhos(String origem, String destino) throws RemoteException {
        try {
            return auxsys.pegarPossiveisCaminhos(destino, origem);
        } catch (NotBoundException ex) {
            System.err.println(ex);
        } catch (MalformedURLException ex) {
            System.err.println(ex);
        }
        return null;
    }

}
