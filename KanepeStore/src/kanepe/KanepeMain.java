package kanepe;

import java.util.ArrayList;
import java.util.Scanner;

public class KanepeMain {

	private static final String NOMEADM = "LoginADM";
	private static final String SENHAADM = "SenhaADM";

	public static void main(String[] args) {
		ArrayList<Usuario> novoCadastro = new ArrayList<>();
		Scanner leitura = new Scanner(System.in);
		Integer opcao = Integer.MAX_VALUE;

		while (opcao != 4) {
			opcao = menu1();

			switch (opcao) {
			case 1: {
				novoCadastro.add(cadastro());
			}
				break;
			case 2: {
				if (loginADM()) {
					System.out.println("Login ADM bem-sucedido!");
				} else {
					System.out.println("Login ADM falhou.");
				}
			}
				break;
			case 3: {
				Usuario usuarioLogado = login(novoCadastro);
				if (usuarioLogado != null) {
					System.out.println("Login bem-sucedido para: " + usuarioLogado.getNome());
				} else {
					System.out.println("Nome de usuário ou senha incorretos.");
				}

			}
				break;
			case 4: {
				System.out.println("Programa encerrado!");

			}
				break;
			}

		}

	}
//	----------------------------------MENUS-----------------------------------------------------------------------

//	===================================MENUPRINCIPAL==============================================================
	private static Integer menu1() {

		System.out.println("BEM VINDO A KANEPE\n");
		System.out.println("1 - Cadastrar");
		System.out.println("2 - LogarADM");
		System.out.println("3 - Logar");
		System.out.println("4 - Sair\n");
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
	    
	    if(nomeUsuarioADM.equals(NOMEADM)&&senhaADM.equals(SENHAADM)) {
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
	    
		return loginValido ? true : false;
	}

}
