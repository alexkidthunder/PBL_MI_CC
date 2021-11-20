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

    private String peso;
    private Vertice origem;
    private Vertice destino;
    private List<Bilhete> Bilhetes;

    public Aresta(String peso, Vertice origem, Vertice destino, List<Bilhete> Bilhetes) {
        this.peso = peso;
        this.origem = origem;
        this.destino = destino;
        this.Bilhetes = new ArrayList<>();
    }

    public String getPeso() {
        return peso;
    }

    public void setPeso(String peso) {
        this.peso = peso;
    }

    public Vertice getOrigem() {
        return origem;
    }

    public void setOrigem(Vertice origem) {
        this.origem = origem;
    }

    public Vertice getDestino() {
        return destino;
    }

    public void setDestino(Vertice destino) {
        this.destino = destino;
    }

    public List<Bilhete> getBilhetes() {
        return Bilhetes;
    }

    public void setBilhetes(List<Bilhete> Bilhetes) {
        this.Bilhetes = Bilhetes;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Aresta other = (Aresta) obj;
        if (!Objects.equals(this.peso, other.peso)) {
            return false;
        }
        if (!Objects.equals(this.origem, other.origem)) {
            return false;
        }
        if (!Objects.equals(this.destino, other.destino)) {
            return false;
        }
        if (!Objects.equals(this.Bilhetes, other.Bilhetes)) {
            return false;
        }
        return true;
    }

}
