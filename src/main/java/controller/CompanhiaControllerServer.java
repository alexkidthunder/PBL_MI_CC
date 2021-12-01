/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.ArrayList;
import java.util.List;
import util.configInicial;

/**
 * Classe Server do sistema
 *
 * @authors Alexandre & Bianca
 */
public class CompanhiaControllerServer {

    private configInicial.Servidores myServer;

    public CompanhiaControllerServer() {
    }

    public List<String> PegarInformacoesServidores(String servidor) {
        switch (servidor) {
            case "AZUL":
                List<String> inforAzul = new ArrayList<>();
                inforAzul.add(configInicial.Servidores.AZUL.toString());
                return inforAzul;
            case "GOL":
                List<String> inforGOL = new ArrayList<>();
                inforGOL.add(configInicial.Servidores.GOL.toString());
                return inforGOL;
            default:
                List<String> inforTAM = new ArrayList<>();
                inforTAM.add(configInicial.Servidores.TAM.toString());
                return inforTAM;
        }
    }

}
