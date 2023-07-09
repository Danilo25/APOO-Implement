package model;

import java.util.ArrayList;

public class Cidadao {

	private String nome;
	private String cpf;
	private int idade;
	private String senha;
	private ArrayList<Proposta> propostasAcompanhadas;
	
	
	public Cidadao(String nome, String cpf, int idade, String senha) {
		this.nome = nome;
		this.cpf = cpf;
		this.idade = idade;
		this.senha = senha;
		this.propostasAcompanhadas = new ArrayList<Proposta>();
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
	
	public int getIdade() {
		return idade;
	}
	
	public void setIdade(int idade) {
		this.idade = idade;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public ArrayList<Proposta> getPropostasAcompanhadas() {
		return propostasAcompanhadas;
	}

	public void setPropostasAcompanhadas(ArrayList<Proposta> propostasAcompanhadas) {
		this.propostasAcompanhadas = propostasAcompanhadas;
	}
	
}
