package model;

/**
 * Classe Passageiro que guarda as informações do nome e CPF
 * @authors Alexandre & Bianca
 */
public class Passageiro {
    private String nome;
    private String cpf;


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
}