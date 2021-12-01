/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.util.ArrayList;
import java.util.List;
import model.Caminho;
import model.IdAeroportos;

/**
 * Classe de configuração dos servidores, Aeroportos e os caminhos...
 *
 * @authors Alexandre & Bianca
 */
public class configInicial {

    /**
     * Lista de valores pré-definidos dos Aeroportos
     */
    public enum aeroportosEnumeracao {

        ACRE(1, "RBR", "Aeroporto de Rio Branco - Plácido de Castro", "Acre"),
        ALAGOAS(2, "MCZ", "Aeroporto Internacional de Maceió - Zumbi dos Palmares", "Alagoas"),
        AMAPA(3, "MCP", "Aeroporto Internacional de Macapá - Alberto Alcolumbre", "Amapá"),
        AMAZONAS(4, "MAO", "Aeroporto Internacional de Manaus - Eduardo Gomes", "Amazonas"),
        BAHIA(5, "SSA", "Aeroporto Internacional de Salvador - Dep. Luís Eduardo Magalhães", "Bahia"),
        CEARA(6, "FOR", "Aeroporto Internacional Pinto Martins", "Ceará"),
        DISTRITO_FEDERAL(7, "BSB", "Aeroporto Internacional Presidente Juscelino Kubitschek", "Distrito Federal"),
        ESPÍRITO_SANTO(8, "VIX", "Aeroporto Eurico de Aguiar Salles", "Espírito Santo"),
        GOIAS(9, "GYN", "Aeroporto de Goiânia - Santa Genoveva", "Goiás"),
        MARANHAO(10, "SLZ", "Aeroporto Internacional de São Luís - Marechal Cunha Machado", "Maranhão"),
        MATO_GROSSO(11, "CGB", "Aeroporto Internacional de Cuiabá - Marechal Rondon", "Mato Grosso"),
        MATO_GROSSO_DO_SUL(12, "CGR", "Aeroporto Internacional de Campo Grande", "Mato Grosso do Sul"),
        MINAS_GERAIS(13, "CNF", "Aeroporto Internacional de Belo Horizonte-Confins", "Minas Gerais"),
        PARA(14, "BEL", "Aeroporto Internacional de Belém", "Pará"),
        PARAIBA(15, "BSB", "Aeroporto Presidente João Suassuna", "Paraíba"),
        PARANA(16, "CWB", "Aeroporto Internacional Afonso Pena", "Paraná"),
        PERNAMBUCO(17, "REC", "Aeroporto Internacional dos Guararapes Gilberto Freyre", "Pernambuco"),
        PIAUI(18, "THE", "Aeroporto  de Teresina", "Piauí"),
        RIO_DE_JANEIRO(19, "SDU", "Aeroporto Santos Dumont", "Rio de Janeiro"),
        RIO_GRANDE_DO_NORTE(20, "NAT", "Aeroporto Internacional de Natal", "Rio Grande do Norte"),
        RIO_GRANDE_DO_SUL(21, "POA", "Aeroporto Internacional Salgado Filho", "Rio Grande do Sul"),
        RONDONIA(22, "PVH", "Aeroporto Internacional de Porto Velho - Gov. Jorge Teixeira de Oliveira", "Rondônia"),
        SANTA_CATARINA(23, "FLN", "Aeroporto Internacional de Florianópolis", "Santa Catarina"),
        SAO_PAULO(24, "GRU", "Aeroporto Internacional de Guarulhos", "São Paulo"),
        TOCANTINS(25, "PMW", "Aeroporto de Palmas - Brigadeiro Lysias Rodrigues", "Tocantins");

        private final int id;
        private final String codigoIATA;
        private final String nomeAeroporto;
        private final String estado;

        private aeroportosEnumeracao(int id, String codigoIATA, String nomeAeroporto, String estado) {
            this.id = id;
            this.codigoIATA = codigoIATA;
            this.nomeAeroporto = nomeAeroporto;
            this.estado = estado;
        }

        /**
         * Pega a identificação numerica do Aeroporto
         *
         * @return
         */
        public int getId() {
            return id;
        }

