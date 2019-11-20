package model;

public class AlocaUsuarioProjeto {
    private int identificadorAlocaUsuarioProjeto;
    private Usuario usuario;
    private Projeto projeto;

    public AlocaUsuarioProjeto() {
        this(0, null, null);
    }

    public AlocaUsuarioProjeto(int identificadorAlocaUsuarioProjeto, Usuario usuario, Projeto projeto) {
        this.identificadorAlocaUsuarioProjeto = identificadorAlocaUsuarioProjeto;
        this.usuario = usuario;
        this.projeto = projeto;
    }

    public int getIdenficiadorAlocaUsuarioProjeto() {
        return identificadorAlocaUsuarioProjeto;
    }

    public Usuario getUsuario() {
		return usuario;
	}

	public Projeto getProjeto() {
		return projeto;
	}
    
    public void setIdentificadorUsuarioProjeto(int identificadorAlocaUsuarioProjeto) {
        this.identificadorAlocaUsuarioProjeto = identificadorAlocaUsuarioProjeto;
    }

    public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public void setProjeto(Projeto projeto) {
		this.projeto = projeto;
	}
}