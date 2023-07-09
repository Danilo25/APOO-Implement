package model;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;

public class PropostaDAO {

	private static ArrayList<Proposta> Propostas;
	private static boolean inicialRead = true; 
	
	private static PropostaDAO pDao;
	
	private PropostaDAO() {
		System.out.println("PropostaDAO (1) instanciado!");
		Propostas = new ArrayList<Proposta>();
		File bancoDadosProposta = new File("C:/Users/carlu/eclipse-workspace/Natal_Participa/src/BDProposta.txt");
		String input = "";
		String[] auth;
		try {
			Scanner scanner = new Scanner(bancoDadosProposta);
			while(scanner.hasNextLine()) {
				input = scanner.nextLine();
				auth = input.split(";");
				Proposta p = new Proposta(auth[0], auth[1], auth[2], auth[3], auth[4], auth[5], null, auth[7]);
				Cidadao c = null;
				try {
					c = CidadaoDAO.getInstance().findById(auth[6]);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				p.setCidadao(c);
				create(p);
			}
				scanner.close();
		} catch(FileNotFoundException e) {
			e.printStackTrace();
		}
		inicialRead = false;
		System.out.println("PropostaDAO (2) instanciado!");
	}
	
	public static PropostaDAO getInstance() {
		if(pDao == null) {
			pDao = new PropostaDAO();
		}
		return pDao;
	}
	
	public void create(Proposta p) {
		Propostas.add(p);
		if(!inicialRead) {
			String input = null;
			StringBuffer sb = new StringBuffer();
			try {
				Scanner scanner = new Scanner(new File("C:/Users/carlu/eclipse-workspace/Natal_Participa/src/BDProposta.txt"));
				while(scanner.hasNextLine()) {
					input = scanner.nextLine();
					sb.append(input + "\r\n");
				}
				sb.append(p.getTitulo() + ";" + p.getDescricao() + ";" + p.getLocaisAtingidos() + ";" + p.getCategoria() + ";" + p.getPublicoAlvo() + ";" + p.getValidade() + ";" + p.getCidadao().getCpf() + ";" + p.getStatus());
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			String addProposta = sb.toString();
			try {
				FileWriter BDP = new FileWriter("C:/Users/carlu/eclipse-workspace/Natal_Participa/src/BDProposta.txt");
				BDP.append(addProposta);
				BDP.flush();
				BDP.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				
			}
		}
	}
	
	public void delete(Proposta p) {
		String input = null;
		StringBuffer sb = new StringBuffer();
		try {
			Scanner scanner = new Scanner(new File("C:/Users/carlu/eclipse-workspace/Natal_Participa/src/BDProposta.txt"));
			while(scanner.hasNextLine()) {
				input = scanner.nextLine();
				sb.append(input + "\r\n");
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String delProposta = sb.toString();
		delProposta = delProposta.replaceAll("\b" + p.getTitulo() + ";" + p.getDescricao() + ";" + p.getLocaisAtingidos() + ";" + p.getCategoria() + ";" + p.getPublicoAlvo() + ";" + p.getValidade() + ";" + p.getCidadao().getCpf() + ";" + p.getStatus() + "\b", "");
		try {
			FileWriter BDP = new FileWriter("C:/Users/carlu/eclipse-workspace/Natal_Participa/src/BDProposta.txt");
			BDP.append(delProposta);
			BDP.flush();
			BDP.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
