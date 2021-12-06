/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.CompanhiaControllerServer;
import java.util.List;
import java.util.Scanner;
import model.Caminho;

/**
 *
 * @authors Alexandre & Bianca
 */
public class main {

    public static String init() {
        System.out.println("********************Seja bem vindo ao sistema********************");
        System.out.println("\n Digite a companhia para iniciar o servidor \n");
        System.out.println(" AZUL para o servidor AZUL ");
        System.out.println(" GOL para o servidor GOL ");
        System.out.println(" TAM para o servidor TAM ");
        
        Scanner in = new Scanner(System.in);    
        return in.next();
    }

    public static void main(String[] args) {
        String server = init();
    }
}
