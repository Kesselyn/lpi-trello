package model;

import java.io.File;
import java.util.ArrayList;

public class Usuario {
    private String apelido;
    private String nomeUsuario;
    private String email;
    private String senha;
    private String telefone;
    private File foto;
    private ArrayList <Mensagem> mensagens;
    private ArrayList <Projeto> projetos;
    private ArrayList <Tarefa> tarefas;
    
    //Construtor:
    public Usuario() {
        this("", "", "", "", "", null, null, null, null);
    }
    
    public Usuario (String apelido, String nomeUsuario, String email, String senha, String telefone, File foto, ArrayList <Mensagem> mensagens, ArrayList <Projeto> projetos, ArrayList <Tarefa> tarefas) {
        this.apelido = apelido;
        this.nomeUsuario = nomeUsuario;
        this.email = email;
        this.senha = senha;
        this.telefone = telefone;
        this.foto = foto;
        this.mensagens = mensagens;
        this.projetos = projetos;
        this.tarefas = tarefas;
    }

    //M?todos de acessos:
    public String getApelido() {
        return this.apelido;
    }

    public String getNomeUsuario() {
        return this.nomeUsuario;
    }

    public String getEmail() {
        return this.email;
    }

    public String getSenha() {
        return this.senha;
    }

    public String getTelefone() {
        return this.telefone;
    }

    public File getFoto() {
       return this.foto;
    }
    
    public ArrayList <Mensagem> getMensagens() {
    	return mensagens;
    }
    
    public ArrayList <Projeto> getProjetos() {
    	return projetos;
    }
    
    public ArrayList <Tarefa> getTarefas() {
    	return tarefas;
    }
    
    //Metodos modificadores:
    public void setApelido(String apelido) {
        this.apelido = apelido;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public void setFoto(File foto) {
        this.foto = foto;
    }
    
    public void setMensagens(ArrayList <Mensagem> mensagens) {
    	this.mensagens = mensagens;
    }
    
    public void setProjetos(ArrayList <Projeto> projetos) {
    	this.projetos = projetos;
    }
    
    public void setTarefas(ArrayList <Tarefa> tarefas) {
    	this.tarefas = tarefas;
    }
}