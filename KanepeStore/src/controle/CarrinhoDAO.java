package controle;

import java.util.ArrayList;

import modelo.ICarrinhoDAO;
import modelo.Planta;

public class CarrinhoDAO implements ICarrinhoDAO{
	
	private static ArrayList<Planta> listaCarrinho;

	private static CarrinhoDAO instancia;

	public static CarrinhoDAO getInstancia() {

		if (instancia == null) {
			instancia = new CarrinhoDAO();
			listaCarrinho = new ArrayList<>();
		}

		return instancia;
	}
	
	
	@Override
	public boolean inserirAoCarrinho(Planta carrinho) {
		if (carrinho != null) {
			listaCarrinho.add(carrinho);
			return true;
		}
		return false;
	}

	@Override
	public boolean alterarCarrinho(Planta carrinho) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removerDoCarrinho(int idCarrinho) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ArrayList<Planta> listarItensCarrinho() {
	    return listaCarrinho;
	}


	@Override
	public Planta buscaItemCarrinhoPorId(int idCarrinho) {
		// TODO Auto-generated method stub
		return null;
	}

}
