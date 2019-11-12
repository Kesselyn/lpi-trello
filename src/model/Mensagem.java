package model;

import java.util.GregorianCalendar;

public class Mensagem {
    private Usuario destinatario;
    private Usuario remetente;
    private String texto;
    private String estado;
    private GregorianCalendar dataHoraVisualizacao;
    private GregorianCalendar dataHoraEnvio;

    //Construtores:
    public Mensagem() {
        this(null, null, "", "", null, null);
    }
    
    public Mensagem (Usuario destinatario, Usuario remetente, String texto, String estado, GregorianCalendar dataHoraVisualizacao, GregorianCalendar dataHoraEnvio) {
        this.destinatario = destinatario;
        this.remetente = remetente;
        this.texto = texto;
        this.estado = estado;
        this.dataHoraVisualizacao = dataHoraVisualizacao;
        this.dataHoraEnvio = dataHoraEnvio;
    }

    //Metodos de acessos:
    public Usuario getDestinatario() {
        return this.destinatario;
    }

    public Usuario getRemetente() {
        return this.remetente;
    }

    public String getTexto() {
        return this.texto;
    }

    public String getEstado() {
        return this.estado;
    }

    public GregorianCalendar getDataHoraVisualizacao() {
		return dataHoraVisualizacao;
    }
    
    public GregorianCalendar getDataHoraEnvio() {
		return dataHoraEnvio;
    }
    
    //Metodos modificadores:
    public void setDestinatario(Usuario destinatario) {
        this.destinatario = destinatario;
    }

    public void setRemetente(Usuario remetente) {
        this.remetente = remetente;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void setDataHoraVisualizacao(GregorianCalendar dataHoraVisualizacao) {
		this.dataHoraVisualizacao = dataHoraVisualizacao;
    }

    public void setDataHoraEnvio(GregorianCalendar dataHoraEnvio) {
		this.dataHoraEnvio = dataHoraEnvio;
    }
}