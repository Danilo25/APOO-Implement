package view;

import java.util.ArrayList;

import control.ControladorProposta;
import model.Cidadao;
import model.Proposta;

public class TelaInicial {
	private Cidadao usuarioAuth;
	ControladorProposta cp = ControladorProposta.getInstance();

	public Cidadao getUsuarioAuth() {
		return usuarioAuth;
	}

	public void setUsuarioAuth(Cidadao usuarioAuth) {
		this.usuarioAuth = usuarioAuth;
	}
	
	public Proposta buscarProposta(String id) {
		return cp.getProposta(id);
	}
	
	public ArrayList<Proposta> listarPropostas(){
		return cp.getPropostas();
	}
	
	public void acompanharProposta(String id) {
		if(cp.acompanharProposta(usuarioAuth, id)) {
			System.out.println("Proposta adicionada aos acompanhamentos!");
		}
		else
			System.out.println("Proposta já está sendo acompanhada!");
	}

}
