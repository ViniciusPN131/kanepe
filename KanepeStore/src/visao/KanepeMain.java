package visao;

import java.util.ArrayList;
import java.util.Scanner;

import controle.PlantaDAO;
import modelo.Planta;
import modelo.Usuario;

public class KanepeMain {

	private static final String NOMEADM = "LoginADM";
	private static final String SENHAADM = "SenhaADM";
//	private static ArrayList<Planta> listaItens = new ArrayList<>();//	private static ArrayList<Usuario> novoCadastro = new ArrayList<>();
	
	
	
	private static ArrayList<Planta> carrinho = new ArrayList<>();
	
	
	private static PlantaDAO pDAO = PlantaDAO.getInstancia();

	public static void main(String[] args) {

		Scanner leitura = new Scanner(System.in);
		Integer opcao = Integer.MAX_VALUE;

		while (opcao != 3) {
			opcao = menu1();

			switch (opcao) {
			case 0: {
				novoCadastro.add(cadastro());
			}
				break;
			case 1: {
				if (loginADM()) {
					System.out.println("Login ADM bem-sucedido!");
					menuADM();

				} else {
					System.out.println("Login ADM falhou.");
				}

			}

				break;
			case 2: {
				Usuario usuarioLogado = login(novoCadastro);
				if (usuarioLogado != null) {
					System.out.println("Login bem-sucedido para: " + usuarioLogado.getNome());
					menuUser();

				} else {
					System.out.println("Nome de usuário ou senha incorretos.");
				}

			}
				break;
			case 3: {
				System.out.println("Programa encerrado!");

			}
				break;
			case 4: {

				menuADM();
			}
				break;
			default: {
				System.out.println("Opção invalida, tente novamente!");
			}
				break;
			}

		}

	}

//	====================================MenuADM================================================================
	private static Integer menuADM() {
		Integer opcao = 0;
		Scanner leitura = new Scanner(System.in);

		while (opcao != 4) {
			System.out.println("BEM VINDO A KANEPE\n");
			System.out.println("0 - Adcionar item");
			System.out.println("1 - Remover item");
			System.out.println("2 - Alterar item");
			System.out.println("3 - Listar item");
			System.out.println("4 - Sair\n");
			System.out.println("selecione a opção para continuar:");

			opcao = Integer.valueOf(leitura.nextLine());

			switch (opcao) {
			case 0: {
				pDAO.inserirPlanta(adicionarItem());

			}
				break;
			case 1: {
				Boolean removido = removerItem();
				if (!removido) {
					System.out.println("Item inexistente!");
				} else {
					System.out.println("Removido com sucesso!");
				}

//				pDAO.removerPlanta(removerItem());

			}
				break;
			case 2: {
				Boolean alterado = alterarItem();
				if (!alterado) {
					System.out.println("Item inexistente!");
				} else {
					System.out.println("Alterado com sucesso!");
				}
			}
				break;
			case 3: {
				listarItens();
			}
				break;
			case 4: {
				System.out.println("Voce escolheu sair!");
			}
				break;
			default: {
				System.out.println("Opção invalida, tente novamente!");
			}
				break;
			}

		}

		return opcao;

	}

//	====================================MenuUsuario================================================================
	private static Integer menuUser() {
		int opc = 0;
		Scanner leitura = new Scanner(System.in);
		while (opc != 3) {
			System.out.println("-------------------------------------");
			System.out.println("              KanepeStore            ");
			System.out.println("-------------------------------------");
			System.out.println("\nOpcoes de pesquisa: \n");
			System.out.println("0-Todos os itens do estoque");
			System.out.println("1-Por nome");
			System.out.println("2-Por tipo");
			System.out.println("3-sair");
			opc = Integer.valueOf(leitura.nextLine());

			switch (opc) {
			case 0: {
				int i = 1;

				for (Planta estoque : pDAO.listarPlanta()) {

					System.out.println("Nome do produto " + i + ": " + estoque.getNome());
					System.out.println("Id do produto " + i + ": " + estoque.getId());
					System.out.println("Tipo do produto " + i + ": " + estoque.getTipoProduto());
					System.out.println("Espécie do produto " + i + ": " + estoque.getEspecie());
					System.out.println("Validade do produto " + i + ": " + estoque.getValidade());
					System.out.println("Preço do produto " + i + ": " + estoque.getPreco());
					System.out.println();
					i++;

				}
				System.out.println("Fim do estoque!\n");
				System.out.println("Deseja adicionar um item ao carrinho?");
				String opc2 = leitura.nextLine();

				if (!opc2.equalsIgnoreCase("SIM")) {
					carrinho.add(adicionarCarrinho());
				}

			}
				break;
			case 1: {
				System.out.println("Digite o nome do produto: ");
				String nome = leitura.nextLine();
				int i = 1;

				for (Planta item : listaItens) {
					if (nome.equals(item.getNome())) {

						System.out.println("Nome do produto " + i + ": " + item.getNome());
						System.out.println("Id do produto " + i + ": " + item.getId());
						System.out.println("Tipo do produto " + i + ": " + item.getTipoProduto());
						System.out.println("Especie do produto " + i + ": " + item.getEspecie());
						System.out.println("Validade do produto " + i + ": " + item.getValidade());
						System.out.println("Preco do produto " + i + ": " + item.getPreco());
						System.out.println();
						i++;
					}
					System.out.println("Fim do estoque!\n");
					System.out.println("Deseja adicionar um item ao carrinho?");
					String opc2 = leitura.nextLine();

					if (!opc2.equalsIgnoreCase("SIM")) {
						carrinho.add(adicionarCarrinho());
					}
				}
			}
				break;
			case 2: {
				System.out.println("Digite o tipo do produto: ");
				String tipo = leitura.nextLine();
				int i = 1;

				for (Planta item : listaItens) {
					if (tipo.equals(item.getTipoProduto())) {

						System.out.println("Nome do produto " + i + ": " + item.getNome());
						System.out.println("Id do produto " + i + ": " + item.getId());
						System.out.println("Tipo do produto " + i + ": " + item.getTipoProduto());
						System.out.println("Especie do produto " + i + ": " + item.getEspecie());
						System.out.println("Validade do produto " + i + ": " + item.getValidade());
						System.out.println("Preco do produto " + i + ": " + item.getPreco());
						System.out.println();
						i++;
					}
					System.out.println("Fim do estoque!\n");
					System.out.println("Deseja adicionar um item ao carrinho?");
					String opc2 = leitura.nextLine();

					if (!opc2.equalsIgnoreCase("SIM")) {
						carrinho.add(adicionarCarrinho());
					}
				}
			}
				break;
			case 3: {
				System.out.println("Voce escolheu sair!");
			}
				break;
			default: {
				System.out.println("Opção invalida, tente novamente!");
			}
				break;

			}
		}

		return opc;

	}

//	----------------------------------MENUS-----------------------------------------------------------------------

//	===================================MENUPRINCIPAL==============================================================
	private static Integer menu1() {

		System.out.println("BEM VINDO A KANEPE\n");
		System.out.println("0 - Cadastrar");
		System.out.println("1 - LogarADM");
		System.out.println("2 - Logar");
		System.out.println("3 - Sair\n");
		System.out.println("selecione a opção para continuar:");

		Scanner leitura = new Scanner(System.in);

		Integer opcao = Integer.valueOf(leitura.nextLine());
		return opcao;

	}
//	====================================CADASTRO================================================================

