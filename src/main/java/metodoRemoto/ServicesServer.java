/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metodoRemoto;

import controller.CompanhiaControllerServer;
import controller.auxSys;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import util.Grafo;

/**
 * Classe das funções principais que o Servidor tem no sistema.
 *
 * @authors Alexandre & Bianca
 */
public class ServicesServer extends UnicastRemoteObject implements InterfServerToServer {

    private static final long serialVersionUID = 15L;
    private final String companhia;
    private final Lock lock;

    public ServicesServer(String companhia) throws RemoteException {
        super();
        this.companhia = companhia;
        lock = new ReentrantLock();//trava para garantir a exclusão mutua
    }

    @Override
    public ArrayList<Grafo> getGrafoCompanhia() throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /*@Override
    public String getNomeCompanhia() throws RemoteException {
        return companhia;
    }*/
    @Override
    public boolean solicitacaoComprarCaminho(String companhia) throws RemoteException {
        Condition myCondition = lock.newCondition();
        try {
            //condição de acesso para esse método = 30 segundos
            myCondition.await(30000L, TimeUnit.MILLISECONDS);
            synchronized (this) {
                if (!facade.alguemQuer()) {
                    facade.setPermissão(companhia);
                    return true;
                }
            }
        } catch (InterruptedException e) {
            return false;
        } finally {
            lock.unlock();
        }
        return false;

    }

    @Override
    public boolean comprarCaminhoCompanhia(List<String> idCidades, String companhia) throws RemoteException {

        return auxSys;
    }

    /*@Override
    public void semaforoPermis(String companhia) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }*/
}
