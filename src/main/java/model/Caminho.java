/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;

/**
 *
 * @authors Alexandre & Bianca
 */
public class Caminho implements Serializable{

    private static final long serialVersionUID = 11L;
    private final String companhiAerea;
    private final double precoBilhete;
    private final int destino;
    private final int origem;

    public Caminho(String companhiAerea, double precoBilhete, int destino, int origem) {
        this.companhiAerea = companhiAerea;
        this.precoBilhete = precoBilhete;
        this.destino = destino;
        this.origem = origem;
    }

    public String getCompanhiAerea() {
        return companhiAerea;
    }

    public double getPrecoBilhete() {
        return precoBilhete;
    }

    public int getDestino() {
        return destino;
    }

    public int getOrigem() {
        return origem;
    }

}
