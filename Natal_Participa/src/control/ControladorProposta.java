package control;

import java.util.ArrayList;
import java.util.Scanner;

import model.Cidadao;
import model.DenunciaProposta;
import model.DenunciaPropostaDAO;
import model.Proposta;
import model.PropostaDAO;
import model.PropostaVotada;
import model.PropostaVotadaDAO;
import view.FormularioProposta;
import view.FormularioDenuncia;

public class ControladorProposta {
	private static PropostaDAO pDao;
	private static PropostaVotadaDAO pvDao;
	private static DenunciaPropostaDAO dpDao;
	
	private static ControladorProposta cP;
	
	private ControladorProposta() {
		pDao = PropostaDAO.getInstance();
		pvDao = PropostaVotadaDAO.getInstance();
		dpDao = DenunciaPropostaDAO.getInstance();
		System.out.println("CP instanciado!");
	}
	
	public static ControladorProposta getInstance() {
		if(cP == null) {
			cP = new ControladorProposta();
		}
		return cP;
	}
	
	public boolean CadastrarProposta(Scanner scanner, Cidadao usuarioAuth) {
		FormularioProposta fp = new FormularioProposta();
		System.out.print("Título: ");
		fp.setTitulo(scanner.nextLine());
		System.out.print("Descrição: ");
		fp.setDescricao(scanner.nextLine());
		System.out.print("Locais Atingidos: ");
		fp.setLocaisAtingidos(scanner.nextLine());
		System.out.print("Categoria: ");
		fp.setCategoria(scanner.nextLine());
		System.out.print("Público Alvo: ");
		fp.setPublicoAlvo(scanner.nextLine());
		for(Proposta p : pDao.findAllByTitle(fp.getTitulo())) {
			if(p.getTitulo().equalsIgnoreCase(fp.getTitulo())) {
				System.out.println("Proposta já existe!");
				return false;
			}
		}
		Proposta newProposta = new Proposta(fp.getTitulo(), fp.getDescricao(), fp.getLocaisAtingidos(), fp.getCategoria(), fp.getPublicoAlvo(), "A definir", usuarioAuth, "ativo");
		pDao.create(newProposta);
		System.out.println("Proposta enviada com sucesso!");
		return true;
	}
	
	public Proposta getProposta(String id) {
		Proposta P = null;
		for(Proposta p : pDao.findAll()) {
			if(id.equalsIgnoreCase(p.getTitulo())) {
				P = p; 
			}
		}
		return P;
	}
	
	public ArrayList<Proposta> getPropostas(){
		return pDao.findAll();
	}
	
	public ArrayList<Proposta> getByCategoria(String categoria){
		return pDao.findAllByTitle(categoria);
	}
	
	public boolean acompanharProposta(Cidadao c, String id) {
		if(c.getPropostasAcompanhadas() != null) {
			for(Proposta p : c.getPropostasAcompanhadas()) {
				if(p.getTitulo().equalsIgnoreCase(id))
					return false;
			}
		}
		c.getPropostasAcompanhadas().add(getProposta(id));
		return true;
	}
	
	public boolean votarProposta(String idP, String ipC) {
		for(PropostaVotada pv : pvDao.findAll()) {
			if(pv.getIdProposta() == idP) {
				if(pv.getIdCidadao() == ipC) {
					return false;
				}
			}
		}
		PropostaVotada PV = new PropostaVotada(idP, ipC);
		pvDao.create(PV);
		return true;
	}
	
	public boolean denunciarProposta(Proposta proposta, Scanner scanner, Cidadao denunciante) {
		FormularioDenuncia fd = new FormularioDenuncia();
		fd.setPropostaDenunciada(proposta);
		System.out.print("Por favor explique o motivo da denúncia: ");
		fd.setMotivo(scanner.nextLine());
		if(dpDao.findById(proposta.getTitulo()).getDenunciante().getCpf().equals(denunciante.getCpf())) {
			return false;
		}
		DenunciaProposta DP = new DenunciaProposta(fd.getPropostaDenunciada(), fd.getMotivo(), denunciante);
		dpDao.create(DP);
		return true;
	}
}
