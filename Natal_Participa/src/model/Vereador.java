package model;

public class Vereador {
	private String nome;
	private String cpf;
	private String token;
	private String senha;
	
	public Vereador(String nome, String cpf, String token, String senha) {
		this.nome = nome;
		this.cpf = cpf;
		this.token = token;
		this.senha = senha;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	

}
