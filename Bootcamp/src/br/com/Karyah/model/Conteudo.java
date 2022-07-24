package br.com.Karyah.model;

public abstract class Conteudo {
	
	private String titulo;
	private String descricao;

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	protected static final double XP_PADRAO =10d;
	
	public abstract double calcularXp();
	
}
