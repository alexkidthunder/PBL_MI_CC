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
 * Classe auxiliar para realização das funções internas do sistema.
 *
 * @author ribei
 */
public class auxSys {

    private servidorRMI servidorRMI;
    private final Concorrencia semaforo;
    private final GrafoController grafo;
    private final TransactionsController emOutroServidorComprar;
    private final CompanhiaControllerServer companhiacontrollerServer;
    private static auxSys aux;

    /**
     * Construtor da classe auxiliar
     */
    public auxSys() {
        this.companhiacontrollerServer = new CompanhiaControllerServer();
        emOutroServidorComprar = new TransactionsController();
        grafo = new GrafoController();
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
        // Pega as informações dos caminhos do servidor passado como parâmetro
        List<Caminho> caminho = companhiacontrollerServer.PegarInformacoesServidores(servidor);
        // Configura as propriedades do sistema  
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
     * Pega os caminhos possíveis entre dois pontos de todos os servidores,
     * através dos métodos remotos de cada servidor
     *
     * @param inicio
     * @param fim
     * @return
     * @throws java.rmi.NotBoundException
     * @throws java.net.MalformedURLException
     * @throws java.rmi.RemoteException
     */
    public ArrayList<Vertice> pegarPossiveisCaminhos(String inicio, String fim) throws NotBoundException, MalformedURLException, RemoteException {
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
     * Checa se algum dos três servidores tem interesse em fazer a compra no
     * momento
     *
     * @return
     */
    public boolean alguemQuer() {
        return semaforo.qualquerSoliciatacao();
    }

    /**
     * Configura a permissão daquela campanhia que é passada como parâmetro.
     *
     * @param companhia
     */
    public void setPermissao(String companhia) {
        semaforo.setPermissao(companhia);
    }

    /**
     * Função que faz a remoção da permissão da companhia passada
     *
     * @param companhia
     */
    public void removePermissao(String companhia) {
        semaforo.removerPermissaoCompanhia(companhia);
    }

    /**
     * Função que compra os caminhos e utiliza da concorrência entre servidores
     *
     * @param caminhos
     * @return
     * @throws NotBoundException
     * @throws MalformedURLException
     * @throws RemoteException
     */
    public boolean comprarCaminhos(List<String> caminhos) throws NotBoundException, MalformedURLException, RemoteException {
        if (!semaforo.qualquerSoliciatacao()) {

            InterfServerToServer lookupMethod = null;
            InterfServerToServer lookupMethod2 = null;
            semaforo.setPermissao(companhiacontrollerServer.getInitServerNome());
            List<Aresta> arestas = null;
            List<String> realizarCompra = null;

            try {
                lookupMethod = companhiacontrollerServer.getserverUmLookupMethod();// Os caminhos do servidor Um         
            } catch (NullPointerException e) {
            }
            try {
                lookupMethod2 = companhiacontrollerServer.getserverDoisLookupMethod();// Os caminhos do servidor Dois
            } catch (NullPointerException e) {
            }            try {
//                            arestas = grafo.getVertices(lookupMethod, lookupMethod2);
                            realizarCompra = emOutroServidorComprar.realizarCompraNosOutrosServidores(
                                    companhiacontrollerServer.getServerUm(), companhiacontrollerServer.getServerDois(), arestas, companhiacontrollerServer.getInitServerNome());
                            return comprarCaminhos(realizarCompra, companhiacontrollerServer.getInitServerNome());
                        } catch (NullPointerException e) {
                            return false;
                        } 
            finally {
                semaforo.removerPermissaoCompanhia(companhiacontrollerServer.getInitServerNome());
            }

        }
        return false;
    }

    /**
     * Função que compra os caminhos passando a a identificação do aeroporto e a
     * companhia
     *
     * @param aeroportos
     * @param companhia
     * @return
     */
    public boolean comprarCaminhos(List<String> aeroportos, String companhia) {
        ArrayList<ArrayList<Vertice>> arestasId = null;
        if (semaforo.getPermissao().equalsIgnoreCase(companhia)) {
//            arestasId = grafo.grafo.indentificarCaminhos(aeroportos);
//            if (!arestasByIds.stream().noneMatch(arestasId -> (!arestasId.get(0).getBilhete().comprarPassagem()))) {
//                return false;
//            }
//            return true;
        }
        return false;
    }
}
