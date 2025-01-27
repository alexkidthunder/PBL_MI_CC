package view;

import controller.GrafoController;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import metodoRemoto.adder;
import metodoRemoto.adder;
import model.Caminho;
import util.Aresta;
import util.Vertice;

/**
 *
 * @author bianc
 */
public class ClientView extends javax.swing.JFrame {

    GrafoController cont = new GrafoController();
    DefaultListModel<String> model = new DefaultListModel<>();
    DefaultListModel<String> model2 = new DefaultListModel<>();
    DefaultListModel<String> model3 = new DefaultListModel<>();
    DefaultListModel<String> model4 = new DefaultListModel<>();
    List<Caminho> array = new ArrayList<Caminho>();
    ArrayList<Aresta> listaAresta = new ArrayList();
    float somaPreco = 0;

    /**
     * Creates new form ClientView
     */
    public ClientView() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel4 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jList2 = new javax.swing.JList<>();
        jScrollPane3 = new javax.swing.JScrollPane();
        jList3 = new javax.swing.JList<>();
        jLabel5 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        jList4 = new javax.swing.JList<>();
        jLabel6 = new javax.swing.JLabel();

        jLabel4.setText("jLabel4");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(600, 500));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton1.setText("Entrar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(53, 11, 230, -1));

        jLabel1.setText("Origem:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(21, 55, -1, -1));

        jLabel2.setText("Destino:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(21, 92, -1, -1));

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        getContentPane().add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(77, 52, 120, -1));
        getContentPane().add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(79, 89, 118, -1));

        jButton2.setText("Pesquisar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 60, 100, 31));

        jScrollPane1.setViewportView(jList1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 50, 166, 208));

        jLabel3.setText("OPÇÕES DE ROTAS");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 20, 122, 23));

        jScrollPane2.setViewportView(jList2);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(49, 139, 251, -1));

        jScrollPane3.setViewportView(jList3);

        getContentPane().add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 360, 293, 70));

        jLabel5.setText("ROTAS ADICIONADAS");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 340, 130, -1));

        jButton3.setText("Adicionar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 280, 150, -1));

        jButton4.setText("Nova passagem");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 390, 190, 39));

        jButton5.setText("Comprar");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 440, -1, -1));

        jScrollPane4.setViewportView(jList4);

        getContentPane().add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 310, 230, 60));

        jLabel6.setText("SUGESTÃO DE CAMINHO MAIS BARATO");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 280, 230, 30));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            // TODO add your handling code here:
            Registry reg = LocateRegistry.getRegistry("localhost", 4444);
            Registry re = LocateRegistry.getRegistry("localhost", 4445);
            Registry r = LocateRegistry.getRegistry("localhost", 4446);

            // Pegar informações da companhia AZUL
            adder ad = (adder) reg.lookup("Registro 1");
            array.addAll(ad.add("AZUL"));

//             Pegar informações da companhia GOL
            adder a2 = (adder) re.lookup("Registro 2");
            array.addAll(ad.add("GOL"));
            System.out.println("addition 1:" + a2.add("GOL").get(0).getPrecoBilhete());

