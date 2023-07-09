package model;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class CidadaoDAO {
	
	private ArrayList<Cidadao> Cidadaos;
	
	private static CidadaoDAO cDao;
	
	private CidadaoDAO() {
		Cidadaos = new ArrayList<Cidadao>();
		File bancoDadosCidadao = new File("C:/Users/*****/eclipse-workspace/Natal_Participa/src/BDCidadao.txt");
		String input = "";
		String[] auth;
		try {
			Scanner scanner = new Scanner(bancoDadosCidadao);
			while(scanner.hasNextLine()) {
				input = scanner.nextLine();
				auth = input.split(";");
				Cidadao c = new Cidadao(auth[0], auth[1], Integer.parseInt(auth[2]), auth[3]);
				create(c);
			}
				scanner.close();
		} catch(FileNotFoundException e) {
			e.printStackTrace();
		}
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
