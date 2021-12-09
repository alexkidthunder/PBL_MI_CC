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
import model.Concorrencia;
import util.Aresta;

/**
 * Classe para realizar Transações entre companhias
 *
 * @authors Alexandre & Bianca
 */
public class TransactionsController {

    public List<String> realizarCompraNosOutrosServidores(ClienteAcessoServer serverUm, ClienteAcessoServer serverDois,
            List<Aresta> arestas, String companhia) throws MalformedURLException, NotBoundException, RemoteException {

        //Listas para conter as identificações dos caminhos em cada servidor
        List<String> comPrincipal = new ArrayList<>();
        List<String> compUm = new ArrayList<>();
        List<String> compDois = new ArrayList<>();

        //Percorrer as arestas e checar quem disponibiliza o bilhete e com isso colocar o id da aresta na lista
        arestas.forEach((aresta) -> {
            if (companhia.equals(serverUm.getNome())) {
                compUm.add(aresta.getId());
            } else if (companhia.equals(serverDois.getNome())) {
                compDois.add(aresta.getId());
            } else {
                comPrincipal.add(aresta.getId());
            }
        });

        // Se tiver algum Id na lista, um dos servidores tem permissão para realizar a compra
        if (compUm.size() > 0) {
            InterfServerToServer lookupMethod = serverUm.lookupMethod();
            if (!lookupMethod.solicitacaoComprarCaminho(companhia)) {
                return null;
            }
        }

        // Realiza a compra do caminho no servidor Um se apresentar Id
        if (compUm.size() > 0) {
            InterfServerToServer lookupMethod = serverUm.lookupMethod();
            if (!lookupMethod.comprarCaminhoCompanhia(compUm, companhia)) {
                return null;
            }
        }

        // Se tiver algum Id na lista, o outro servidores tem permissão para realizar a compra
        if (compDois.size() > 0) {
            InterfServerToServer lookupMethod = serverDois.lookupMethod();
            if (!lookupMethod.solicitacaoComprarCaminho(companhia)) {
                return null;
            }
        }

        // Realiza a compra do caminho no servidor Dois se apresentar Id
        if (compDois.size() > 0) {
            InterfServerToServer lookupMethod = serverDois.lookupMethod();
            if (!lookupMethod.comprarCaminhoCompanhia(compDois, companhia)) {
                return null;
            }
        }
        // Retorna a lista do servidor contendo os Ids a ser comprados
        return comPrincipal;
    }
}
