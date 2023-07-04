import DAO.CidadaoDAOImple;
import Entity.Cidadao;

public class Teste {

	public static void main(String[] args) {
		Cidadao cid1 = new Cidadao();
		cid1.setNome("Daniel da Silva Santos");
		cid1.setCpf(02150164311);
		cid1.setIdade(28);
		
		CidadaoDAOImple cadastros = new CidadaoDAOImple();
		cadastros.create(cid1);
		
		Cidadao cid2 = new Cidadao();
		cid2.setNome("Daniel da Silva Santos");
		cid2.setCpf(02150164311);
		cid2.setIdade(28);
		
		cadastros.create(cid2);
		

	}

}
