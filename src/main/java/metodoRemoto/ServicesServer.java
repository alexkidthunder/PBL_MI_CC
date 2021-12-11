/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metodoRemoto;

import controller.GrafoController;
import controller.auxSys;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import model.Caminho;

/**
 * Classe das funções principais que o Servidor tem no sistema.
 *
 * @authors Alexandre & Bianca
 */
public class ServicesServer extends UnicastRemoteObject implements InterfServerToServer {

    private static final long serialVersionUID = 15L;
    private final String companhia;
    private final Lock lock;
    private final auxSys auxsys;

    public ServicesServer(String companhia) throws RemoteException {
        super();
        this.companhia = companhia;
        auxsys = auxSys.getAuxSys();
        lock = new ReentrantLock();//trava para garantir a exclusão mutua
    }

    @Override
    public GrafoController getGrafoCompanhia() throws RemoteException {
        return auxsys.getGrafo();
    }

    @Override
    public boolean solicitacaoComprarCaminho(String companhia) throws RemoteException {
        Condition myCondition = lock.newCondition();
        try {
            //condição de acesso para esse método = 10 segundos
            myCondition.await(10000L, TimeUnit.MILLISECONDS);
            synchronized (this) {
                if (!auxsys.alguemQuer()) {
                    auxsys.setPermissao(companhia);
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

        return auxsys.comprarTrechos(idCidades, companhia);
    }

//    @Override
//    public List<Caminho> add(String texto) throws RemoteException {
//        //return auxsys.initServer(texto);
//    }
    @Override
    public List<Caminho> add(String texto) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getNomeCompanhia() throws RemoteException {
        return companhia;
    }

    @Override
    public void semaforoPermis(String companhia) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
