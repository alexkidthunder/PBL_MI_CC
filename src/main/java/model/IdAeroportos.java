/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.Objects;

/**
 * Classe IdAeroportos que guarda as informações
 *
 * @authors Alexandre & Bianca
 */
public class IdAeroportos implements Serializable {

    private static final long serialVersionUID = 10L;
    private int identificador;
    private String codigoIATA;
    private String nomeAeroporto;
    private String Estado;

    public IdAeroportos(int identificador, String codigoIATA, String nomeAeroporto, String Estado) {
        this.identificador = identificador;
        this.codigoIATA = codigoIATA;
        this.nomeAeroporto = nomeAeroporto;
        this.Estado = Estado;
    }

    public int getIdentificador() {
        return identificador;
    }

    public void setIdentificador(int identificador) {
        this.identificador = identificador;
    }

    public String getCodigoIATA() {
        return codigoIATA;
    }

    public void setCodigoIATA(String codigoIATA) {
        this.codigoIATA = codigoIATA;
    }

    public String getNomeAeroporto() {
        return nomeAeroporto;
    }

    public void setNomeAeroporto(String nomeAeroporto) {
        this.nomeAeroporto = nomeAeroporto;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String Estado) {
        this.Estado = Estado;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        return hash;
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
        final IdAeroportos other = (IdAeroportos) obj;
        if (this.identificador != other.identificador) {
            return false;
        }
        if (!Objects.equals(this.codigoIATA, other.codigoIATA)) {
            return false;
        }
        if (!Objects.equals(this.nomeAeroporto, other.nomeAeroporto)) {
            return false;
        }
        if (!Objects.equals(this.Estado, other.Estado)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "nomeAeroporto= " + nomeAeroporto + ", Estado= " + Estado;
    }

}
