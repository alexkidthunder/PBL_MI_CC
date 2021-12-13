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
import metodoRemoto.ClienteAcessoServer;
import metodoRemoto.InterfServerToServer;
import model.Caminho;
import util.configInicial;
import static util.configInicial.Servidores.AZUL;
import static util.configInicial.Servidores.GOL;
import static util.configInicial.Servidores.TAM;

/**
 * Classe Server do sistema
 *
 * @authors Alexandre & Bianca
 */
public class CompanhiaControllerServer {

    private ClienteAcessoServer serverUm;
    private ClienteAcessoServer serverDois;
    private configInicial.Servidores initServer;

    /**
     * Construtor da classe
     */
    public CompanhiaControllerServer() {
    }

    /**
     * Informações do servidor Um
     *
     * @return
     */
    public ClienteAcessoServer getServerUm() {
        return serverUm;
    }

    /**
     * Informações do servidor Dois
     *
     * @return
     */
    public ClienteAcessoServer getServerDois() {
        return serverDois;
    }

    /**
     * Função de pegar o endereço do servidor
     *
     * @return
     */
    public String getInitServerHost() {
        return initServer.getIphost();
    }

    /**
     * Função de pegar o nome da companhia do servidor
     *
     * @return
     */
    public String getInitServerNome() {
        return initServer.getNomeCompanhia();
    }

    /**
     * Função de pegar a porta do servidor
     *
     * @return
     */
    public int getInitServerPorta() {
        return initServer.getPorta();
    }

    /**
     * Pega o método Lookup do servidor Um
     *
     * @return
     * @throws NotBoundException
     * @throws MalformedURLException
     * @throws RemoteException
     */
    public InterfServerToServer getserverUmLookupMethod() throws NotBoundException, MalformedURLException, RemoteException {
        return serverUm.lookupMethod();
    }

    /**
     * Pega o método Lookup do servidor Dois
     *
     * @return
     * @throws NotBoundException
     * @throws MalformedURLException
     * @throws RemoteException
     */
    public InterfServerToServer getserverDoisLookupMethod() throws NotBoundException, MalformedURLException, RemoteException {
        return serverDois.lookupMethod();
    }

    /**
     * Da inicio aos servidores com os parâmetros do nome da companhia, onde um
     * servidor sabe dos outro, mas conhece as suas rotas ainda
     *
     * @param server
     * @return A lista das rotas de cada servidor específico
     */
    public List<Caminho> PegarInformacoesServidores(String server) {
        switch (server) {
            case "AZUL":
                initServer = configInicial.Servidores.AZUL;
                serverUm = new ClienteAcessoServer(GOL.getIphost(), GOL.getNomeCompanhia(), GOL.getPorta());
                serverDois = new ClienteAcessoServer(TAM.getIphost(), TAM.getNomeCompanhia(), TAM.getPorta());

                return configInicial.getCaminhosAzul();

            case "GOL":
                initServer = configInicial.Servidores.GOL;
                serverUm = new ClienteAcessoServer(AZUL.getIphost(), AZUL.getNomeCompanhia(), AZUL.getPorta());
                serverDois = new ClienteAcessoServer(TAM.getIphost(), TAM.getNomeCompanhia(), TAM.getPorta());

                return configInicial.getCaminhosGol();

            case "TAM":
                initServer = configInicial.Servidores.TAM;
                serverUm = new ClienteAcessoServer(GOL.getIphost(), GOL.getNomeCompanhia(), GOL.getPorta());
                serverDois = new ClienteAcessoServer(AZUL.getIphost(), AZUL.getNomeCompanhia(), AZUL.getPorta());

                return configInicial.getCaminhosTam();

            default:
                return null;
        }
    }

}
