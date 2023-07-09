package control;

import java.util.ArrayList;
import java.util.Scanner;

import model.ProjetoDAO;
import model.Proposta;
import model.Vereador;
import model.Projeto;

public class ControladorProjeto {
	private static ProjetoDAO pjDao;
	
	private static ControladorProjeto cPj;
	
	private ControladorProjeto() {
		pjDao = ProjetoDAO.getInstance();
	}
	
	public static ControladorProjeto getInstance() {
		if(cPj == null) {
			cPj = new ControladorProjeto();
		}
		return cPj;
	}	
	
	public boolean CadastrarProjeto(Scanner scanner, Vereador responsavel) {
		System.out.print("Proposta: ");
		Proposta p = ControladorProposta.getInstance().getProposta(scanner.nextLine());
		Projeto newProjeto = new Projeto(p, responsavel, 0);
		pjDao.create(newProjeto);
		System.out.println("Proposta enviada com sucesso!");
		return true;
	}
	
	public Projeto getProjeto(String id, Vereador responsavel) {
		Projeto P = null;
		for(Projeto p : pjDao.findAll()) {
			if(p.getResponsavel() == responsavel && id.equalsIgnoreCase(p.getProposta().getTitulo())) {
				P = p; 
			}
		}
		return P;
	}
	
	public ArrayList<Projeto> getProjetos(Vereador responsavel){
		return pjDao.findAllByResponsavel(responsavel);
	}

	public void removeProjeto(Projeto projetoSelecionado) {
		pjDao.delete(projetoSelecionado);
	}
	
}
