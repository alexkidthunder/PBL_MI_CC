/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metodoRemoto;

import java.rmi.NotBoundException;
import java.rmi.ConnectException;
import java.rmi.RemoteException;
import java.rmi.Naming;
import java.net.MalformedURLException;

/**
 * Classe para acessar outro servidor como cliente
 *
 * @authors Alexandre & Bianca
 */
public class ClienteAcessoServer {

    private final String host;
    private final String nome;
    private final int port;

    /**
     * Construtor da classe ClienteAcessoServer
     *
     * @param host Endereço
     * @param nome Nome da Companhia
     * @param port Porta utilizada
     */
    public ClienteAcessoServer(String host, String nome, int port) {
        this.host = host;
        this.nome = nome;
        this.port = port;
    }

    /**
     * Método LookUp utilizado para pagar as informações
     *
     * @return
     * @throws MalformedURLException
     * @throws NotBoundException
     * @throws RemoteException
     */
    public InterfServerToServer lookupMethod() throws MalformedURLException, NotBoundException, RemoteException {
        try {
            return (InterfServerToServer) Naming.lookup("rmi://" + host + ":" + port + "/ServiceServer" + nome);
        } catch (ConnectException e) {
            System.err.println("Não foi possível fazer este procedimento no momento ou não teve a devida configuração"
                    + " verifique os parâmetros.");
        }
        return null;
    }

    /**
     * Pega o nome da Companhia
     *
     * @return
     */
    public String getNome() {
        return nome;
    }

}
