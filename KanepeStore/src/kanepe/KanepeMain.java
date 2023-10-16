package kanepe;

import java.util.ArrayList;
import java.util.Scanner;

public class KanepeMain {

	private static final String NOMEADM = "LoginADM";
	private static final String SENHAADM = "SenhaADM";
	private static ArrayList<Estoque> listaItens = new ArrayList<>();
	private static ArrayList<Usuario> novoCadastro = new ArrayList<>();

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
				} else {
					System.out.println("Nome de usuário ou senha incorretos.");
				}

			}
				break;
			case 3: {
				System.out.println("Programa encerrado!");

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
				listaItens.add(adicionarItem());

			}
				break;
			case 1: {
				Boolean removido = removerItem();
				if (removido.equals(false)) {
					System.out.println("Item inexistente!");
				} else {
					System.out.println("Removido com sucesso!");
				}
			}
				break;
			case 2: {
				Boolean alterado = alterarItem();
				if (alterado.equals(false)) {
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
			}

		}

		return opcao;
	}

//	====================================MenuUsuario================================================================

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
	private static Estoque adicionarItem() {
		Scanner leitura = new Scanner(System.in);
		Estoque item = new Estoque();

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

		for (Estoque item : listaItens) {
			if (id == item.getId()) {
				listaItens.remove(item);
				return true;
			}
		}

		return false;
	}

// =================================================Alterar===============================================================	
	private static boolean alterarItem() {
		Scanner leitura = new Scanner(System.in);

		System.out.println("Digite o ID do item que deseja ser alterado:");
		Integer id = Integer.valueOf(leitura.nextLine());

		for (Estoque item : listaItens) {
			if (id.equals(item.getId())) {
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
					break;
				default:
					break;
				}

				return true;
			}
		}

		return false;
	}

// =================================================Listar===============================================================
	private static Estoque listarItens() {

		System.out.println("Todos os itens do Estoque");
		Integer i = 1;
		for (Estoque estoque : listaItens) {

			System.out.println("Nome do item " + i + ": " + estoque.getNome());
			System.out.println("Id do item " + i + ": " + estoque.getId());
			System.out.println("Tipo do item " + i + ": " + estoque.getTipoProduto());
			System.out.println("Espécie do item " + i + ": " + estoque.getEspecie());
			System.out.println("Validade do item " + i + ": " + estoque.getValidade());
			System.out.println("Preço do item " + i + ": " + estoque.getPreco() + "\n");
			i++;

		}
		return null;
	}

}