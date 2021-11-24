/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @authors Alexandre & Bianca
 */
public class Bilhete {

    private String companhia;
    private double precoBilhete;
    private int totalVagas;

    public Bilhete(String companhia, double precoBilhete) {
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

}
