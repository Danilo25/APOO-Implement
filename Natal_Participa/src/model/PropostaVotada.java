package model;

public class PropostaVotada {

	private String idProposta;
	private String idCidadao;
	public PropostaVotada(String idProposta, String idCidadao) {
		this.idProposta = idProposta;
		this.idCidadao = idCidadao;
	}
	public String getIdProposta() {
		return idProposta;
	}
	public void setIdProposta(String idProposta) {
		this.idProposta = idProposta;
	}
	public String getIdCidadao() {
		return idCidadao;
	}
	public void setIdCidadao(String idCidadao) {
		this.idCidadao = idCidadao;
	}
	
}