	private static Usuario cadastro() {
		Usuario pessoa = new Usuario();
		Scanner leitura = new Scanner(System.in);

		boolean cadastroValido = false;

		while (!cadastroValido) {
			System.out.println("Digite o nome (8 ou mais caracteres)");
			String nome = leitura.nextLine();
			System.out.println("Digite a senha (8 ou mais caracteres)");
			String senha = leitura.nextLine();

			if (nome.length() >= 8 && senha.length() >= 8) {
				pessoa.setNome(nome);
				pessoa.setSenha(senha);

				System.out.println("Cadastro realizado com sucesso!");
				cadastroValido = true;
			} else {
				System.out.println("Cadastro inválido!\n");

				System.out.println("Deseja tentar novamente? (S/N)");
				String resposta = leitura.nextLine();

				if (!resposta.equalsIgnoreCase("S")) {
					break;
				}
			}
		}

		return pessoa;
	}

//	====================================login================================================================

	private static Usuario login(ArrayList<Usuario> novoCadastro) {
		Usuario pessoa = new Usuario();
		Scanner leitura = new Scanner(System.in);

		boolean loginValido = false;

		while (!loginValido) {
			System.out.println("Digite o nome de usuário:");
			String nomeUsuario = leitura.nextLine();
			System.out.println("Digite a senha:");
			String senha = leitura.nextLine();

			for (Usuario usuario : novoCadastro) {
				if (usuario.getNome().equals(nomeUsuario) && usuario.getSenha().equals(senha)) {
					loginValido = true;
					pessoa = usuario;
					break;
				}
			}

			if (!loginValido) {
				System.out.println("Nome de usuário ou senha incorretos. Deseja tentar novamente? (S/N)");
				String resposta = leitura.nextLine();

				if (!resposta.equalsIgnoreCase("S")) {
					break;
				}
			}
		}

		return loginValido ? pessoa : null;
	}

//	====================================LoginADM================================================================

