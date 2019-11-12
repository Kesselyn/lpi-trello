package model;

import java.util.ArrayList;

public class Projeto {
	private int identificadorProjeto; //deixar ou não?
	private String nomeProjeto;
	private String lista;
	private Usuario usuario; //perguntar pro igor
	private Usuario usuarioProprietario;
	private ArrayList <Tarefa> tarefas; //Arrays estão certos?
	
	//Construtor:
	public Projeto() {
		this(0, "", "", null, null);
	}
	
	public Projeto(int identificadorProjeto, String nomeProjeto, String lista, Usuario usuario, Usuario usuarioProprietario) {
		this.identificadorProjeto = identificadorProjeto;
		this.nomeProjeto = nomeProjeto;
		this.lista = lista;
		this.usuario = usuario;
		this.usuarioProprietario = usuarioProprietario;
	}
	
	//Getters:
	public int getIdentificadorProjeto() {
		return identificadorProjeto;
	}

	public String getNomeProjeto() {
		return nomeProjeto;
	}

	public String getLista() {
		return lista;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public Usuario getUsuarioProprietario() {
		return usuarioProprietario;
	}
	
	//Setters:
	public void setIdentificadorProjeto(int identificadorProjeto) {
		this.identificadorProjeto = identificadorProjeto;
	}

	public void setNomeProjeto(String nomeProjeto) {
		this.nomeProjeto = nomeProjeto;
	}

	public void setLista(String lista) {
		this.lista = lista;
	}


	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public void setUsuarioProprietario(Usuario usuarioProprietario) {
		this.usuarioProprietario = usuarioProprietario;
	}
	
}
