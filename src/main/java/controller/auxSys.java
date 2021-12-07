/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.List;
import metodoRemoto.InterfServerToServer;
import metodoRemoto.servidorRMI;
import model.Caminho;
import model.Concorrencia;
import util.Grafo;

/**
 *
 * @author ribei
 */
public class auxSys {

    private final CompanhiaControllerServer companhiacontrollerServer;
    private servidorRMI servidorRMI;
    private final GrafoController grafo;
    private final TransactionsController emOutroServidorComprar;
    private final Concorrencia semaforo;

    private static auxSys aux;

    public auxSys() {
        this.companhiacontrollerServer = new CompanhiaControllerServer();
        grafo = new GrafoController();
        emOutroServidorComprar = new TransactionsController();
        semaforo = new Concorrencia();
    }

    public static synchronized auxSys getAuxSys() {
        return (aux == null) ? aux = new auxSys() : aux;
    }

    /**
     * Da a inicialização do servidor
     *
     * @param servidor
     * @throws java.net.MalformedURLException
     */
    public void initServer(String servidor) throws MalformedURLException {
        List<Caminho> caminho = companhiacontrollerServer.PegarInformacoesServidores(servidor);
        servidorRMI = new servidorRMI(companhiacontrollerServer.getInitServerNome(),
                companhiacontrollerServer.getInitServerHost(),
                companhiacontrollerServer.getInitServerPorta());
        grafo.pegarInformações(caminho);
    }

    /**
     * Pega as informações do grafo
     *
     * @return
     */
    public GrafoController getGrafo() {
        return grafo;
    }
    
        /**
     *Pega os caminhos possíveis entre dois pontos de todos os servidores
     * @param inicio
     * @param fim
     * @return 
     */
    public Caminho getPossiveisCaminhosCombinados(String inicio, String fim) throws NotBoundException, MalformedURLException, RemoteException {
        InterfServerToServer lookupMethod = null;
        InterfServerToServer lookupMethod2 = null;
        try{
            lookupMethod = companhiacontrollerServer.getserverUmLookupMethod();
        }catch(NullPointerException e){}
        
        try{
            lookupMethod2 = companhiacontrollerServer.getserverDoisLookupMethod();
        }catch(NullPointerException e){}
        
        return grafo.getPossiveisCaminhosMergered(lookupMethod, lookupMethod2, inicio, fim);
        
    }
    
        /**
     *checa se algum dos três servidores tem interesse em fazer a compra no momento
     * @return
     */
    public boolean alguemQuer(){
        return semaforo.qualquerSoliciatacao();
    }

}
