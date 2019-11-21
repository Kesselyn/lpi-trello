package model;

public class Tarefa {
	
	private int identificadorTarefa;
	private String titulo;
	private String descricao;
	private int ordem;
	private String estado;
	private String nivelPrioridade;
	private Usuario usuario;
	private Projeto projeto;
	
	//Construtores:	
	public Tarefa() {
		this(0, "", "", 0, "", "", null, null);
	}
	
	public Tarefa(int identificadorTarefa, String titulo, String descricao, int ordem, String estado, String nivelPrioridade, Usuario usuario, Projeto projeto) {
		
		this.identificadorTarefa = identificadorTarefa;
		this.titulo = titulo;
		this.descricao = descricao;
		this.ordem = ordem;
		this.estado = estado;
		this.nivelPrioridade = nivelPrioridade;
		this.usuario = usuario;
		this.projeto = projeto;
	}

	//Getters:
	public int getIdentificadorTarefa() {
		return identificadorTarefa;
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
	
	public Usuario getUsuario() {
		return usuario;
	}

	public Projeto getProjeto() {
		return projeto;
	}

	//Setters:
	public void setIdentificadorTarefa(int identificadorTarefa) {
		this.identificadorTarefa = identificadorTarefa;
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

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public void setProjeto(Projeto projeto) {
		this.projeto = projeto;
	}
}
