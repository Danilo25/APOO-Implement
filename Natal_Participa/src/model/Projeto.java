package model;

public class Projeto {

	private Proposta proposta;
	private Vereador responsavel;
	private double custoEstimado;
	public Projeto(Proposta proposta, Vereador responsavel, double custoEstimado) {
		this.proposta = proposta;
		this.responsavel = responsavel;
		this.custoEstimado = custoEstimado;
	}
	public Proposta getProposta() {
		return proposta;
	}
	public void setProposta(Proposta proposta) {
		this.proposta = proposta;
	}
	public Vereador getResponsavel() {
		return responsavel;
	}
	public void setResponsavel(Vereador responsavel) {
		this.responsavel = responsavel;
	}
	public double getCustoEstimado() {
		return custoEstimado;
	}
	public void setCustoEstimado(double custoEstimado) {
		this.custoEstimado = custoEstimado;
	}
	
}