        /**
         * Pega o Código IATA do Aeroporto
         *
         * @return
         */
        public String getCodigoIATA() {
            return codigoIATA;
        }

        /**
         * Pega o nome do Aeroporto
         *
         * @return
         */
        public String getNomeAeroporto() {
            return nomeAeroporto;
        }

        /**
         * Pega o Estado do Aeroporto
         *
         * @return
         */
        public String getEstado() {
            return estado;
        }

        //@Override
        // public String toString() {
        //     return "aeroportosEnumeracao{" + "id= " + id + ", codigoIATA= " + codigoIATA + ", nomeAeroporto= " + nomeAeroporto + ", estado= " + estado + '}';
        // }
        /**
         * Retorna uma lista com as informações dos aeroportos
         *
         * @return listAeroportos
         */
        public static List<IdAeroportos> getAeroportos() {
            List<IdAeroportos> listAeroportos = new ArrayList<>();
            aeroportosEnumeracao[] aeroportos = aeroportosEnumeracao.values();

            for (aeroportosEnumeracao aeroEnum : aeroportos) {
                listAeroportos.add(new IdAeroportos(aeroEnum.getId(), aeroEnum.getCodigoIATA(),
                        aeroEnum.getNomeAeroporto(), aeroEnum.getEstado()));
            }
            return listAeroportos;
        }

    }

    /**
     * Lista de valores pré-definidos dos Servidores. O número-padrão da porta
     * para o rmi é 1099
     */
    public enum Servidores {
        AZUL(1, "192.168.102.1", "Azul", 1099),
        GOL(2, "192.168.102.3", "Gol", 1099),
        TAM(3, "192.168.102.5", "Tam", 1099);

        private final int id;
        private final String iphost;
        private final String nomeCompanhia;
        private final int porta;

        private Servidores(int id, String iphost, String nomeCompanhia, int porta) {
            this.id = id;
            this.iphost = iphost;
            this.nomeCompanhia = nomeCompanhia;
            this.porta = porta;
        }

        /**
         * Pega a identificação da Companhia
         *
         * @return id
         */
        public int getId() {
            return id;
        }

        /**
         * Pega o host/ip da Companhia
         *
         * @return iphost
         */
        public String getIphost() {
            return iphost;
        }

        /**
         * Pega o nome da Companhia
         *
         * @return nomeCompanhia
         */
        public String getNomeCompanhia() {
            return nomeCompanhia;
        }

        /**
         * Pega a porta padrão da Companhia
         *
         * @return porta
         */
        public int getPorta() {
            return porta;
        }

        @Override
        public String toString() {
            return "Servidores{" + "id= " + id + ", iphost= " + iphost + ", "
                    + "nomeCompanhia= " + nomeCompanhia + ", porta= " + porta + '}';
        }
    }

    /**
     * Lista de valores pré-definidos do Caminho da companhia AZUL
     */
    public enum CaminhoAZUL {
        caminhoA(5, 17, 180.00),
        caminhoB(17, 6, 168.00),
        caminhoC(6, 10, 429.00),
        caminhoD(13, 19, 345.00),
        caminhoE(9, 12, 1185.00),
        caminhoF(12, 24, 897.00);

        private final int origem;
        private final int destino;
        private final double preco;
        private final String NomeCompanhia = "Azul";

        private CaminhoAZUL(int origem, int destino, double preco) {
            this.origem = origem;
            this.destino = destino;
            this.preco = preco;
        }

        /**
         * Pega a origem do caminho
         *
         * @return origem
         */
        public int getOrigem() {
            return origem;
        }

        /**
         * Pega o destino do Caminho
         *
         * @return destino
         */
        public int getDestino() {
            return destino;
        }

        /**
         * Pega o preço do bilhete
         *
         * @return preco
         */
        public double getPreco() {
            return preco;
        }

        /**
         * Pega o nome fixo da Companhia
         *
         * @return NomeCompanhia
         */
        public String getNomeCompanhia() {
            return NomeCompanhia;
        }

    }

