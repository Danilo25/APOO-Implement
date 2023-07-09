package view;

import java.util.Scanner;

import model.Vereador;

public class AutenticacaoVereador {

	private Vereador vereadorAuth;
	private String token;
	public Vereador getVereadorAuth() {
		return vereadorAuth;
	}
	public void setVereadorAuth(Vereador vereadorAuth) {
		this.vereadorAuth = vereadorAuth;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	
	public Vereador cadastrar(Scanner scanner) {
		vereadorAuth.setToken(scanner.nextLine());
		return vereadorAuth;		
	}
	
	public Vereador login() {
		return vereadorAuth;
	}
	
}
