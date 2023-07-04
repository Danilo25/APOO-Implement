package DAO;

import java.util.ArrayList;

import Entity.Cidadao;

public interface CidadaoDAO extends Repository {
	
	public ArrayList<Cidadao> getAllCidadoes();
	
	public void create(Cidadao cidadao);
	public void update(Cidadao cidadao);
	public void delete(Cidadao cidadao);
	public boolean findById(String nome);
}
