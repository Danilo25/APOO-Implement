package model;

import java.util.ArrayList;

public class CidadaoDAO {
	
	private ArrayList<Cidadao> Cidadaos;
	
	private static CidadaoDAO cDao;
	
	private CidadaoDAO() {
		Cidadaos = new ArrayList<Cidadao>();
	}
	
	public static CidadaoDAO getInstance() {
		if(cDao == null) {
			cDao = new CidadaoDAO();
		}
		return cDao;
	}
	
	public void create(Cidadao c) {
		Cidadaos.add(c);
	}
	
	public void delete(Cidadao c) {
		Cidadaos.remove(c);
	}
	
	public ArrayList<Cidadao> findAll() {
		return Cidadaos;	
	}
	
	public Cidadao findById(String id) {
		Cidadao cidadao = null;
		for(Cidadao c : Cidadaos) {
			if(c.getCpf().equals(id)) {
				cidadao = c;
			}
		}
		return cidadao;
	}
}
