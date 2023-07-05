package model;

import java.util.ArrayList;

public class PropostaDAO {

	private static ArrayList<Proposta> Propostas;
	
	private static PropostaDAO pDao;
	
	private PropostaDAO() {
		Propostas = new ArrayList<Proposta>();
	}
	
	public static PropostaDAO getInstance() {
		if(pDao == null) {
			pDao = new PropostaDAO();
		}
		return pDao;
	}
	
	public void create(Proposta p) {
		Propostas.add(p);
	}
	
	public void delete(Proposta p) {
		Propostas.remove(p);
	}
	
	public ArrayList<Proposta> findAll(){
		return Propostas;
	}
	
	public ArrayList<Proposta> findAllByTitle(String titulo){
		ArrayList<Proposta> propostas = new ArrayList<Proposta>();
		for(Proposta p : Propostas) {
			if(p.getTitulo().equalsIgnoreCase(titulo)) {
				propostas.add(p);
			}
		}
		return propostas;
	}
	
	public ArrayList<Proposta> findAllByCategoria(String categoria){
		ArrayList<Proposta> propostas = new ArrayList<Proposta>();
		for(Proposta p : Propostas) {
			if(p.getCategoria().equalsIgnoreCase(categoria)) {
				propostas.add(p);
			}
		}
		return propostas;
	}
}
