package model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class VereadorDAO {

	private ArrayList<Vereador> Vereadores;
	private static boolean inicialRead = true;
	
	private static VereadorDAO vDao;
	
	private VereadorDAO() {
		Vereadores = new ArrayList<Vereador>();
		File bancoDadosVereador = new File("C:/Users/*****/eclipse-workspace/Natal_Participa/src/BDVereador.txt");
		String input = "";
		String[] auth;
		try {
			Scanner scanner = new Scanner(bancoDadosVereador);
			while(scanner.hasNextLine()) {
				input = scanner.nextLine();
				auth = input.split(";");
				Vereador v = new Vereador(auth[0], auth[1], auth[2], auth[3]);
				create(v);
			}
				scanner.close();
		} catch(FileNotFoundException e) {
			e.printStackTrace();
		}
	}
		
	public static VereadorDAO getInstance() {
		if(vDao == null) {
			vDao = new VereadorDAO();
		}
		return vDao;
	}
	
	public void create(Vereador v) {
		Vereadores.add(v);
		if(!inicialRead) {
			String input = null;
			StringBuffer sb = new StringBuffer();
			try {
				Scanner scanner = new Scanner(new File("C:/Users/*****/eclipse-workspace/Natal_Participa/src/BDVereador.txt"));
				while(scanner.hasNextLine()) {
					input = scanner.nextLine();
					sb.append(input + "\r\n");
				}
				sb.append(v.getNome() + ";" + v.getCpf() + ";" + v.getToken() + ";" + v.getSenha());
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			String addVereador = sb.toString();
			try {
				FileWriter BDV = new FileWriter("C:/Users/*****/eclipse-workspace/Natal_Participa/src/BDVereador.txt");
				BDV.append(addVereador);
				BDV.flush();
				BDV.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				
			}
		}
	}
	
	public void delete(Vereador v) {
		Vereadores.remove(v);
	}
	
	public ArrayList<Vereador> findAll() {
		return Vereadores;	
	}
	
	public Vereador findById(String id) {
		Vereador V = null;
		for(Vereador v : Vereadores) {
			if(v.getCpf().equals(id)) {
				V = v;
			}
		}
		return V;
	}
}
