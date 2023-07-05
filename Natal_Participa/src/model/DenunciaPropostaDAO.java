package model;

import java.util.ArrayList;

public class DenunciaPropostaDAO {

	private ArrayList<DenunciaProposta> DenunciaPropostas;
	
	private static DenunciaPropostaDAO dpDao;
	
	private DenunciaPropostaDAO() {
		DenunciaPropostas = new ArrayList<DenunciaProposta>();
	}
		
	
	public static DenunciaPropostaDAO getInstance() {
		if(dpDao == null) {
			dpDao = new DenunciaPropostaDAO();
		}
		return dpDao;
	}
	
	
	public void create(DenunciaProposta dp) {
		DenunciaPropostas.add(dp);
	}

	public void delete(DenunciaProposta dp) {
		DenunciaPropostas.remove(dp);
	}
	
	public DenunciaProposta findById(String titulo) {
		DenunciaProposta DP = null;
		for(DenunciaProposta dp : DenunciaPropostas) {
			if(dp.getProposta().getTitulo().equalsIgnoreCase(titulo)) {
				DP = dp;
			}				
		}
		return DP;
	}

}
