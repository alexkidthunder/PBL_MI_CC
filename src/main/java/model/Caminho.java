/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.List;
import util.Aresta;

/**
 *
 * @author ribei
 */
public class Caminho {

    private List<List<Aresta>> rotas;

    public Caminho(List<List<Aresta>> rotas) {
        this.rotas = rotas;
    }

    public List<List<Aresta>> getRotas() {
        return rotas;
    }

}
