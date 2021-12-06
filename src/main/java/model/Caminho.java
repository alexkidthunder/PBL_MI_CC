/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;

/**
 * Classe Caminho que guarda as informações dele de uma companhia
 *
 * @authors Alexandre & Bianca
 */
public class Caminho implements Serializable {

    private final String companhiAerea;
    private final float precoBilhete;
    private final String destino;
    private final String origem;

    public Caminho(String companhiAerea, float precoBilhete, String destino, String origem) {
        this.companhiAerea = companhiAerea;
        this.precoBilhete = precoBilhete;
        this.destino = destino;
        this.origem = origem;
    }

    public String getCompanhiAerea() {
        return companhiAerea;
    }

    public float getPrecoBilhete() {
        return precoBilhete;
    }

    public String getDestino() {
        return destino;
    }

    public String getOrigem() {
        return origem;
    }

}