    /**
     * Pega as informações dos caminhos da companhia AZUL e adiciona numa lista.
     *
     * @return caminho
     */
    public static List<Caminho> getRotasAzul() {
        List<Caminho> caminho = new ArrayList<>();
        CaminhoAZUL[] trajeto = CaminhoAZUL.values();
        for (CaminhoAZUL caminhoAzul : trajeto) {
            caminho.add(new Caminho(caminhoAzul.getNomeCompanhia(), caminhoAzul.getPreco(),
                    caminhoAzul.getDestino(), caminhoAzul.getOrigem()));
        }
        return caminho;
    }

    /**
     * Lista de valores pré-definidos do Caminho da companhia TAM
     */
    public enum CaminhoTAM {
        caminhoA(21, 17, 2196.00),
        caminhoB(14, 6, 559.00),
        caminhoC(13, 5, 431.00),
        caminhoD(13, 9, 892.00),
        caminhoE(9, 11, 582.00),
        caminhoF(24, 16, 370.00);

        private final int origem;
        private final int destino;
        private final double preco;
        private final String NomeCompanhia = "TAM";

        private CaminhoTAM(int origem, int destino, double preco) {
            this.origem = origem;
            this.destino = destino;
            this.preco = preco;
        }

        /**
         * Pega a origem do caminho
         *
         * @return origem
         */
        public int getOrigem() {
            return origem;
        }

        /**
         * Pega o destino do Caminho
         *
         * @return destino
         */
        public int getDestino() {
            return destino;
        }

        /**
         * Pega o preço do bilhete
         *
         * @return preco
         */
        public double getPreco() {
            return preco;
        }

        /**
         * Pega o nome fixo da Companhia
         *
         * @return NomeCompanhia
         */
        public String getNomeCompanhia() {
            return NomeCompanhia;
        }

    }

    /**
     * Pega as informações dos caminhos da companhia TAM e adiciona numa lista.
     *
     * @return caminho
     */
    public static List<Caminho> getRotasTam() {
        List<Caminho> caminho = new ArrayList<>();
        CaminhoTAM[] trajeto = CaminhoTAM.values();
        for (CaminhoTAM caminhoTam : trajeto) {
            caminho.add(new Caminho(caminhoTam.getNomeCompanhia(), caminhoTam.getPreco(),
                    caminhoTam.getDestino(), caminhoTam.getOrigem()));
        }
        return caminho;
    }

    /**
     * Lista de valores pré-definidos do Caminho da companhia GOL
     */
    public enum CaminhoGOL {
        caminhoA(5, 20, 1178.00),
        caminhoB(20, 10, 1883.00),
        caminhoC(10, 14, 609.00),
        caminhoD(5, 13, 652.00),
        caminhoE(13, 24, 284.00),
        caminhoF(24, 19, 396.00),
        caminhoG(23, 16, 648.00),
        caminhoH(16, 12, 983.00);

        private final int origem;
        private final int destino;
        private final double preco;
        private final String NomeCompanhia = "GOL";

        private CaminhoGOL(int origem, int destino, double preco) {
            this.origem = origem;
            this.destino = destino;
            this.preco = preco;
        }

        /**
         * Pega a origem do caminho
         *
         * @return origem
         */
        public int getOrigem() {
            return origem;
        }

        /**
         * Pega o destino do Caminho
         *
         * @return destino
         */
        public int getDestino() {
            return destino;
        }

        /**
         * Pega o preço do bilhete
         *
         * @return preco
         */
        public double getPreco() {
            return preco;
        }

        /**
         * Pega o nome fixo da Companhia
         *
         * @return NomeCompanhia
         */
        public String getNomeCompanhia() {
            return NomeCompanhia;
        }
    }

    /**
     * Pega as informações dos caminhos da companhia GOL e adiciona numa lista.
     *
     * @return caminho
     */
    public static List<Caminho> getRotasGol() {
        List<Caminho> caminho = new ArrayList<>();
        CaminhoGOL[] trajeto = CaminhoGOL.values();
        for (CaminhoGOL caminhoGol : trajeto) {
            caminho.add(new Caminho(caminhoGol.getNomeCompanhia(), caminhoGol.getPreco(),
                    caminhoGol.getDestino(), caminhoGol.getOrigem()));
        }
        return caminho;
    }

}
