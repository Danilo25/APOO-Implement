package DAO;

import Entity.Cidadao;

public class CidadaoDAOImple {
	public void create(Cidadao cidadao) {
		if(findById(cidadao)==false) {
			System.out.println(cidadao.getNome() + " | " + cidadao.getCpf() + " | " + cidadao.getIdade() + " | ");
		}
	}
	
	public boolean findById(Cidadao cidadao) {
		return false;
	}
}
