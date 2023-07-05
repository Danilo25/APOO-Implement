package view;

import model.Proposta;

public class FormularioDenuncia {
	private Proposta propostaDenunciada;
	private String motivo;
	
	public Proposta getPropostaDenunciada() {
		return propostaDenunciada;
	}
	public void setPropostaDenunciada(Proposta propostaDenunciada) {
		this.propostaDenunciada = propostaDenunciada;
	}
	public String getMotivo() {
		return motivo;
	}
	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}
	
}
