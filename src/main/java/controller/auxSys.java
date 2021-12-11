/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;
import metodoRemoto.InterfServerToServer;
import metodoRemoto.servidorRMI;
import model.Caminho;
import model.Concorrencia;
import util.Aresta;
import util.Vertice;

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
        //System.out.println(caminho.size());
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
     * Pega os caminhos possíveis entre dois pontos de todos os servidores
     *
     * @param inicio
     * @param fim
     * @return
     */
    public ArrayList<Vertice> getPossiveisCaminhosCombinados(String inicio, String fim) throws NotBoundException, MalformedURLException, RemoteException {
        InterfServerToServer lookupMethod = null;
        List<Caminho> array = new ArrayList<>();
        InterfServerToServer lookupMethod2 = null;
        List<Caminho> array2 = new ArrayList<>();

        try {
            lookupMethod = companhiacontrollerServer.getserverUmLookupMethod();// Pear os caminhos do servidor Um            
            //array.addAll(lookupMethod.getGrafoCompanhia().grafo.getArestas());
            grafo.pegarInformações(array);
        } catch (NullPointerException e) {
        }

        try {
            lookupMethod2 = companhiacontrollerServer.getserverDoisLookupMethod();// Pear os caminhos do servidor Dois
            //array2.addAll(lookupMethod.getGrafoCompanhia().grafo.getArestas());
            grafo.pegarInformações(array2);
        } catch (NullPointerException e) {
        }
        return grafo.encontrarMenorCaminhoDijkstra(inicio, fim);

    }

    /**
     * checa se algum dos três servidores tem interesse em fazer a compra no
     * momento
     *
     * @return
     */
    public boolean alguemQuer() {
        return semaforo.qualquerSoliciatacao();
    }

    public void setPermissao(String companhia) {
        semaforo.setPermissao(companhia);
    }

    public void removePermissao(String companhia) {
        semaforo.removerPermissaoCompanhia(companhia);
    }

    public boolean comprarTrechos(List<String> caminhos) throws NotBoundException, MalformedURLException, RemoteException {
        if (!semaforo.qualquerSoliciatacao()) {
            semaforo.setPermissao(companhiacontrollerServer.getInitServerNome());
            InterfServerToServer lookupMethod = null;
            InterfServerToServer lookupMethod2 = null;

            try {
                lookupMethod = companhiacontrollerServer.getserverUmLookupMethod();// Os caminhos do servidor Um         
            } catch (NullPointerException e) {
            }
            try {
                lookupMethod2 = companhiacontrollerServer.getserverDoisLookupMethod();// Os caminhos do servidor Dois
            } catch (NullPointerException e) {
            }
//            try {
//                List<Aresta> arestas = grafo.getVertices(lookupMethod, lookupMethod2);
//                List<String> realizarCompra = emOutroServidorComprar.realizarCompraNosOutrosServidores(
//                        companhiacontrollerServer.getServerUm(), companhiacontrollerServer.getServerDois(), arestas, companhiacontrollerServer.getInitServerNome());
//                return comprarTrechos(realizarCompra, companhiacontrollerServer.getInitServerNome());
//            } catch (NullPointerException e) {
//                return false;
//            } 
        finally {
                semaforo.removerPermissaoCompanhia(companhiacontrollerServer.getInitServerNome());
            }

        }
        return false;
    }

    public boolean comprarTrechos(List<String> aeroportos, String companhia) {
//        if (semaforo.getPermissao().equalsIgnoreCase(companhia)) {
//            ArrayList<ArrayList<Vertice>> arestasId = grafo.grafo.indentificarCaminhos(aeroportos);
//            if (!arestasByIds.stream().noneMatch(arestasId -> (!arestasId.get(0).getBilhete().comprarPassagem()))) {
//                return false;
//            }
//            return true;
//        }
        return false;
    }
}
