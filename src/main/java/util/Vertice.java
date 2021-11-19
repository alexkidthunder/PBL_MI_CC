/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import model.IdAeroportos;

/**
 *
 * @author ribei
 */
public class Vertice {

    private IdAeroportos aeroporto;
    private List<Aresta> arestas;

    public Vertice(IdAeroportos aeroporto) {
        this.aeroporto = aeroporto;
        this.arestas = new ArrayList<>();
    }

    public IdAeroportos getAeroporto() {
        return aeroporto;
    }

    public void setAeroporto(IdAeroportos aeroporto) {
        this.aeroporto = aeroporto;
    }

    public List<Aresta> getArestas() {
        return arestas;
    }

    public void setArestas(List<Aresta> arestas) {
        this.arestas = arestas;
    }

    public boolean existeAresta() {
        return arestas.size() > 0;
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
        final Vertice other = (Vertice) obj;
        if (!Objects.equals(this.aeroporto, other.aeroporto)) {
            return false;
        }
        if (!Objects.equals(this.arestas, other.arestas)) {
            return false;
        }
        return true;
    }

}
