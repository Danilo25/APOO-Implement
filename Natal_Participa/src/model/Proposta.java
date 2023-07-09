package model;

public class Proposta {

	private String titulo;
	private String descricao;
	private String locaisAtingidos;
	private String categoria;
	private String publicoAlvo;
	private String validade;
	private Cidadao cidadao;
	private String status;
	public Proposta(String titulo, String descricao, String locaisAtingidos, String categoria, String publicoAlvo,
			String validade, Cidadao cidadao, String status) {
		this.titulo = titulo;
		this.descricao = descricao;
		this.locaisAtingidos = locaisAtingidos;
		this.categoria = categoria;
		this.publicoAlvo = publicoAlvo;
		this.validade = validade;
		this.cidadao = cidadao;
		this.status = status;
		
		
	}
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
	public String getLocaisAtingidos() {
		return locaisAtingidos;
	}
	public void setLocaisAtingidos(String locaisAtingidos) {
		this.locaisAtingidos = locaisAtingidos;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	public String getPublicoAlvo() {
		return publicoAlvo;
	}
	public void setPublicoAlvo(String publicoAlvo) {
		this.publicoAlvo = publicoAlvo;
	}
	public String getValidade() {
		return validade;
	}
	public void setValidade(String validade) {
		this.validade = validade;
	}
	public Cidadao getCidadao() {
		return cidadao;
	}
	public void setCidadao(Cidadao cidadao) {
		this.cidadao = cidadao;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
}
