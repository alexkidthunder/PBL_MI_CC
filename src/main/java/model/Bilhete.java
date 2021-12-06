/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;

/**
 * Classe Bilhete que guarda as informações
 *
 * @authors Alexandre & Bianca
 */
public class Bilhete implements Serializable {

    private static final long serialVersionUID = 12L;
    private String companhia;
    private double precoBilhete;
    private int totalVagas;

    public Bilhete(String companhia, double precoBilhete) {
        this.totalVagas = 50;
        this.companhia = companhia;
        this.precoBilhete = precoBilhete;
    }

    public String getCompanhia() {
        return companhia;
    }

    public void setCompanhia(String companhia) {
        this.companhia = companhia;
    }

    public double getPrecoBilhete() {
        return precoBilhete;
    }

    public void setPrecoBilhete(double precoBilhete) {
        this.precoBilhete = precoBilhete;
    }

    public int getTotalVagas() {
        return totalVagas;
    }

    public void setTotalVagas(int totalVagas) {
        this.totalVagas = totalVagas;
    }

    public boolean comprarPassagem() {
        if (totalVagas > 0) {
            totalVagas = totalVagas - 1;
            return true;
        }
        return false;
    }
}
