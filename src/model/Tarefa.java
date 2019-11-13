package model;

public class Tarefa {
	
	private int identificadorTarefa;
	private Usuario usuario;
	private Projeto projeto;
	private String titulo;
	private String descricao;
	private int ordem;
	private String estado;
	private String nivelPrioridade;
	
	//Construtores:	
	public Tarefa() {
		this(0, null, null, "", "", 0, "", "");
	}
	
	public Tarefa(int identificadorTarefa, Usuario usuario, Projeto projeto, String titulo, String descricao, int ordem, String estado, String nivelPrioridade) {
		this.identificadorTarefa = identificadorTarefa;
		this.usuario = usuario;
		this.projeto = projeto;
		this.titulo = titulo;
		this.descricao = descricao;
		this.ordem = ordem;
		this.estado = estado;
		this.nivelPrioridade = nivelPrioridade;
	}

	//Getters:
	public int getidentificadorTarefa() {
		return identificadorTarefa;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public Projeto getProjeto() {
		return projeto;
	}

	public String getTitulo() {
		return titulo;
	}

	public String getDescricao() {
		return descricao;
	}

	public int getOrdem() {
		return ordem;
	}

	public String getEstado() {
		return estado;
	}

	public String getNivelPrioridade() {
		return nivelPrioridade;
	}

	//Setters:
	public void setidentificadorTarefa(int identificadorTarefa) {
		this.identificadorTarefa = identificadorTarefa;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public void setProjeto(Projeto projeto) {
		this.projeto = projeto;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public void setOrdem(int ordem) {
		this.ordem = ordem;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public void setNivelPrioridade(String nivelPrioridade) {
		this.nivelPrioridade = nivelPrioridade;
	}
}
