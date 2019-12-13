/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.util.ArrayList;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

import dao.TarefaDAO;
import dao.Conexao;
import model.Projeto;
import model.Usuario;
import model.Tarefa;

/**
 *
 * @author vitor
 */
public class ProjetoPrincipal extends javax.swing.JFrame {
    public static Projeto projeto;
    public static Usuario usuario;
    /**
     * Creates new form ProjetoPrincipal
     */
    public ProjetoPrincipal(Projeto p, Usuario u) {
        this.projeto = p;
        this.usuario = u;
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

        labelNomeDoProjeto = new javax.swing.JLabel();
        btnAdicionarAtividade = new javax.swing.JButton();
        btnConversas = new javax.swing.JButton();
        labelParaFazer = new javax.swing.JLabel();
        labelEmProgresso = new javax.swing.JLabel();
        labelConcluido = new javax.swing.JLabel();
        btnGerenciarUsuarios = new javax.swing.JButton();
        btnVoltar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setSize(new java.awt.Dimension(1000, 1000));

        labelNomeDoProjeto.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        labelNomeDoProjeto.setBounds(20, 10, 100, 30);
        labelNomeDoProjeto.setText(projeto.getNomeProjeto());

        JButton editarProjeto = new JButton("Editar Projeto");
        editarProjeto.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        editarProjeto.setBounds(200, 10, 130, 30);
        add(editarProjeto);
        editarProjeto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarProjetoActionPerformed(evt);
            }
        });

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

        btnGerenciarUsuarios.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnGerenciarUsuarios.setText("Gerenciar usuários");
        btnGerenciarUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGerenciarUsuarioActionPerformed(evt);
            }
        });

        btnVoltar.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnVoltar.setText("Voltar");
        btnVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVoltarActionPerformed(evt);
            }
        });

        TarefaDAO tDAO = new TarefaDAO(Conexao.conectar());
        ArrayList<Tarefa> tarefasN = tDAO.readTarefa(projeto, "nova");
        ArrayList<Tarefa> tarefasE = tDAO.readTarefa(projeto, "em andamento");
        ArrayList<Tarefa> tarefasF = tDAO.readTarefa(projeto, "finalizada");
        
        int novaY = 120;
        for(Tarefa t : tarefasN) { 

            JPanel painel = new JPanel();
            painel.setLayout(new FlowLayout());
            painel.setBackground(Color.WHITE);
            painel.setBounds(10, novaY, 200, 80);
            
            JLabel titulo = new JLabel("    " + t.getTitulo());
            titulo.setPreferredSize(new Dimension(200, 20));

            JLabel descricao = new JLabel("    "  + t.getDescricao());
            descricao.setPreferredSize(new Dimension(200, 20));

            JButton verEditar = new JButton("Ver/Editar");
            verEditar.setPreferredSize(new Dimension(85, 25));

            JButton btnPassarNA = new JButton(">");
            btnPassarNA.setPreferredSize(new Dimension(35, 25));

            painel.add(titulo);
            painel.add(descricao);
            painel.add(verEditar);
            painel.add(btnPassarNA);

            add(painel);

            verEditar.addActionListener(new ActionListener() { 
                @Override
                public void actionPerformed(ActionEvent e) {
                    EditarTarefa et = new EditarTarefa(t);
                    dispose();
                    et.iniciar();
                }
            });

            btnPassarNA.addActionListener(new ActionListener() { 
                @Override
                public void actionPerformed(ActionEvent e) {
                    t.setEstado("em andamento");
                    tDAO.updateTarefa(t);

                    dispose();
                    ProjetoPrincipal pp = new  ProjetoPrincipal(projeto, usuario);
                    pp.iniciar();
                }
            });

            novaY += 90;
        }

        int andamentoY = 120;
        for(Tarefa t : tarefasE) { 

            JPanel painel = new JPanel();
            painel.setLayout(new FlowLayout());
            painel.setBackground(Color.WHITE);
            painel.setBounds(250, andamentoY, 200, 80);
            
            JLabel titulo = new JLabel("    " + t.getTitulo());
            titulo.setPreferredSize(new Dimension(200, 20));

            JLabel descricao = new JLabel("    "  + t.getDescricao());
            descricao.setPreferredSize(new Dimension(200, 20));

            JButton verEditar = new JButton("Ver/Editar");
            verEditar.setPreferredSize(new Dimension(85, 25));

            JButton btnPassarAF = new JButton(">");
            btnPassarAF.setPreferredSize(new Dimension(35, 25));

            JButton btnPassarAN = new JButton("<");
            btnPassarAN.setPreferredSize(new Dimension(35, 25));

            painel.add(titulo);
            painel.add(descricao);
            painel.add(btnPassarAN);
            painel.add(verEditar);
            painel.add(btnPassarAF);

            add(painel);

            verEditar.addActionListener(new ActionListener() { 
                @Override
                public void actionPerformed(ActionEvent e) {
                    EditarTarefa et = new EditarTarefa(t);
                    dispose();
                    et.iniciar();
                }
            });

            btnPassarAN.addActionListener(new ActionListener() { 
                @Override
                public void actionPerformed(ActionEvent e) {
                    t.setEstado("nova");
                    tDAO.updateTarefa(t);

                    dispose();
                    ProjetoPrincipal pp = new  ProjetoPrincipal(projeto, usuario);
                    pp.iniciar();
                }
            });

            btnPassarAF.addActionListener(new ActionListener() { 
                @Override
                public void actionPerformed(ActionEvent e) {
                    t.setEstado("finalizada");
                    tDAO.updateTarefa(t);

                    dispose();
                    ProjetoPrincipal pp = new  ProjetoPrincipal(projeto, usuario);
                    pp.iniciar();
                }
            });

            andamentoY += 90;
        }

        int finalizadaY = 120;
        for(Tarefa t : tarefasF) { 

            JPanel painel = new JPanel();
            painel.setLayout(new FlowLayout());
            painel.setBackground(Color.WHITE);
            painel.setBounds(500, finalizadaY, 200, 80);
            
            JLabel titulo = new JLabel("    " + t.getTitulo());
            titulo.setPreferredSize(new Dimension(200, 20));

            JLabel descricao = new JLabel("    "  + t.getDescricao());
            descricao.setPreferredSize(new Dimension(200, 20));

            JButton verEditar = new JButton("Ver/Editar");
            verEditar.setPreferredSize(new Dimension(85, 25));

            JButton btnPassarFA = new JButton("<");
            btnPassarFA.setPreferredSize(new Dimension(35, 25));

            painel.add(titulo);
            painel.add(descricao);
            painel.add(btnPassarFA);
            painel.add(verEditar);

            add(painel);

            verEditar.addActionListener(new ActionListener() { 
                @Override
                public void actionPerformed(ActionEvent e) {
                    EditarTarefa et = new EditarTarefa(t);
                    dispose();
                    et.iniciar();
                }
            });

            btnPassarFA.addActionListener(new ActionListener() { 
                @Override
                public void actionPerformed(ActionEvent e) {
                    t.setEstado("em andamento");
                    tDAO.updateTarefa(t);
                    
                    dispose();
                    ProjetoPrincipal pp = new  ProjetoPrincipal(projeto, usuario);
                    pp.iniciar();
                }
            });

            finalizadaY += 90;
        }

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
                                .addComponent(labelNomeDoProjeto)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 135, Short.MAX_VALUE)
                                .addComponent(btnGerenciarUsuarios)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
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
                        .addComponent(btnVoltar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnConversas)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelNomeDoProjeto)
                    .addComponent(btnAdicionarAtividade)
                    .addComponent(btnGerenciarUsuarios, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(52, 52, 52)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelParaFazer)
                    .addComponent(labelEmProgresso)
                    .addComponent(labelConcluido))
                .addGap(18, 18, 18)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 261, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnConversas, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>                        

    private void btnEditarProjetoActionPerformed(java.awt.event.ActionEvent evt) {                                                      
        EditarProjeto ep = new  EditarProjeto(this.usuario, this.projeto);
        dispose();
        ep.iniciar();
    }                                                                                     


    private void btnAdicionarAtividadeActionPerformed(java.awt.event.ActionEvent evt) {                                                      
        CriarNovaTarefa ct = new CriarNovaTarefa(usuario, projeto);
        dispose();
        ct.iniciar();
    }                                                                                     

    private void btnConversasActionPerformed(java.awt.event.ActionEvent evt) {                                             
        Contatos contatos = new Contatos(usuario, projeto);
        dispose();
        contatos.iniciar();
    }                                            

    private void btnVoltarActionPerformed(java.awt.event.ActionEvent evt) {                                          
        ListaProjetos listaProjetos = new ListaProjetos(usuario);
        dispose();
        listaProjetos.iniciar();
    }     
    
    private void btnGerenciarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {                                          
        ListaExcluirUsuario le = new ListaExcluirUsuario(this.usuario, this.projeto);
        dispose();
        le.iniciar();
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
            java.util.logging.Logger.getLogger(ProjetoPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ProjetoPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ProjetoPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ProjetoPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        this.setVisible(true);

    }

    // Variables declaration - do not modify                     
    private javax.swing.JButton btnAdicionarAtividade;
    private javax.swing.JButton btnConversas;
    private javax.swing.JButton btnGerenciarUsuarios;
    private javax.swing.JButton btnVoltar;
    private javax.swing.JLabel labelConcluido;
    private javax.swing.JLabel labelEmProgresso;
    private javax.swing.JLabel labelNomeDoProjeto;
    private javax.swing.JLabel labelParaFazer;
    // private javax.swing.JPanel painelAtividades;
    // End of variables declaration                   
}
