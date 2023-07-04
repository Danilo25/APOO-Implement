package DAO;

import java.util.ArrayList;
import java.util.Iterator;

import Entity.Cidadao;

public class CidadaoDAOImple {
	
	public ArrayList<Cidadao> cidadoes = new ArrayList<>();
	
	public void create(Cidadao cidadao) {

		if(findByCPF(cidadao.getCpf())==null) {
			System.out.println(cidadao.getNome() + " | " + cidadao.getCpf() + " | " + cidadao.getIdade() + " | ");
			cidadoes.add(cidadao);
		}else {
			System.out.println("CPF já está cadastrado");
		}
	}
	
	public Cidadao findByCPF(int cpf) {
		Iterator it = cidadoes.iterator();

	    while (it.hasNext()) {
	        Cidadao pTemp = (Cidadao) it.next();
	        if(pTemp.getCpf() == cpf) {
	        	return pTemp;
	        }
	    }
		return null;
	}
	
	//Adicionar chamada ao arquivo com os cidadoes
	public ArrayList<Cidadao> getAll(){
		
		return cidadoes;
	}
	
	public void remove(Cidadao cidadao) {
		if(findByCPF(cidadao.getCpf()) != null) {
			cidadoes.remove(cidadao);
		}
	}
}
