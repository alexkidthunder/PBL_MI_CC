/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import model.Bilhete;

/**
 *
 * @author ribei
 */
public class Aresta {
    private float peso;
    private Vertice v1;
    private Vertice v2;
    private boolean visitado = false;

    /**
     * Método construtor, da classe Aresta.
     * @param peso
     * @param origem
     * @param destino
     */
    public Aresta(float peso, Vertice origem, Vertice destino) {
        this.setPeso(peso);
        this.setV1(origem);
        this.setV2(destino);
    }

    /**
     * Método getPeso, da classe Aresta.
     * @return int
     */
    public float getPeso() {
        return peso;
    }

    /**
     * Método setPeso, da classe Aresta.
     * @param peso
     */
    public void setPeso(float peso) {
        this.peso = peso;
    }

    /**
     * Método getV1, da classe Aresta.
     * @return Vertice
     */
    public Vertice getV1() {
        return v1;
    }

    /**
     * Método setV1, da classe Aresta.
     * @param v1
     */
    public void setV1(Vertice v1) {
        this.v1 = v1;
    }

    /**
     * Método getV2, da classe Aresta.
     * @return Vertice
     */
    public Vertice getV2() {
        return v2;
    }

    /**
     * Método setV2, da classe Aresta.
     * @param v2
     */
    public void setV2(Vertice v2) {
        this.v2 = v2;
    }

    /**
     * Método isVisitado, da classe Aresta.
     * @return boolean 
     */
    public boolean isVisitado() {
        return visitado;
    }

    /**
     * Método setVisitado, da classe Aresta.
     * @param visitado
     */
    public void setVisitado(boolean visitado) {
        this.visitado = visitado;
    }

    /**
     * Método toString, da classe Aresta.
     * @return String
     */
    @Override
    public String toString() {
        String s = " ";
        s+= this.v1.getNome()+ this.v2.getNome();
        return s;
    }
   
}
