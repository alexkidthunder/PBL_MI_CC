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

    /**
     * Construtor da classe ServicesServer
     *
     * @param companhia
     * @throws RemoteException
     */
    public ServicesServer(String companhia) throws RemoteException {
        super();

        lock = new ReentrantLock();//trava para garantir a exclusão mutua
        auxsys = auxSys.getAuxSys();
        this.companhia = companhia;
    }

    /**
     * Função que retorna o grafo
     *
     * @return
     * @throws RemoteException
     */
    @Override
    public GrafoController getGrafoCompanhia() throws RemoteException {
        return auxsys.getGrafo();
    }

    /**
     * Função de confirmação de comprar o caminho na companhia.
     *
     * @param idCidades
     * @param companhia
     * @return
     * @throws RemoteException
     */
    @Override
    public boolean comprarCaminhoCompanhia(List<String> idCidades, String companhia) throws RemoteException {

        return auxsys.comprarCaminhos(idCidades, companhia);
    }

    /**
     * Função que lida com a permissão da concorrência.
     *
     * @param companhia
     * @throws RemoteException
     */
    @Override
    public void semaforoPermis(String companhia) throws RemoteException {
        auxsys.removePermissao(companhia);
    }

    /**
     * Função que faz solicita a compra do caminho da companhia passada
     *
     * @param companhia
     * @return
     * @throws RemoteException
     */
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

    /**
     *
     * @param texto
     * @return
     * @throws RemoteException
     */
    @Override
    public List<Caminho> add(String texto) throws RemoteException {
        return (List<Caminho>) auxsys.getGrafo();
    }

    /**
     * Função que retorna o nome da companhia.
     *
     * @return
     * @throws RemoteException
     */
    @Override
    public String getNomeCompanhia() throws RemoteException {
        return companhia;
    }
}
