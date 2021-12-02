/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.ArrayList;
import java.util.List;
import metodoRemoto.ClienteAcessoServer;
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

    private configInicial.Servidores initServer;
    private ClienteAcessoServer serverUm;
    private ClienteAcessoServer serverDois;

    /**
     * Construtor da classe
     */
    public CompanhiaControllerServer() {
    }

    public ClienteAcessoServer getServerUm() {
        return serverUm;
    }

    public ClienteAcessoServer getServerDois() {
        return serverDois;
    }

    public String getInitServerHost() {
        return initServer.getIphost();
    }

    public String getInitServerNome() {
        return initServer.getNomeCompanhia();
    }

    public int getInitServerPorta() {
        return initServer.getPorta();
    }

    /**
     * Da inicio aos servidores
     *
     * @param server
     * @return
     */
    public List<Caminho> PegarInformacoesServidores(String server) {
        switch (server) {
            case "AZUL":
                serverUm = new ClienteAcessoServer(GOL.getIphost(), GOL.getNomeCompanhia(), GOL.getPorta());
                serverDois = new ClienteAcessoServer(TAM.getIphost(), TAM.getNomeCompanhia(), TAM.getPorta());
                initServer = configInicial.Servidores.AZUL;
                return configInicial.getCaminhosAzul();

            case "GOL":
                serverUm = new ClienteAcessoServer(AZUL.getIphost(), AZUL.getNomeCompanhia(), AZUL.getPorta());
                serverDois = new ClienteAcessoServer(TAM.getIphost(), TAM.getNomeCompanhia(), TAM.getPorta());
                initServer = configInicial.Servidores.GOL;
                return configInicial.getCaminhosGol();

            default:
                serverUm = new ClienteAcessoServer(GOL.getIphost(), GOL.getNomeCompanhia(), GOL.getPorta());
                serverDois = new ClienteAcessoServer(AZUL.getIphost(), AZUL.getNomeCompanhia(), AZUL.getPorta());
                initServer = configInicial.Servidores.TAM;
                return configInicial.getCaminhosTam();
        }
    }

}
