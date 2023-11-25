package modelo;

import java.util.ArrayList;

public interface ICarrinhoDAO {
	
	public boolean inserirAoCarrinho(Planta carrinho);

	public boolean alterarCarrinho(Planta carrinho);

	public boolean removerDoCarrinho(int idCarrinho);

	public ArrayList<Planta> listarItensCarrinho();

	public Planta buscaItemCarrinhoPorId(int idCarrinho);
	
}