//             Pegar informações da companhia TAM
            adder a3 = (adder) r.lookup("Registro 3");
            array.addAll(ad.add("TAM"));
            System.out.println("addition 1:" + a3.add("TAM").get(0).getPrecoBilhete());
            cont.pegarInformações(array);

            System.out.println(cont.grafo.getArestas());

            for (int i = 0; i < cont.grafo.getVertices().size(); i++) {
                model.addElement(cont.grafo.getVertices().get(i).getNome());
                jList1.setModel(model);
            }
        } catch (RemoteException ex) {
            Logger.getLogger(ClientView.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NotBoundException ex) {
            Logger.getLogger(ClientView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        String origem = jTextField1.getText();
        String destino = jTextField2.getText();
        ArrayList<Vertice> vertice = cont.encontrarMenorCaminhoDijkstra(origem, destino);

        if (origem.equals("Bahia") && destino.equals("Ceará")) {
            listaAresta.add(cont.grafo.acharAresta(cont.grafo.acharVertice("Bahia"), cont.grafo.acharVertice("Pernambuco")));
            listaAresta.get(0).getBilhete().comprarPassagem();
            listaAresta.add(cont.grafo.acharAresta(cont.grafo.acharVertice("Pernambuco"), cont.grafo.acharVertice("Ceará")));
            listaAresta.get(1).getBilhete().comprarPassagem();

        } else if (origem.equals("Bahia") && destino.equals("Rio Grande do Norte")) {
            listaAresta.add(cont.grafo.acharAresta(cont.grafo.acharVertice("Bahia"), cont.grafo.acharVertice("Rio Grande do Norte")));
            listaAresta.get(0).getBilhete().comprarPassagem();
            listaAresta.add(cont.grafo.acharAresta(cont.grafo.acharVertice("Bahia"), cont.grafo.acharVertice("Pernambuco")));
            listaAresta.get(1).getBilhete().comprarPassagem();
            listaAresta.add(cont.grafo.acharAresta(cont.grafo.acharVertice("Pernambuco"), cont.grafo.acharVertice("Rio Grande do Norte")));
            listaAresta.get(2).getBilhete().comprarPassagem();
        } else if (origem.equals("Bahia") && destino.equals("Maranhão")) {
            listaAresta.add(cont.grafo.acharAresta(cont.grafo.acharVertice("Bahia"), cont.grafo.acharVertice("Rio Grande do Norte")));
            listaAresta.get(0).getBilhete().comprarPassagem();
            listaAresta.add(cont.grafo.acharAresta(cont.grafo.acharVertice("Rio Grande do Norte"), cont.grafo.acharVertice("Maranhão")));
            listaAresta.get(1).getBilhete().comprarPassagem();
            listaAresta.add(cont.grafo.acharAresta(cont.grafo.acharVertice("Bahia"), cont.grafo.acharVertice("Pernambuco")));
            listaAresta.get(2).getBilhete().comprarPassagem();
            listaAresta.add(cont.grafo.acharAresta(cont.grafo.acharVertice("Pernambuco"), cont.grafo.acharVertice("Rio Grande do Norte")));
            listaAresta.get(3).getBilhete().comprarPassagem();
            listaAresta.add(cont.grafo.acharAresta(cont.grafo.acharVertice("Rio Grande do Norte"), cont.grafo.acharVertice("Maranhão")));
            listaAresta.get(4).getBilhete().comprarPassagem();
        } else if (origem.equals("Maranhão") && destino.equals("Pará")) {
            listaAresta.add(cont.grafo.acharAresta(cont.grafo.acharVertice("Maranhão"), cont.grafo.acharVertice("Pará")));
            listaAresta.get(0).getBilhete().comprarPassagem();
            listaAresta.add(cont.grafo.acharAresta(cont.grafo.acharVertice("Maranhão"), cont.grafo.acharVertice("Ceará")));
            listaAresta.get(1).getBilhete().comprarPassagem();
            listaAresta.add(cont.grafo.acharAresta(cont.grafo.acharVertice("Ceará"), cont.grafo.acharVertice("Pará")));
            listaAresta.get(2).getBilhete().comprarPassagem();
        } else if (origem.equals("São Paulo") && destino.equals("Mato Grosso do Sul")) {
            listaAresta.add(cont.grafo.acharAresta(cont.grafo.acharVertice("São Paulo"), cont.grafo.acharVertice("Mato Grosso do Sul")));
            listaAresta.get(0).getBilhete().comprarPassagem();
            listaAresta.add(cont.grafo.acharAresta(cont.grafo.acharVertice("São Paulo"), cont.grafo.acharVertice("Paraná")));
            listaAresta.get(1).getBilhete().comprarPassagem();
            listaAresta.add(cont.grafo.acharAresta(cont.grafo.acharVertice("Paraná"), cont.grafo.acharVertice("Mato Grosso do Sul")));
            listaAresta.get(2).getBilhete().comprarPassagem();
        } else if (origem.equals("Minas Gerais") && destino.equals("Santa Catarina")) {
            listaAresta.add(cont.grafo.acharAresta(cont.grafo.acharVertice("Minas Gerais"), cont.grafo.acharVertice("Rio de Janeiro")));
            listaAresta.get(0).getBilhete().comprarPassagem();
            listaAresta.add(cont.grafo.acharAresta(cont.grafo.acharVertice("Rio de Janeiro"), cont.grafo.acharVertice("São Paulo")));
            listaAresta.get(1).getBilhete().comprarPassagem();
            listaAresta.add(cont.grafo.acharAresta(cont.grafo.acharVertice("São Paulo"), cont.grafo.acharVertice("Paraná")));
            listaAresta.get(2).getBilhete().comprarPassagem();
            listaAresta.add(cont.grafo.acharAresta(cont.grafo.acharVertice("Paraná"), cont.grafo.acharVertice("Santa Catarina")));
            listaAresta.get(3).getBilhete().comprarPassagem();

            listaAresta.add(cont.grafo.acharAresta(cont.grafo.acharVertice("Minas Gerais"), cont.grafo.acharVertice("Rio de Janeiro")));
            listaAresta.get(4).getBilhete().comprarPassagem();
            listaAresta.add(cont.grafo.acharAresta(cont.grafo.acharVertice("Rio de Janeiro"), cont.grafo.acharVertice("São Paulo")));
            listaAresta.get(5).getBilhete().comprarPassagem();
            listaAresta.add(cont.grafo.acharAresta(cont.grafo.acharVertice("São Paulo"), cont.grafo.acharVertice("Mato Grosso do Sul")));
            listaAresta.get(6).getBilhete().comprarPassagem();
            listaAresta.add(cont.grafo.acharAresta(cont.grafo.acharVertice("Mato Grosso do Sul"), cont.grafo.acharVertice("Paraná")));
            listaAresta.get(7).getBilhete().comprarPassagem();
            listaAresta.add(cont.grafo.acharAresta(cont.grafo.acharVertice("Paraná"), cont.grafo.acharVertice("Santa Catarina")));
            listaAresta.get(8).getBilhete().comprarPassagem();
        } else if (origem.equals("Minas Gerais") && destino.equals("Mato Grosso")) {
            listaAresta.add(cont.grafo.acharAresta(cont.grafo.acharVertice("Minas Gerais"), cont.grafo.acharVertice("Goiás")));
            listaAresta.get(0).getBilhete().comprarPassagem();
            listaAresta.add(cont.grafo.acharAresta(cont.grafo.acharVertice("Goiás"), cont.grafo.acharVertice("Mato Grosso")));
            listaAresta.get(0).getBilhete().comprarPassagem();

        }

        for (int i = 0; i < listaAresta.size(); i++) {
            String aux = listaAresta.get(i).getV1().getNome() + " - " + listaAresta.get(i).getV2().getNome() + "  Preço: $" + listaAresta.get(i).getBilhete().getPrecoBilhete();
            somaPreco += listaAresta.get(i).getBilhete().getPrecoBilhete(); // Soma os valores das Arestas
            model2.addElement(aux);
            jList2.setModel(model2);
        }
        String aux = "";
        for (int i = 0; i < vertice.size(); i++) {
            aux = aux + " - " + vertice.get(i).getNome();
        }
        model4.addElement(aux);
        jList4.setModel(model4);

    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        Object sel = null;
        int[] selectedIx = this.jList2.getSelectedIndices();
        for (int i = 0; i < selectedIx.length; i++) {
            sel = jList2.getModel().getElementAt(selectedIx[i]);
        }
        String aux = sel.toString();
        model3.addElement(aux);
        jList3.setModel(model3);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:

        for (int j = 0; j < listaAresta.size(); j++) {
            model2.clear();
            jList2.setModel(model2);
            model3.clear();
            jList3.setModel(model3);
            model4.clear();
            jList4.setModel(model4);
        }
        jTextField1.setText("");
        jTextField2.setText("");
        listaAresta.clear();
        somaPreco = 0;
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        for (int j = 0; j < listaAresta.size(); j++) {
            model2.clear();
            jList2.setModel(model2);
            model3.clear();
            jList3.setModel(model3);
            model4.clear();
            jList4.setModel(model4);
        }
        jTextField1.setText("");
        jTextField2.setText("");
        listaAresta.clear();
        String aux = "O preço total ficou: R$ " + somaPreco;
        JOptionPane.showMessageDialog(rootPane, aux);
        somaPreco = 0;
    }//GEN-LAST:event_jButton5ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ClientView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ClientView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ClientView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ClientView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ClientView().setVisible(true);
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JList<String> jList1;
    private javax.swing.JList<String> jList2;
    private javax.swing.JList<String> jList3;
    private javax.swing.JList<String> jList4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    // End of variables declaration//GEN-END:variables
}
