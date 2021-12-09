/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metodoRemoto;

import controller.GrafoController;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;
import model.Caminho;

/**
 *
 * @authors Alexandre & Bianca
 */
public interface InterfServerToServer extends Remote {

    public List<Caminho> add(String texto) throws RemoteException;
    
    public GrafoController getGrafoCompanhia() throws RemoteException;

    public String getNomeCompanhia() throws RemoteException;
    
    public boolean solicitacaoComprarCaminho(String companhia) throws RemoteException;

    public boolean comprarCaminhoCompanhia(List<String> idCidades, String companhia) throws RemoteException;

    public void semaforoPermis(String companhia) throws RemoteException;
}
