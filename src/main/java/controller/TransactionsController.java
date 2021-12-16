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
import metodoRemoto.ClienteAcessoServer;
import metodoRemoto.InterfServerToServer;
import util.Aresta;

/**
 * Classe para realizar Transações entre companhias
 *
 * @authors Alexandre & Bianca
 */
public class TransactionsController {

    /**
     * Função de realizar compra em outro servidor.
     *
     * @param serverUm
     * @param serverDois
     * @param arestas
     * @param nomeCompanhia
     * @return
     * @throws MalformedURLException
     * @throws NotBoundException
     * @throws RemoteException
     */
    public List<String> realizarCompraNosOutrosServidores(ClienteAcessoServer serverUm, ClienteAcessoServer serverDois,
            List<Aresta> arestas, String nomeCompanhia) throws MalformedURLException, NotBoundException, RemoteException {

        List<String> compraPrincipal = new ArrayList<>();
        List<String> compraUm = new ArrayList<>();
        List<String> compraDois = new ArrayList<>();

        arestas.forEach((aresta) -> { // Percorrer arestas
            if (nomeCompanhia.equals(serverUm.getNome())) { // Confere quem disponibiliza o bilhete no serverUm
                compraUm.add(aresta.getId());
            } else if (nomeCompanhia.equals(serverDois.getNome())) { // Confere quem disponibiliza o bilhete no serverDois
                compraDois.add(aresta.getId());
            } else {
                compraPrincipal.add(aresta.getId());// Adiciona o id na lista
            }
        });

        // Se tiver algum Id na lista no Um, checa se ele tem permissão
        if (compraUm.size() > 0) {
            InterfServerToServer lookupMethod = serverUm.lookupMethod();
            if (!lookupMethod.solicitacaoComprarCaminho(nomeCompanhia)) {
                return null;
            }
        }

        // Se ele tiver, realiza a compra do caminho no servidor Um se apresentar Id
        if (compraUm.size() > 0) {
            InterfServerToServer lookupMethod = serverUm.lookupMethod();
            if (!lookupMethod.comprarCaminhoCompanhia(compraUm, nomeCompanhia)) {
                return null;
            }
        }

        // Se tiver algum Id na lista no Dois, checa se ele tem permissão
        if (compraDois.size() > 0) {
            InterfServerToServer lookupMethod = serverDois.lookupMethod();
            if (!lookupMethod.solicitacaoComprarCaminho(nomeCompanhia)) {
                return null;
            }
        }

        // Se ele tiver, realiza a compra do caminho no servidor Dois
        if (compraDois.size() > 0) {
            InterfServerToServer lookupMethod = serverDois.lookupMethod();
            if (!lookupMethod.comprarCaminhoCompanhia(compraDois, nomeCompanhia)) {
                return null;
            }
        }
        // No final, faz o retorno da lista daqueles a serem comprados
        return compraPrincipal;
    }
}