	private static boolean loginADM() {
		Scanner leitura = new Scanner(System.in);
		String nomeUsuarioADM = "";
		String senhaADM = "";

		boolean loginValido = false;

		while (!loginValido) {
			System.out.println("Digite o nome de usuário ADM:");
			nomeUsuarioADM = leitura.nextLine();
			System.out.println("Digite a senha ADM:");
			senhaADM = leitura.nextLine();

			if (nomeUsuarioADM.equals(NOMEADM) && senhaADM.equals(SENHAADM)) {
				loginValido = true;
				break;
			}

			if (!loginValido) {
				System.out.println("Nome de usuário ou senha incorretos. Deseja tentar novamente? (S/N)");
				String resposta = leitura.nextLine();

				if (!resposta.equalsIgnoreCase("S")) {
					break;
				}
			}

		}

		return loginValido ? true : null;
	}

// =================================================Adcionar===============================================================
	private static Planta adicionarItem() {
		Scanner leitura = new Scanner(System.in);
		Planta item = new Planta();

		System.out.println("Digite o nome ");
		String nome = leitura.nextLine();
		System.out.println("Digite o id");
		Integer id = Integer.valueOf(leitura.nextLine());
		System.out.println("Digite o tipo");
		String tipoProtudo = leitura.nextLine();
		System.out.println("Digite a especie");
		String especie = leitura.nextLine();
		System.out.println("Digite a validade");
		String validade = leitura.nextLine();
		System.out.println("Digite o preco");
		Double opcao = Double.valueOf(leitura.nextLine());

		item.setNome(nome);
		item.setEspecie(especie);
		item.setId(id);
		item.setValidade(validade);
		item.setPreco(opcao);
		item.setTipoProduto(tipoProtudo);

		System.out.println("Adcioando com Sucesso");

		return item;
	}

// =================================================Remover===============================================================
	private static boolean removerItem() {
		Scanner leitura = new Scanner(System.in);

		System.out.println("Digite id od item que deseja ser apagado.");
		Integer id = Integer.valueOf(leitura.nextLine());

		boolean retorno = pDAO.removerPlanta(id);
		return retorno;

	}

// =================================================Alterar===============================================================	
	private static boolean alterarItem() {
		Scanner leitura = new Scanner(System.in);

		System.out.println("Digite o ID do item que deseja ser alterado:");
		Integer id = Integer.valueOf(leitura.nextLine());

		Planta item = pDAO.buscaPlantaPorId(id);

		System.out.println("Qual informação deseja alterar?");
		System.out.println("0 - Nome");
		System.out.println("1 - ID");
		System.out.println("2 - Tipo");
		System.out.println("3 - Espécie");
		System.out.println("4 - Validade");
		System.out.println("5 - Preço");
		System.out.println("6 - Todas as informações");
		int opc = Integer.valueOf(leitura.nextLine());

		switch (opc) {
		case 0:
			System.out.println("Digite o novo nome: ");
			String novoNome = leitura.nextLine();
			item.setNome(novoNome);
			break;
		case 1:
			System.out.println("Digite o novo ID: ");
			Integer novoId = Integer.valueOf(leitura.nextLine());
			item.setId(novoId);
			break;
		case 2:
			System.out.println("Digite o novo tipo: ");
			String novoTipo = leitura.nextLine();
			item.setTipoProduto(novoTipo);
			break;
		case 3:
			System.out.println("Digite a nova espécie: ");
			String novaEspecie = leitura.nextLine();
			item.setEspecie(novaEspecie);
			break;
		case 4:
			System.out.println("Digite a nova validade: ");
			String novaValidade = leitura.nextLine();
			item.setValidade(novaValidade);
			break;
		case 5:
			System.out.println("Digite o novo preço: ");
			Double novoPreco = Double.valueOf(leitura.nextLine());
			item.setPreco(novoPreco);
			break;
		case 6:
			System.out.println("Digite as novas informações:");
			System.out.println("Digite o novo nome: ");
			String novoNomeCompleto = leitura.nextLine();
			System.out.println("Digite o novo ID: ");
			Integer novoIdCompleto = Integer.valueOf(leitura.nextLine());
			System.out.println("Digite o novo tipo: ");
			String novoTipoCompleto = leitura.nextLine();
			System.out.println("Digite a nova espécie: ");
			String novaEspecieCompleto = leitura.nextLine();
			System.out.println("Digite a nova validade: ");
			String novaValidadeCompleto = leitura.nextLine();
			System.out.println("Digite o novo preço: ");
			Double novoPrecoCompleto = Double.valueOf(leitura.nextLine());

			item.setNome(novoNomeCompleto);
			item.setId(novoIdCompleto);
			item.setTipoProduto(novoTipoCompleto);
			item.setEspecie(novaEspecieCompleto);
			item.setValidade(novaValidadeCompleto);
			item.setPreco(novoPrecoCompleto);
			return pDAO.alterarPlanta(item);

		default: {
			System.out.println("Opção invalida, tente novamente!");
		}
			break;
		}

		return false;

	}

// =================================================Listar===============================================================
	private static Planta listarItens() {
		Scanner leitura = new Scanner(System.in);

		System.out.println("Opcoes de listagem: \n");
		System.out.println("0-Todos os itens do estoque");
		System.out.println("1-Por nome");
		System.out.println("2-Por tipo");
		System.out.println("3-por id");
		System.out.println("4-sair");
		Integer opc = Integer.valueOf(leitura.nextLine());

		switch (opc) {
		case 0: {
			int i = 1;

			for (Planta plantas : pDAO.listarPlanta()) {

				System.out.println("Nome do item " + i + ": " + plantas.getNome());
				System.out.println("Id do item " + i + ": " + plantas.getId());
				System.out.println("Tipo do item " + i + ": " + plantas.getTipoProduto());
				System.out.println("Espécie do item " + i + ": " + plantas.getEspecie());
				System.out.println("Validade do item " + i + ": " + plantas.getValidade());
				System.out.println("Preço do item " + i + ": " + plantas.getPreco());
				System.out.println();
				i++;

			}
			System.out.println("Fim da lista!");
			listarItens();
		}
			break;
		case 1: {
			System.out.println("Digite o nome do item: ");
			String nome = leitura.nextLine();
			int i = 1;

			for (Planta item : pDAO.listarPlanta()) {
				if (nome.equals(item.getNome())) {

					System.out.println("Nome do item " + i + ": " + item.getNome());
					System.out.println("Id do item " + i + ": " + item.getId());
					System.out.println("Tipo do item " + i + ": " + item.getTipoProduto());
					System.out.println("Especie do item " + i + ": " + item.getEspecie());
					System.out.println("Validade do item " + i + ": " + item.getValidade());
					System.out.println("Preco do item " + i + ": " + item.getPreco());
					System.out.println();
					i++;
				}
				System.out.println("Fim da lista!");
				listarItens();
			}
		}
			break;
		case 2: {
			System.out.println("Digite o tipo do item: ");
			String tipo = leitura.nextLine();
			int i = 1;

			for (Planta item : pDAO.listarPlanta()) {
				if (tipo.equals(item.getTipoProduto())) {

					System.out.println("Nome do item " + i + ": " + item.getNome());
					System.out.println("Id do item " + i + ": " + item.getId());
					System.out.println("Tipo do item " + i + ": " + item.getTipoProduto());
					System.out.println("Especie do item " + i + ": " + item.getEspecie());
					System.out.println("Validade do item " + i + ": " + item.getValidade());
					System.out.println("Preco do item " + i + ": " + item.getPreco());
					System.out.println();
					i++;
				}
				System.out.println("Fim da lista!");
				listarItens();
			}
		}
			break;
		case 3: {
			System.out.println("Digite o id do item: ");
			Integer id = Integer.valueOf(leitura.nextLine());
			int i = 1;

			for (Planta item : pDAO.listarPlanta()) {
				if (id.equals(item.getId())) {

					System.out.println("Nome do item " + i + ": " + item.getNome());
					System.out.println("Id do item " + i + ": " + item.getId());
					System.out.println("Tipo do item " + i + ": " + item.getTipoProduto());
					System.out.println("Especie do item " + i + ": " + item.getEspecie());
					System.out.println("Validade do item " + i + ": " + item.getValidade());
					System.out.println("Preco do item " + i + ": " + item.getPreco());
					System.out.println();
					i++;
				}
				System.out.println("Fim da lista!");
				listarItens();
			}
		}
			break;
		case 4: {
			System.out.println("Voce escolheu sair!");
		}
			break;
		default: {
			System.out.println("Opção invalida, tente novamente!");
		}
			break;

		}

		return null;
	}

//------------------------------------------adicionar ao carrinho----------------------------------------------------------

