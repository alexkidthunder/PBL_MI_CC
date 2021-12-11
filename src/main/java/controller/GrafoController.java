/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.ArrayList;
import java.util.List;
import model.Caminho;
import model.IdAeroportos;
import util.Aresta;
import util.Grafo;
import util.Vertice;
import util.configInicial;

/**
 *
 * @authors Alexandre & Bianca
 */
public class GrafoController {

    public Grafo grafo;
    public CompanhiaControllerServer servers;

    /**
     * Construtor da classe GrafoController
     */
    public GrafoController() {
        this.grafo = new Grafo();
    }

    /**
     * Função que adiciona um vertice no gráfico passando como parâmetros:
     *
     * @param nome
     * @param aeroporto
     */
    public void addVertice(String nome, IdAeroportos aeroporto) {
        this.grafo.addVertice(nome, aeroporto);

    }

    /**
     * Função que adiciona uma aresta, passando como parâmetros os:
     *
     * @param peso
     * @param v1
     * @param v2
     * @param company
     */
    public void addAresta(float peso, String v1, String v2, String company) {
        this.grafo.addAresta(peso, v1, v2, company);

    }

    /**
     * Função que encontrar o Menor Caminho usando Dijkstra
     *
     * @param ve1
     * @param ve2
     * @return ArrayList
     */
    public ArrayList<Vertice> encontrarMenorCaminhoDijkstra(String ve1, String ve2) {
        return this.grafo.encontrarMenorCaminhoDijkstra(ve1, ve2);
    }

    /**
     * Função que remove os vértices e arestas conectadas.
     *
     * @param nome
     */
    public void remover(String nome) {
        this.grafo.remover(nome);
    }

    /**
     * Função que identifica o menor caminho no grafo.
     *
     * @param v1
     * @return ArrayList
     */
    public ArrayList<ArrayList<Vertice>> indentificarCaminhos(String v1) {
        return this.grafo.indentificarCaminhos(v1);
    }

    /**
     * Função para popular o grafo.
     *
     * @param caminho
     * @return
     */
    public Grafo pegarInformações(List<Caminho> caminho) {
        //  GrafoController grafoC = new GrafoController();

        for (configInicial.aeroportosEnumeracao a : configInicial.aeroportosEnumeracao.values()) {
            this.addVertice(a.getEstado(),
                    new IdAeroportos(a.getId(), a.getCodigoIATA(), a.getNomeAeroporto(), a.getEstado()));
        }

        for (int i = 0; i < caminho.size(); i++) {
            this.addAresta(caminho.get(i).getPrecoBilhete(), caminho.get(i).getOrigem(),
                    caminho.get(i).getDestino(), caminho.get(i).getCompanhiAerea());
        }
//        System.out.println(grafoC.grafo.getArestas().size());
//        System.out.println(caminho.size());
//
        //System.out.println(grafo.indentificarCaminhos("Bahia"));
        //System.out.println(grafo.encontrarMenorCaminhoDijkstra("Bahia", "Ceará"));
        //grafo.getArestas().get(0).getBilhete().comprarPassagem();
        //System.out.println(grafo.getArestas().get(0).getBilhete().getTotalVagas());

        return grafo;
    }

    /**
     * Função que pega o Menore Caminhos
     *
     * @param ve1
     * @return
     */
    public ArrayList<ArrayList<String>> getMenoresCaminhosParaGUI(String ve1) {
        ArrayList<ArrayList<String>> caminhos = new ArrayList();
        ArrayList<ArrayList<Vertice>> caminhosVertices = this.grafo.indentificarCaminhos(ve1);
        for (int i = 0; i < caminhosVertices.size(); i++) {
            if (caminhosVertices.get(i) != null) {
                ArrayList<String> novoCaminho = new ArrayList();
                for (int j = 0; j < caminhosVertices.get(i).size(); j++) {
                    novoCaminho.add(caminhosVertices.get(i).get(j).getNome());
                }
                caminhos.add(novoCaminho);

            }
        }
        return caminhos;
    }

    /**
     * Função main da classe GrafoController, para testar
     *
     * @param args
     */
    public static void main(String args[]) {

        GrafoController grafo = new GrafoController();

        grafo.pegarInformações(configInicial.getCaminhosAzul());
        //System.out.println(grafo.pegarInformações().grafo.getVertices());
        //System.out.println(grafo.pegarInformações().grafo.getArestas());
        //System.out.println(grafo.indentificarCaminhos("Salvador"));
        //System.out.println(grafo.encontrarMenorCaminhoDijkstra("Salvador", "Alagoas").toString());
        //System.out.println(grafo.encontrarMenorCaminhoDijkstra("Salvador", "Alagoas").get(0).getDistancia());
        //System.out.println(grafo.encontrarMenorCaminhoDijkstra("Salvador", "Alagoas").get(1).getDistancia());
        //System.out.println(grafo.encontrarMenorCaminhoDijkstra("Salvador", "Alagoas").get(2).getDistancia());
        //System.out.println(grafo.encontrarMenorCaminhoDijkstra("Salvador", "Alagoas").size());

        /* Pegar as informações de um servidor em específico "AZUL", "GOL",qualquer 
        outro valor pra "TAM" atravez de uma classe que pega as informações do Enum*/
        //CompanhiaControllerServer servidores = new CompanhiaControllerServer();
        //System.out.println(servidores.PegarInformacoesServidores("") + "\n");
        //Representação das informações da função de pegar os caminhos
        //System.out.println(configInicial.getCaminhosAzul().size());
        //System.out.println(configInicial.getCaminhosAzul().get(0).getCompanhiAerea());
        //System.out.println(configInicial.getCaminhosAzul().get(0).getDestino());
        //System.out.println(configInicial.getCaminhosAzul().get(0).getOrigem());
        //System.out.println(configInicial.getCaminhosAzul().get(0).getPrecoBilhete());
        // Pega as informações do servidor
        //System.out.println(configInicial.Servidores.AZUL);
        //Pegar informações diretas do Enum na classe configInicial
        //System.out.println(Arrays.toString(configInicial.aeroportosEnumeracao.values()));
        //Pegar informações diretas do Enum especifica da classe configInicial
        //System.out.println(configInicial.aeroportosEnumeracao.ACRE.getNomeAeroporto());
    }
}
