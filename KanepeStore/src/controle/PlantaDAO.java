package controle;

import java.util.ArrayList;

import modelo.IPlantaDAO;
import modelo.Planta;

/*
 * dao  = data access object
 * 
 */
public class PlantaDAO implements IPlantaDAO {
	private static ArrayList<Planta> tabelaPlantas;

	private static PlantaDAO instancia;

	private PlantaDAO() {
	}

	public static PlantaDAO getInstancia() {

		if (instancia == null) {
			instancia = new PlantaDAO();
			tabelaPlantas = new ArrayList<>();
		}

		return instancia;
	}

	@Override
	public boolean inserirPlanta(Planta planta) {
		if (planta != null) {
			tabelaPlantas.add(planta);
			return true;
		}
		return false;
	}

	@Override
	public boolean alterarPlanta(Planta itemAlterar) {
		for (Planta item : tabelaPlantas) {
			if (itemAlterar.getId() == item.getId()) {
				item = itemAlterar;
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean removerPlanta(int id) {
		for (Planta item : tabelaPlantas) {
			if (id == item.getId()) {
				tabelaPlantas.remove(item);
				return true;
			}
		}
		return false;

	}

	@Override
	public ArrayList<Planta> listarPlanta() {
		return tabelaPlantas;
	}

	@Override
	public Planta buscaPlantaPorId(int id) {
		for (Planta item : tabelaPlantas) {
			if (id == item.getId()) {
				return item;
			}
		}
		return null;
	}

}
