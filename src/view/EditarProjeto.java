/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import model.Usuario;

import javax.swing.JOptionPane;

import dao.Conexao;
import dao.ProjetoDAO;
import model.Projeto;
/**
 *
 * @author vitor
 */
public class EditarProjeto extends javax.swing.JFrame {
    public static Usuario usuario;
    public static Projeto projeto;
    /**
     * Creates new form EditarProjeto
     */
    public EditarProjeto(Usuario u, Projeto p) {
        this.usuario = u;
        this.projeto = p;
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        labelEditeoNomeDoProjeto = new javax.swing.JLabel();
        inputNomeDoProjeto = new javax.swing.JTextField();
        inputNomeDoProjeto.setText(projeto.getNomeProjeto());


        btnDeletar = new javax.swing.JButton();
        btnVoltar = new javax.swing.JButton();
        btnEditar1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setSize(new java.awt.Dimension(1000, 1000));

        inputNomeDoProjeto.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        inputNomeDoProjeto.setMaximumSize(new java.awt.Dimension(1920, 1920));
        inputNomeDoProjeto.setName(""); // NOI18N

        btnDeletar.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnDeletar.setText("Deletar");
        btnDeletar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeletarActionPerformed(evt);
            }
        });

        labelEditeoNomeDoProjeto.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        labelEditeoNomeDoProjeto.setText("Editar o nome do novo projeto");

        btnVoltar.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnVoltar.setText("Voltar");
        btnVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVoltarActionPerformed(evt);
            }
        });

        btnEditar1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnEditar1.setText("Editar");
        btnEditar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditar1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnDeletar, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(179, 179, 179))
            .addGroup(layout.createSequentialGroup()
                .addGap(86, 86, 86)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(labelEditeoNomeDoProjeto)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(inputNomeDoProjeto, javax.swing.GroupLayout.DEFAULT_SIZE, 590, Short.MAX_VALUE)
                        .addGap(94, 94, 94))))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(604, Short.MAX_VALUE)
                    .addComponent(btnEditar1, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(24, 24, 24)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(175, 175, 175)
                .addComponent(labelEditeoNomeDoProjeto)
                .addGap(47, 47, 47)
                .addComponent(inputNomeDoProjeto, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 170, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnDeletar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(22, 22, 22))))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(474, Short.MAX_VALUE)
                    .addComponent(btnEditar1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(23, 23, 23)))
        );

        pack();
    }// </editor-fold>                        
                                                 

    private void btnDeletarActionPerformed(java.awt.event.ActionEvent evt) {                                           
        
        ProjetoDAO pDAO = new ProjetoDAO(Conexao.conectar());
        pDAO.deleteProjeto(projeto);
        
        ListaProjetos lp = new ListaProjetos(usuario);
        dispose();
        lp.iniciar();
        
    }                                          

    private void btnVoltarActionPerformed(java.awt.event.ActionEvent evt) {                                          
        ProjetoPrincipal pp = new ProjetoPrincipal(projeto, usuario);
        dispose();
        pp.iniciar();
    }                                         

    private void btnEditar1ActionPerformed(java.awt.event.ActionEvent evt) {                                           
        String nomeProjeto = inputNomeDoProjeto.getText();
        
        if(nomeProjeto.equals("")) {
            JOptionPane.showMessageDialog(null, "O Nome não pode estar vazio." + "\n Tente Novamente.", "DADOS INVÁLIDOS", JOptionPane.ERROR_MESSAGE);
        } else {
            projeto.setNomeProjeto(nomeProjeto);
            ProjetoDAO pDAO = new ProjetoDAO(Conexao.conectar());
            
            try{
                pDAO.updateProjeto(projeto);
                
                ProjetoPrincipal pp = new ProjetoPrincipal(projeto, usuario);
                dispose();
                pp.iniciar();
            } catch(Exception ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
                ex.printStackTrace();
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
            java.util.logging.Logger.getLogger(EditarProjeto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EditarProjeto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EditarProjeto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EditarProjeto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        this.setVisible(true);
    }

    // Variables declaration - do not modify                     
    private javax.swing.JButton btnDeletar;
    private javax.swing.JButton btnEditar1;
    private javax.swing.JButton btnVoltar;
    private javax.swing.JTextField inputNomeDoProjeto;
    private javax.swing.JLabel labelEditeoNomeDoProjeto;
    // End of variables declaration                   
}