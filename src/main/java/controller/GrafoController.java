/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import model.IdAeroportos;
import util.Aresta;
import util.Grafo;
import util.Vertice;
import util.configInicial;

/**
 *
 * @authors Alexandre & Bianca
 */
public class GrafoController {

    public Grafo grafo; 
    private configInicial.aeroportosEnumeracao aeroportos;

    /**
     *
     */
    public GrafoController(){
        this.grafo = new Grafo();
    }
    
    /**
     *
     * @param nome
     * @param aeroporto
     */
    public void addVertice(String nome, IdAeroportos aeroporto){
        this.grafo.addVertice(nome,aeroporto);
        
    }
    
    /**
     *
     * @param peso
     * @param v1
     * @param v2
     */
    public void addAresta(float peso, String v1, String v2){
        this.grafo.addAresta( peso, v1, v2);
        
    }
    
    /**
     *
     * @param ve1
     * @param ve2
     * @return ArrayList
     */
    public ArrayList<Vertice> encontrarMenorCaminhoDijkstra(String ve1,String ve2){
        return this.grafo.encontrarMenorCaminhoDijkstra(ve1, ve2);
    }
    
    /**
     *
     * @param nome
     */
    public void remover(String nome){
        this.grafo.remover(nome);
    }
    
    /**
     *
     * @param v1
     * @return ArrayList
     */
    public ArrayList<ArrayList<Vertice>> indentificarCaminhos(String v1){
        return this.grafo.indentificarCaminhos(v1);
    }
    
    /**
     *
     * @param fileNameVertice
     * @param fileNameAresta
     */
    public void readFile(String fileNameVertice, String fileNameAresta){
//        this.readFileVertice(fileNameVertice);
        this.readFileAresta(fileNameAresta);
    }
    
    /**
     *
     * @param fileNameVertice
     * @param fileNameAresta
     */
    public void saveFile(String fileNameVertice, String fileNameAresta){
        this.saveFileVertice(fileNameVertice);
        this.saveFileAresta(fileNameAresta);
    }
    
//    /**
//     *
//     * @param fileName
//     */
//    public void readFileVertice(String fileName){   
//        try{
//            FileInputStream file = new FileInputStream(fileName+".txt");
//            InputStreamReader input = new InputStreamReader(file, "ISO-8859-1");
//            BufferedReader br = new BufferedReader(input);
//            
//            String linha;
//            String[] linhaCortada;
//
//            do{
//                linha = br.readLine();
//                if (linha != null){
//                    linhaCortada = linha.split(";");
//                      linhaCortada = linha.split(";|;\\s");//Lidar com ; com ou sem espaço depois
//                    if (!"Sigla".equals(linhaCortada[0])){
//                            String aux = linhaCortada[1];
//                            IdAeroportos aeroporto = new IdAeroportos();
//                            this.addVertice(linhaCortada[0], aeroporto);
//                    }
//                }
//                
//            }while(linha != null);
//            br.close();
//            input.close();
//            file.close();
//        
//        }catch (Exception e){
//            System.out.println("*Erro na leitura");
//        }    
//    }
    
    /**
     *
     * @param fileName
     */
    public void readFileAresta(String fileName){
        try{
            FileInputStream file = new FileInputStream(fileName+".txt");
            InputStreamReader input = new InputStreamReader(file, "ISO-8859-1");
            BufferedReader br = new BufferedReader(input);

            String linha;
            String[] linhaCortada;
            
            do{
                linha = br.readLine();
                if (linha != null){
                    linhaCortada = linha.split(";|;\\s");//Lidar com ; com ou sem espaço depois
                    //linhaCortada = linha.split(";");
                    if (!"vertice1".equals(linhaCortada[0])){
                        String aux1 = linhaCortada[2];                     
                        int peso = Integer.parseInt(linhaCortada[2]);
                        this.addAresta(peso,linhaCortada[0], linhaCortada[1]);
                    }
                }
            }while(linha != null);
            br.close();
            input.close();
            file.close();
        
        }catch (Exception e){
            System.out.println("*Erro na leitura");
        }  
    }
    
    /**
     *
     * @param fileName
     */
    public void saveFileVertice(String fileName){
        try{
            File f2 = new File("vertice.txt");
            f2.delete();
            FileOutputStream file = new FileOutputStream(fileName+".txt");
            PrintWriter pw  = new PrintWriter(file);   
            //Coloca a linha padrão do arquivo
            pw.println("Sigla;X;Y;Terminal");
            for(int i =0;i<grafo.getVertices().size(); i++ ){
                Vertice aux = grafo.getVertices().get(i);
                pw.println(aux.getNome()+";"+aux.getX()+";"+aux.getY());
            }
            pw.close();
            file.close();
        } catch (Exception e){
            System.out.println("Erro ao gravar");
        }
    }
    
    /**
     *
     * @param fileName
     */
    public void saveFileAresta(String fileName){
        try{
            File f2 = new File("aresta.txt");
            f2.delete();
            FileOutputStream file = new FileOutputStream(fileName+".txt");
            PrintWriter pw  = new PrintWriter(file);   
            //Coloca a linha padrão do arquivo
            pw.println("vertice1;vertice2;peso");
            for(int i =0;i<grafo.getArestas().size(); i++ ){
                Aresta aux = grafo.getArestas().get(i);
                pw.println(aux.getV1()+";"+aux.getV2()+";"+aux.getPeso());
            }
            pw.close();
            file.close();
        } catch (Exception e){
            System.out.println("Erro ao gravar");
        }
    }
   
    /**
     *
     * @param args
     */
    public static void main(String args[]) {
        GrafoController grafo = new GrafoController();
        IdAeroportos aeroporto = new IdAeroportos(2453, "BB", "Aeroporto B", "Fortaleza");
        IdAeroportos aeroporto2 = new IdAeroportos(2073, "AA", "Aeroporto A", "Bahia");
        grafo.addVertice("Salvador", aeroporto2 );
        grafo.addVertice("Recife", aeroporto);
        grafo.addVertice("Alagoas", aeroporto);
        grafo.addAresta(200, "Salvador", "Recife");
        grafo.addAresta(100, "Recife", "Alagoas");
        grafo.addAresta(500, "Salvador", "Alagoas");
        System.out.println(grafo.indentificarCaminhos("Salvador"));
        System.out.println(grafo.encontrarMenorCaminhoDijkstra("Salvador", "Alagoas").toString());
        System.out.println(grafo.encontrarMenorCaminhoDijkstra("Salvador", "Alagoas").get(0).getDistancia());
        System.out.println(grafo.encontrarMenorCaminhoDijkstra("Salvador", "Alagoas").get(1).getDistancia());
        System.out.println(grafo.encontrarMenorCaminhoDijkstra("Salvador", "Alagoas").get(2).getDistancia());
        System.out.println(grafo.encontrarMenorCaminhoDijkstra("Salvador", "Alagoas").size());
    }
}
