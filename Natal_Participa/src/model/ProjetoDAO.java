package model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import control.ControladorProposta;

public class ProjetoDAO {
	
	private static ArrayList<Projeto> Projetos;
	private static boolean inicialRead = true; 
	
	private static ProjetoDAO pjDao;
	
	private ProjetoDAO() {
		Projetos = new ArrayList<Projeto>();
		File bancoDadosProjeto = new File("C:/Users/*****/eclipse-workspace/Natal_Participa/src/BDProjeto.txt");
		String input = "";
		String[] auth;
		try {
			Scanner scanner = new Scanner(bancoDadosProjeto);
			while(scanner.hasNextLine()) {
				input = scanner.nextLine();
				auth = input.split(";");
				Proposta pp = null;
				try {
					pp = ControladorProposta.getInstance().getProposta(auth[0]);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				Vereador v = null;
				try {
					v = VereadorDAO.getInstance().findById(auth[1]);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}				
				Projeto pj = new Projeto(pp, v, 0);
				create(pj);
			}
				scanner.close();
		} catch(FileNotFoundException e) {
			e.printStackTrace();
		}
		inicialRead = false;
	}
	
	public static ProjetoDAO getInstance() {
		if(pjDao == null) {
			pjDao = new ProjetoDAO();
		}
		return pjDao;
	}
	
	public void create(Projeto pj) {
		Projetos.add(pj);
		if(!inicialRead) {
			String input = null;
			StringBuffer sb = new StringBuffer();
			try {
				Scanner scanner = new Scanner(new File("C:/Users/*****/eclipse-workspace/Natal_Participa/src/BDProjeto.txt"));
				while(scanner.hasNextLine()) {
					input = scanner.nextLine();
					sb.append(input + "\r\n");
				}
				sb.append(pj.getProposta().getTitulo() + ";" + pj.getResponsavel().getCpf() + ";" + pj.getCustoEstimado());
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			String addProjeto = sb.toString();
			try {
				FileWriter BDP = new FileWriter("C:/Users/*****/eclipse-workspace/Natal_Participa/src/BDProjeto.txt");
				BDP.append(addProjeto);
				BDP.flush();
				BDP.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				
			}
		}
	}
	
	public void delete(Projeto pj) {
		String input = null;
		StringBuffer sb = new StringBuffer();
		try {
			Scanner scanner = new Scanner(new File("C:/Users/*****/eclipse-workspace/Natal_Participa/src/BDProjeto.txt"));
			while(scanner.hasNextLine()) {
				input = scanner.nextLine();
				sb.append(input + "\r\n");
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String delProjeto = sb.toString();
		delProjeto = delProjeto.replaceAll(pj.getProposta().getTitulo() + ";" + pj.getResponsavel().getCpf() + ";" + pj.getCustoEstimado(), "");
		try {
			FileWriter BDP = new FileWriter("C:/Users/carlu/eclipse-workspace/Natal_Participa/src/BDProjeto.txt");
			BDP.append(delProjeto);
			BDP.flush();
			BDP.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Projetos.remove(pj);		
	}
	
	public ArrayList<Projeto> findAll(){
		return Projetos;
	}
	
	public ArrayList<Projeto> findAllByStatus(String status){
		ArrayList<Projeto> projetos = new ArrayList<Projeto>();
		for(Projeto pj : Projetos) {
			if(pj.getProposta().getStatus().equalsIgnoreCase(status)) {
				projetos.add(pj);
			}
		}
		return projetos;
	}
	
	public ArrayList<Projeto> findAllByResponsavel(Vereador responsavel){
		ArrayList<Projeto> projetos = new ArrayList<Projeto>();
		for(Projeto pj : Projetos) {
			if(pj.getResponsavel() == responsavel) {
				projetos.add(pj);
			}
		}
		return projetos;
	}

}
