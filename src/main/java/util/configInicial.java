/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.util.ArrayList;
import java.util.List;
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

        /**
         * Retorna uma lista com as informações dos aeroportos
         *
         * @return
         */
        public static List<IdAeroportos> getAeroportos() {
            List<IdAeroportos> list = new ArrayList<>();
            aeroportosEnumeracao[] aeroportos = aeroportosEnumeracao.values();

            for (aeroportosEnumeracao aeroEnum : aeroportos) {
                list.add(new IdAeroportos(aeroEnum.getId(), aeroEnum.getCodigoIATA(),
                        aeroEnum.getNomeAeroporto(), aeroEnum.getEstado()));
            }
            return list;
        }

    }

    /**
     * Lista de valores pré-definidos dos Servidores
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
         * @return
         */
        public int getId() {
            return id;
        }

        /**
         * Pega o host/ip da Companhia
         * @return
         */
        public String getIphost() {
            return iphost;
        }

        /**
         * Pega o nome da Companhia
         * @return
         */
        public String getNomeCompanhia() {
            return nomeCompanhia;
        }

        /**
         * Pega a porta padrão da Companhia
         * @return
         */
        public int getPorta() {
            return porta;
        }
    }
}
