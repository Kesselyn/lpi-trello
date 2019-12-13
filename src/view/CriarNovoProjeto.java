/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import javax.swing.*;

import dao.Conexao;
import dao.ProjetoDAO;
import model.Usuario;
import model.Projeto;
/**
 *
 * @author vitor
 */
public class CriarNovoProjeto extends javax.swing.JFrame {

    public static Usuario usuario;

    Projeto projeto = new Projeto();
    
    /**
     * Creates new form CriarNovaTarefa
     */
    

    public CriarNovoProjeto(Usuario usuario) {
        this.usuario = usuario;
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

        inputNomeDoProjeto = new javax.swing.JTextField();
        btnCriar = new javax.swing.JButton();
        labelDigiteoNomeDoProjeto = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setSize(new java.awt.Dimension(1000, 1000));

        inputNomeDoProjeto.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        inputNomeDoProjeto.setMaximumSize(new java.awt.Dimension(1920, 1920));
        inputNomeDoProjeto.setName(""); // NOI18N

        btnCriar.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnCriar.setText("Criar");
        btnCriar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCriarActionPerformed(evt);
            }
        });

        JButton btnVoltar = new JButton("Voltar");
        btnVoltar.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        btnVoltar.setBounds(20, 460, 100, 40);
        add(btnVoltar);

        btnVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVoltarActionPerformed(evt);
            }
        });

        labelDigiteoNomeDoProjeto.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        labelDigiteoNomeDoProjeto.setText("Digite o nome do novo projeto");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnCriar, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34))
            .addGroup(layout.createSequentialGroup()
                .addGap(86, 86, 86)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(labelDigiteoNomeDoProjeto)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(inputNomeDoProjeto, javax.swing.GroupLayout.DEFAULT_SIZE, 592, Short.MAX_VALUE)
                        .addGap(94, 94, 94))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(175, 175, 175)
                .addComponent(labelDigiteoNomeDoProjeto)
                .addGap(47, 47, 47)
                .addComponent(inputNomeDoProjeto, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 171, Short.MAX_VALUE)
                .addComponent(btnCriar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCriarActionPerformed
        ListaProjetos listaProjetos = new ListaProjetos(usuario);
        dispose();
        listaProjetos.iniciar();
    }

    private void btnCriarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCriarActionPerformed
        String nomeProjeto = inputNomeDoProjeto.getText();

        if(nomeProjeto.equals("")) {
        	JOptionPane.showMessageDialog(null, "O projeto deve ser nomeado.", "Dados Inválidos", JOptionPane.ERROR_MESSAGE);
        } else {
            projeto.setNomeProjeto(nomeProjeto);
            projeto.setUsuarioProprietario(usuario);
            projeto.setLista("");
    
            ProjetoDAO pDAO = new ProjetoDAO(Conexao.conectar());
    
            try{
                pDAO.createProjeto(projeto);

                dispose();
                ListaProjetos lp = new ListaProjetos(usuario);
                lp.iniciar();
            } catch(Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
                e.printStackTrace();
            }
        }
    }

    /**
     * @param args the command line arguments
     */
    public void iniciar() {
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
            java.util.logging.Logger.getLogger(CriarNovoProjeto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CriarNovoProjeto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CriarNovoProjeto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CriarNovoProjeto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        this.setVisible(true);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCriar;
    private javax.swing.JTextField inputNomeDoProjeto;
    private javax.swing.JLabel labelDigiteoNomeDoProjeto;
    // End of variables declaration//GEN-END:variables
}
