package model;

public class DenunciaProposta {
	
	private Proposta proposta;
	private String motivo;
	private Cidadao denunciante;
	public DenunciaProposta(Proposta proposta, String motivo, Cidadao denunciante) {
		super();
		this.proposta = proposta;
		this.motivo = motivo;
		this.denunciante = denunciante;
	}
	public Proposta getProposta() {
		return proposta;
	}
	public void setProposta(Proposta proposta) {
		this.proposta = proposta;
	}
	public String getMotivo() {
		return motivo;
	}
	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}
	public Cidadao getDenunciante() {
		return denunciante;
	}
	public void setDenunciante(Cidadao denunciante) {
		this.denunciante = denunciante;
	}
}
