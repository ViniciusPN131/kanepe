package controle;

import java.util.ArrayList;

import modelo.Planta;

public class PlantaDAO {
	
	private static ArrayList<Planta> tabelaPlantas;

	public ArrayList<Planta> listar() {
		return tabelaPlantas;
	}

}
