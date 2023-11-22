package modelo;

import java.util.ArrayList;

public interface IPlantaDAO {

	public boolean inserirPlanta(Planta planta);

	public boolean alterarPlanta(Planta planta);

	public boolean removerPlanta(int id);

	public ArrayList<Planta> listarPlanta();

	public Planta buscaPlantaPorId(int id);

}
