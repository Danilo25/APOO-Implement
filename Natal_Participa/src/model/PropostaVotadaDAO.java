package model;

import java.util.ArrayList;

public class PropostaVotadaDAO {
	
	private ArrayList<PropostaVotada> PropostasVotadas;
	private static PropostaVotadaDAO pvDao;
	
	private PropostaVotadaDAO() {
		PropostasVotadas = new ArrayList<PropostaVotada>();
	}
	
	public static PropostaVotadaDAO getInstance() {
		if(pvDao == null) {
			pvDao = new PropostaVotadaDAO();
		}
		return pvDao;
	}
	
	public void create(PropostaVotada pv) {
		PropostasVotadas.add(pv);
	}
	
	public void delete(PropostaVotada pv) {
		PropostasVotadas.remove(pv);
	}
	
	public ArrayList<PropostaVotada> findAll() {
		return PropostasVotadas;
	}

}
