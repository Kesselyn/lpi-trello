/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import dao.AlocaUsuarioProjetoDAO;
import dao.Conexao;
import dao.UsuarioDAO;
import model.Usuario;
/**
 *
 * @author vitor
 */
public class EditarUsuario extends javax.swing.JFrame {
    public static Usuario usuario;
    /**
     * Creates new form EditarUsuario
     */
    public EditarUsuario(Usuario u) {
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

        labelNome = new javax.swing.JLabel();
        inputNome = new javax.swing.JTextField();
        inputNome.setText(usuario.getNomeUsuario());

        labelEmail = new javax.swing.JLabel();
        inputEmail = new javax.swing.JTextField();
        inputEmail.setText(usuario.getEmail());

        labelSenha = new javax.swing.JLabel();
        inputSenha = new javax.swing.JTextField();
        inputSenha.setText(usuario.getSenha());

        labelTelefone = new javax.swing.JLabel();
        inputTelefone = new javax.swing.JTextField();
        inputTelefone.setText(usuario.getTelefone());

        labelEditar = new javax.swing.JLabel();
        btnUpload = new javax.swing.JButton();
        labelApelido = new javax.swing.JLabel();
        btnEditar = new javax.swing.JButton();
        btnDeletar = new javax.swing.JButton();
        labelApelidoDoUsuario = new javax.swing.JLabel();
        btnVoltar1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setSize(new java.awt.Dimension(1000, 1000));

        labelEditar.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        labelEditar.setText("Editar");

        labelNome.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        labelNome.setText("Nome");

        labelEmail.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        labelEmail.setText("Email");

        labelSenha.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        labelSenha.setText("Senha");

        labelTelefone.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        labelTelefone.setText("Telefone");

        btnUpload.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnUpload.setText("Fazer upload da foto");
        btnUpload.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUploadActionPerformed(evt);
            }
        });

        labelApelido.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        labelApelido.setText("Apelido");

        btnEditar.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnEditar.setText("Editar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        btnDeletar.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnDeletar.setText("Deletar");
        btnDeletar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeletarActionPerformed(evt);
            }
        });

        labelApelidoDoUsuario.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        labelApelidoDoUsuario.setText(usuario.getApelido());

        btnVoltar1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnVoltar1.setText("Voltar");
        btnVoltar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVoltar1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(175, 175, 175)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnVoltar1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnDeletar)
                        .addGap(18, 18, 18)
                        .addComponent(btnEditar))
                    .addComponent(btnUpload, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(inputSenha, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(inputEmail, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(inputTelefone, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelApelido)
                            .addComponent(labelEmail)
                            .addComponent(labelTelefone)
                            .addComponent(labelSenha)
                            .addComponent(labelApelidoDoUsuario))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 88, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(inputNome, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelNome))))
                .addGap(152, 152, 152))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelEditar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelEditar)
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelApelido)
                    .addComponent(labelNome))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(inputNome, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelApelidoDoUsuario))
                .addGap(18, 18, 18)
                .addComponent(labelEmail)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(inputEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(labelSenha)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(inputSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(labelTelefone)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(inputTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnUpload, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 52, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEditar)
                    .addComponent(btnDeletar)
                    .addComponent(btnVoltar1))
                .addGap(21, 21, 21))
        );

        pack();
    }// </editor-fold>                                             

    private void btnUploadActionPerformed(java.awt.event.ActionEvent evt) {                                          
        JFileChooser file = new JFileChooser();
        file.setFileSelectionMode(JFileChooser.FILES_ONLY);
        file.showOpenDialog(null);
        File foto = file.getSelectedFile();

        if(foto != null) {
            usuario.setFoto(foto);
        }
    }                                         

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {
        String nome = inputNome.getText();
        String email = inputEmail.getText();
        String senha = inputSenha.getText();
        String telefone = inputTelefone.getText();

        // String patternEmail = "(.@.)";
       
        if(nome.equals("")) {
        	JOptionPane.showMessageDialog(null, "O Nome não pode estar vazio." + "\n Tente Novamente.", "DADOS INVÁLIDOS", JOptionPane.ERROR_MESSAGE);
        }        
        
        if(email.equals("")) {
        	JOptionPane.showMessageDialog(null, "O email não pode estar vazio." + "\n Insira um email válido.", "DADOS INVÁLIDOS", JOptionPane.ERROR_MESSAGE);
        }
        
        // else if(usuario.getEmail().matches(patternEmail) == false) { 					
        //     JOptionPane.showMessageDialog(null, "Email invalido!!" + "\n Confira se o email está correto. ");
        // }

        if(senha.equals("")) {
        	JOptionPane.showMessageDialog(null, "A senha deve conter no mínimo 3 caracteres." + "\n Insira uma senha válida.", "DADOS INVÁLIDOS", JOptionPane.ERROR_MESSAGE);
        }

        else if(senha.length() < 3) {
        	JOptionPane.showMessageDialog(null, "A senha deve conter no mínimo 3 caracteres." + "\n Insira uma senha válida.", "DADOS INVÁLIDOS", JOptionPane.ERROR_MESSAGE);
        } 
        
        else {
            usuario.setNomeUsuario(nome);
            usuario.setEmail(email);
            usuario.setSenha(senha);
            usuario.setTelefone(telefone);
    
            UsuarioDAO uDAO = new UsuarioDAO(Conexao.conectar());
            
            try {
                uDAO.updateUsuario(usuario);
                ListaProjetos lp = new ListaProjetos(usuario);
                dispose();
                lp.iniciar();
                
            } catch(Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
                e.printStackTrace();
            }
        }
    }                                         

    private void btnDeletarActionPerformed(java.awt.event.ActionEvent evt) {                                           
        UsuarioDAO uDAO = new UsuarioDAO(Conexao.conectar());
        uDAO.deleteUsuario(usuario);

        dispose();
        Login login = new Login();
        login.iniciar();
    }                                          

    private void btnVoltar1ActionPerformed(java.awt.event.ActionEvent evt) {                                           
        ListaProjetos lp = new ListaProjetos(usuario);
        dispose();
        lp.iniciar();
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
            java.util.logging.Logger.getLogger(EditarUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EditarUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EditarUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EditarUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        this.setVisible(true);
    }

    // Variables declaration - do not modify                     
    private javax.swing.JButton btnDeletar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnUpload;
    private javax.swing.JButton btnVoltar1;
    private javax.swing.JTextField inputEmail;
    private javax.swing.JTextField inputNome;
    private javax.swing.JTextField inputSenha;
    private javax.swing.JTextField inputTelefone;
    private javax.swing.JLabel labelApelido;
    private javax.swing.JLabel labelApelidoDoUsuario;
    private javax.swing.JLabel labelEditar;
    private javax.swing.JLabel labelEmail;
    private javax.swing.JLabel labelNome;
    private javax.swing.JLabel labelSenha;
    private javax.swing.JLabel labelTelefone;
    // End of variables declaration                   
}