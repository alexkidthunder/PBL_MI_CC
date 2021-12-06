/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 * Classe de concorrência que tem como objetivo assegurar a particularidade do
 * acesso
 *
 * @authors Alexandre & Bianca
 */
public class Concorrencia {

    private String permissao;
    private boolean solicitacaoGol;
    private boolean solicitacaoTam;
    private boolean solicitacaoAzul;

    public Concorrencia() {
        permissao = "Não tem permissão";
        solicitacaoGol = false;
        solicitacaoTam = false;
        solicitacaoAzul = false;
    }

    public String getPermissao() {
        return permissao;
    }

    public void setPermissao(String permissao) {
        if (permissao.equalsIgnoreCase("Azul")) {
            solicitacaoAzul = true;
        } else if (permissao.equalsIgnoreCase("GOL")) {
            solicitacaoGol = true;
        } else if (permissao.equalsIgnoreCase("Latam")) {
            solicitacaoTam = true;
        }
        this.permissao = permissao;
    }

    public void removerPermissaoCompanhia(String permissao) {
        if (permissao.equalsIgnoreCase("Azul")) {
            solicitacaoAzul = false;
        } else if (permissao.equalsIgnoreCase("GOL")) {
            solicitacaoGol = false;
        } else if (permissao.equalsIgnoreCase("Latam")) {
            solicitacaoTam = false;
        }
        permissao = "Não tem permissão";
    }

    public boolean isSolicitacaoGol() {
        return solicitacaoGol;
    }

    public void setSolicitacaoGol(boolean solicitacaoGol) {
        this.solicitacaoGol = solicitacaoGol;
    }

    public boolean isSolicitacaoLatam() {
        return solicitacaoTam;
    }

    public void setSolicitacaoLatam(boolean solicitacaoLatam) {
        this.solicitacaoTam = solicitacaoLatam;
    }

    public boolean isSolicitacaoAzul() {
        return solicitacaoAzul;
    }

    public void setSolicitacaoAzul(boolean solicitacaoAzul) {
        this.solicitacaoAzul = solicitacaoAzul;
    }

    public boolean qualquerSoliciatacao() {
        return solicitacaoGol || solicitacaoTam || solicitacaoAzul;
    }
}
