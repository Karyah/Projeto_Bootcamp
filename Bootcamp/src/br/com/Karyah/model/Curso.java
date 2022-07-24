package br.com.Karyah.model;

public class Curso extends Conteudo{
	
	private int cargaHoraria;
	
	public int getCargaHoraria() {
		return cargaHoraria;
	}
	public void setCargaHoraria(int cargaHoraria) {
		this.cargaHoraria = cargaHoraria;
	}
	
	public Curso() {
		
	}
	
	
	public double calcularXp() {
		return XP_PADRAO * this.cargaHoraria;
	}
	@Override
	public String toString() {
		return "Curso {Carga horária: " + cargaHoraria + ". Titúlo: " + super.getTitulo() + ". Descrição: " +
	super.getDescricao() + "}";
	}

	
	
}
