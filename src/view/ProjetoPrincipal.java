/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import view.ListaUsuarios;

/**
 *
 * @author vitor
 */
public class ProjetoPrincipal extends javax.swing.JFrame {

    /**
     * Creates new form ProjetoPrincipal
     */
    public ProjetoPrincipal() {
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

        jButton4 = new javax.swing.JButton();
        lbaelNomeDoProjeto = new javax.swing.JLabel();
        btnAdicionarAtividade = new javax.swing.JButton();
        btnConversas = new javax.swing.JButton();
        labelParaFazer = new javax.swing.JLabel();
        labelEmProgresso = new javax.swing.JLabel();
        labelConcluido = new javax.swing.JLabel();
        painelAtividades = new javax.swing.JPanel();
        labelAtividade = new javax.swing.JLabel();
        labelDescricaoDaAtividade = new javax.swing.JLabel();
        btnPassar = new javax.swing.JButton();
        btnGerenciarUsuarios = new javax.swing.JButton();

        jButton4.setText("jButton4");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        lbaelNomeDoProjeto.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lbaelNomeDoProjeto.setText("Nome do Projeto");

        btnAdicionarAtividade.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnAdicionarAtividade.setText("Adicionar atividade");
        btnAdicionarAtividade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdicionarAtividadeActionPerformed(evt);
            }
        });

        btnConversas.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnConversas.setText("Conversas");
        btnConversas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConversasActionPerformed(evt);
            }
        });

        labelParaFazer.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        labelParaFazer.setText("Para fazer");

        labelEmProgresso.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        labelEmProgresso.setText("Em progresso");

        labelConcluido.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        labelConcluido.setText("Concluido");

        painelAtividades.setBackground(new java.awt.Color(219, 219, 219));

        labelAtividade.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        labelAtividade.setText("Atividade");

        labelDescricaoDaAtividade.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        labelDescricaoDaAtividade.setText("Descrição da atividade");

        btnPassar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnPassar.setText(">");
        btnPassar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPassarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout painelAtividadesLayout = new javax.swing.GroupLayout(painelAtividades);
        painelAtividades.setLayout(painelAtividadesLayout);
        painelAtividadesLayout.setHorizontalGroup(
            painelAtividadesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelAtividadesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelAtividade)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelAtividadesLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnPassar))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelAtividadesLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(labelDescricaoDaAtividade)
                .addContainerGap())
        );
        painelAtividadesLayout.setVerticalGroup(
            painelAtividadesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelAtividadesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelAtividade)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(labelDescricaoDaAtividade)
                .addGap(18, 18, 18)
                .addComponent(btnPassar))
        );

        btnGerenciarUsuarios.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnGerenciarUsuarios.setText("Gerenciar usuários");
        btnGerenciarUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGerenciarUsuariosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lbaelNomeDoProjeto)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 135, Short.MAX_VALUE)
                                .addComponent(btnGerenciarUsuarios)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(painelAtividades, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(labelParaFazer)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(labelEmProgresso)))
                                .addGap(166, 166, 166)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnAdicionarAtividade)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(labelConcluido)
                                .addGap(74, 74, 74))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnConversas)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbaelNomeDoProjeto)
                    .addComponent(btnAdicionarAtividade)
                    .addComponent(btnGerenciarUsuarios, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(52, 52, 52)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelParaFazer)
                    .addComponent(labelEmProgresso)
                    .addComponent(labelConcluido))
                .addGap(18, 18, 18)
                .addComponent(painelAtividades, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 267, Short.MAX_VALUE)
                .addComponent(btnConversas, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnAdicionarAtividadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdicionarAtividadeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAdicionarAtividadeActionPerformed

    private void btnPassarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPassarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnPassarActionPerformed

    private void btnConversasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConversasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnConversasActionPerformed

    private void btnGerenciarUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGerenciarUsuariosActionPerformed
       ListaUsuarios listaUsu = new ListaUsuarios();
       setVisible(true);
       
    }//GEN-LAST:event_btnGerenciarUsuariosActionPerformed

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
            java.util.logging.Logger.getLogger(ProjetoPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ProjetoPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ProjetoPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ProjetoPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ProjetoPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdicionarAtividade;
    private javax.swing.JButton btnConversas;
    private javax.swing.JButton btnGerenciarUsuarios;
    private javax.swing.JButton btnPassar;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel labelAtividade;
    private javax.swing.JLabel labelConcluido;
    private javax.swing.JLabel labelDescricaoDaAtividade;
    private javax.swing.JLabel labelEmProgresso;
    private javax.swing.JLabel labelParaFazer;
    private javax.swing.JLabel lbaelNomeDoProjeto;
    private javax.swing.JPanel painelAtividades;
    // End of variables declaration//GEN-END:variables
}