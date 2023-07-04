package Entity;

import java.util.Date;

public class Proposta {
	public String titulo;
	public String descricao;
	public String locaisA;
	public String categoria;
	public String publicoA;
	public Date data;
	public Cidadao cidadao;
	public String status;
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
	public String getLocaisA() {
		return locaisA;
	}
	public void setLocaisA(String locaisA) {
		this.locaisA = locaisA;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	public String getPublicoA() {
		return publicoA;
	}
	public void setPublicoA(String publicoA) {
		this.publicoA = publicoA;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
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
