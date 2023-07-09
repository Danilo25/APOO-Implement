package view;

import java.util.Scanner;

import control.ControladorProjeto;
import control.ControladorProposta;
import model.CidadaoDAO;
import model.Projeto;
import model.Proposta;
import model.VereadorDAO;

public class NatalParticipaView {

	public static void main(String[] args) {
		
		CidadaoDAO cDao = CidadaoDAO.getInstance();
		VereadorDAO vDao = VereadorDAO.getInstance();
//		Cidadao c1 = new Cidadao("Charlie", "15220693727", 22, "senha123");
//		cDao.create(c1);
		
		
		Scanner scanner = new Scanner(System.in);
		System.out.print("Deseja acessar o perfil de vereador (PV) ou a Central do Cidadão (CC): ");
		String tela = scanner.nextLine();
		if(tela.equalsIgnoreCase("PV")){
			ControladorProjeto cpj = ControladorProjeto.getInstance();
			boolean auth = false;
			String cpf = null;
			String senha;
			
			while(auth != true) {
				System.out.println("##### LOGIN #####");
				System.out.print("Insira seu CPF (sem pontuação): ");
				cpf = scanner.nextLine();
				System.out.print("Insira sua senha: ");
				senha = scanner.nextLine();
				if(vDao.findById(cpf).getSenha().equals(senha))
					auth = true;
				else
					System.out.println("Nome ou senha inválido!");
			}
			AutenticacaoVereador av =  new AutenticacaoVereador();
			av.setVereadorAuth(vDao.findById(cpf));
			System.out.println("Olá " + av.getVereadorAuth().getNome() + "!");
			while(true) {
				System.out.println("O que deseja fazer?");
				System.out.print("Cadastrar Projeto (CP), Buscar Pojeto (BP), Listar Projetos (LP), Encerrar Sessão (Logout): ");
				String action = scanner.nextLine();
				if(action.equalsIgnoreCase("cp")) {
					cpj.CadastrarProjeto(scanner, av.getVereadorAuth());
				}
				else if(action.equalsIgnoreCase("bp")) {
					System.out.print("Insira o título da proposta que o projeto acompanha: ");
					Projeto projetoSelecionado = cpj.getProjeto(scanner.nextLine(), av.getVereadorAuth());
					System.out.println("Projeto: " + projetoSelecionado.getProposta().getTitulo());
					System.out.println("Custo estimado: " + projetoSelecionado.getCustoEstimado());
					if(projetoSelecionado!= null) {
						System.out.println("O que deseja fazer com a proposta selecionada?");
						System.out.print("Editar Projeto (EdP), Excluir Projeto (ExP): ");
						action = scanner.nextLine();
						if(action.equalsIgnoreCase("edp")) {
							System.out.println("Funcionalidade indisponível.");
						}
						else if(action.equalsIgnoreCase("exp")) {
							System.out.println("Tem certeza que deseja excluir esse projeto (S/N): ");
							if(scanner.nextLine().equalsIgnoreCase("s"))
								cpj.removeProjeto(projetoSelecionado);
						}
					}
				}
				else if(action.equalsIgnoreCase("lp")) {
					for(Projeto pj : cpj.getProjetos(av.getVereadorAuth())) {
						System.out.println("#" + pj.getProposta().getTitulo() + ";");
					}
				}
				else if(action.equalsIgnoreCase("logout")) {
					break;
				}
				
			}
			scanner.close();
			System.out.println("Até mais!");
		}
		if(tela.equalsIgnoreCase("CC")) {
			ControladorProposta cp = ControladorProposta.getInstance();
			boolean auth = false;
			String cpf = null;
			String senha;
			
			while(auth != true) {
				System.out.println("##### LOGIN #####");
				System.out.print("Insira seu CPF (sem pontuação): ");
				cpf = scanner.nextLine();
				System.out.print("Insira sua senha: ");
				senha = scanner.nextLine();
				if(cDao.findById(cpf).getSenha().equals(senha))
					auth = true;
				else
					System.out.println("Nome ou senha inválido!");
			}
			
			TelaInicial ti = new TelaInicial();
			ti.setUsuarioAuth(cDao.findById(cpf));
			
			System.out.println("Olá " + ti.getUsuarioAuth().getNome() + "!");
			while(true) {
				System.out.println("O que deseja fazer?");
				System.out.print("Enviar Proposta (EP), Buscar Proposta (BP), Listar Propostas (LP), Encerrar Sessão (Logout): ");
				String action = scanner.nextLine();
				if(action.equalsIgnoreCase("ep")) {
					cp.CadastrarProposta(scanner, ti.getUsuarioAuth());
				}
				else if(action.equalsIgnoreCase("bp")) {
					System.out.print("Insira o título da proposta que deseja buscar: ");
					Proposta propostaSelecionada = cp.getProposta(scanner.nextLine());
					System.out.println("Título: " + propostaSelecionada.getTitulo());
					System.out.println("Descrição: " + propostaSelecionada.getDescricao());
					System.out.println("Locais Atingidos: " + propostaSelecionada.getLocaisAtingidos());
					System.out.println("Público Alvo: " + propostaSelecionada.getPublicoAlvo());
					System.out.println("Categoria: " + propostaSelecionada.getCategoria());
					if(propostaSelecionada!= null) {
						System.out.println("O que deseja fazer com a proposta selecionada?");
						System.out.print("Acompanhar Proposta (AP), Denunciar Proposta (DP), Votar Proposta (VP): ");
						action = scanner.nextLine();
						if(action.equalsIgnoreCase("ap")) {
							ti.acompanharProposta(propostaSelecionada.getTitulo());
						}
						else if(action.equalsIgnoreCase("dp")) {
							cp.denunciarProposta(propostaSelecionada, scanner, ti.getUsuarioAuth());
						}
						else if(action.equalsIgnoreCase("vp")) {
							cp.votarProposta(propostaSelecionada.getTitulo(), ti.getUsuarioAuth().getCpf());
						}
					}
				}
				else if(action.equalsIgnoreCase("lp")) {
					System.out.print("Selecione um setor (Segurança, Urbanismo, Lazer, Projetos Sociais): ");
					for(Proposta p : cp.getByCategoria(scanner.nextLine())) {
						System.out.println("#" + p.getTitulo() + ";");
					}
				}
				else if(action.equalsIgnoreCase("logout")) {
					break;
				}
				
			}
			scanner.close();
			System.out.println("Até mais!");
		}
		
	}

}
