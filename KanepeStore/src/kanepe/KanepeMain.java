package kanepe;

import java.util.ArrayList;
import java.util.Scanner;

public class KanepeMain {

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
			case 4: {
				opcao=4;
			}
			break;
			}

		}

	}
//	===================================MENUS======================================================================
	
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
		
		leitura.close();
		return opcao;
		
	}
//	====================================MENUCADASTRO================================================================
	
	private static Usuario cadastro() {
		Usuario pessoa = new Usuario();
		Scanner leitura = new Scanner(System.in);
		
		Integer lup = 1;
		
		while(lup!=0) {
		System.out.println("Digite o nome(8 ou mais caracteres)");
		String nome = leitura.nextLine();
		System.out.println("Digite a senha(8 ou mais caracteres)");
		String senha = leitura.nextLine();
		if(nome.length()>=8&&senha.length()>=8) {
			pessoa.setNome(nome);
			pessoa.setSenha(senha);
			
			System.out.println("Cadastro realizado com sucesso!");
			lup = 0;
			
		}else {
			System.out.println("Cadastro invalido!\n");
		}
		}
		return pessoa;
	}

}
