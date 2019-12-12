/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import javax.swing.JButton;
import java.util.ArrayList;
import java.awt.event.*;

import dao.AlocaUsuarioProjetoDAO;
import dao.Conexao;
import model.Usuario;
import model.Projeto;
import view.CriarNovoProjeto;

/**
 *
 * @author vitor
 */
public class ListaProjetos extends javax.swing.JFrame {
    public static Usuario usuario;

    /**
     * Creates new form ListaProjetos
     */
    // public ListaProjetos() {
    //     initComponents();
    // }

    public ListaProjetos(Usuario usuario) {
        this.usuario = usuario;
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

        painelDeProjeto = new javax.swing.JPanel();
        labelNomeDoUsuario = new javax.swing.JLabel();
        btnNovoProjeto = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        labelNomeDoUsuario.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        labelNomeDoUsuario.setText(this.usuario.getNomeUsuario());
        

        btnNovoProjeto.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnNovoProjeto.setText("Novo Projeto");
        btnNovoProjeto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoProjetoActionPerformed(evt);
            }
        });

        AlocaUsuarioProjetoDAO trazer = new AlocaUsuarioProjetoDAO(Conexao.conectar());
        ArrayList<Projeto> projetosADM = trazer.readProjetosADM(this.usuario);
        ArrayList<Projeto> projetosDentro = trazer.readProjetosUsuario(this.usuario);
        
        
        int i = 10;
        for(Projeto p : projetosADM) { 
	
            JButton btn = new JButton(p.getNomeProjeto());
            btn.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
            btn.setBounds(i, 80, 150, 50);
            add(btn);

            btn.addActionListener(new ActionListener() { 
                @Override
                public void actionPerformed(ActionEvent e) {
                    ProjetoPrincipal pp = new ProjetoPrincipal(p, usuario);
                    dispose();
                    pp.iniciar();
                }
            });

            i += 160;
        }
        
        for(Projeto p : projetosDentro) { 
			
            JButton btn = new JButton(p.getNomeProjeto());
            btn.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
            btn.setBounds(i, 80, 150, 50);
            add(btn);

            btn.addActionListener(new ActionListener() { 
                @Override
                public void actionPerformed(ActionEvent e) {
                    ProjetoPrincipal pp = new ProjetoPrincipal(p, usuario);
                    dispose();
                    pp.iniciar();
                }
            });
            
            i += 160;
        }

        javax.swing.GroupLayout painelDeProjetoLayout = new javax.swing.GroupLayout(painelDeProjeto);
        painelDeProjeto.setLayout(painelDeProjetoLayout);
        painelDeProjetoLayout.setHorizontalGroup(
            painelDeProjetoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelDeProjetoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelDeProjetoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painelDeProjetoLayout.createSequentialGroup()
                        .addComponent(labelNomeDoUsuario)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 374, Short.MAX_VALUE)
                        .addComponent(btnNovoProjeto, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(painelDeProjetoLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        painelDeProjetoLayout.setVerticalGroup(
            painelDeProjetoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelDeProjetoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelDeProjetoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelNomeDoUsuario)
                    .addComponent(btnNovoProjeto, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addContainerGap(388, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(painelDeProjeto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(painelDeProjeto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>                        

    private void btnNovoProjetoActionPerformed(java.awt.event.ActionEvent evt) {                                               
        CriarNovoProjeto criarProjeto = new CriarNovoProjeto(this.usuario);
        dispose();
        criarProjeto.iniciar();
        
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
            java.util.logging.Logger.getLogger(ListaProjetos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ListaProjetos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ListaProjetos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ListaProjetos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        this.setVisible(true);

    }

    // Variables declaration - do not modify                     
    private javax.swing.JButton btnNovoProjeto;
    private javax.swing.JLabel labelNomeDoUsuario;
    private javax.swing.JPanel painelDeProjeto;
    // End of variables declaration                   
}