	private static Planta adicionarCarrinho() {

		Scanner leitura = new Scanner(System.in);

		System.out.println("Digite o ID do Produto pra ser adicionar ao Carrinho");
		Integer id = Integer.valueOf(leitura.nextLine());

		for (Planta item : pDAO.listarPlanta()) {
			if (id.equals(item.getId())) {

				System.out.println("Nome do produto " + item.getNome());
				System.out.println("Id do produto " + item.getId());
				System.out.println("Tipo do produto " + item.getTipoProduto());
				System.out.println("Especie do produto " + item.getEspecie());
				System.out.println("Validade do produto " + item.getValidade());
				System.out.println("Preco do produto " + item.getPreco());
				System.out.println();

				System.out.println("Este é o produto?(S/N)");
				String resposta = leitura.nextLine();

				if (resposta.equalsIgnoreCase("S")) {
					Planta itemCarrinho = new Planta();

					itemCarrinho.setNome(item.getNome());
					itemCarrinho.setEspecie(item.getEspecie());
					itemCarrinho.setId(item.getId());
					itemCarrinho.setValidade(item.getValidade());
					itemCarrinho.setPreco(item.getPreco());
					itemCarrinho.setTipoProduto(item.getTipoProduto());

					System.out.println("Item adicinado ao carrinho");
					return itemCarrinho;
				} else {
					System.out.println("Ok!");
				}

			}

		}

		return null;
	}

}
}
