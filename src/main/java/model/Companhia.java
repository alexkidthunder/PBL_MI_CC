/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import util.Vertice;

/**
 *
 * @authors Alexandre & Bianca
 */
/*public class Companhia {

    private int id;
    private String nome;
    private Map<Vertice, List<Vertice>> adjVertices;

    public Companhia(int id, String nome, Map<Vertice, List<Vertice>> adjVertices) {
        this.id = id;
        this.nome = nome;
        this.adjVertices = adjVertices;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Map<Vertice, List<Vertice>> getAdjVertices() {
        return adjVertices;
    }

    public void setAdjVertices(Map<Vertice, List<Vertice>> adjVertices) {
        this.adjVertices = adjVertices;
    }

    void adicionarVertice(String label) {
        adjVertices.putIfAbsent(new Vertice(label), new ArrayList<>());
    }

    void removerVertice(String label) {
        Vertice v = new Vertice(label);
        adjVertices.values().stream().forEach(e -> e.remove(v));
        adjVertices.remove(new Vertice(label));
    }

    void adicionarAresta(String label1, String label2) {
        Vertice v1 = new Vertice(label1);
        Vertice v2 = new Vertice(label2);
        adjVertices.get(v1).add(v2);
        adjVertices.get(v2).add(v1);
    }

    void removerAresta(String label1, String label2) {
        Vertice v1 = new Vertice(label1);
        Vertice v2 = new Vertice(label2);
        List<Vertice> eV1 = adjVertices.get(v1);
        List<Vertice> eV2 = adjVertices.get(v2);
        if (eV1 != null) {
            eV1.remove(v2);
        }
        if (eV2 != null) {
            eV2.remove(v1);
        }
    }
}*/
