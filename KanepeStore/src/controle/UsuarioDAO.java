package controle;

import java.util.ArrayList;

import modelo.IUsuarioDAO;
import modelo.Usuario;

public class UsuarioDAO implements IUsuarioDAO {
	
	private static ArrayList<Usuario> listaUsuarios;

	private static UsuarioDAO instancia;

	private UsuarioDAO() {
	}

	public static UsuarioDAO getInstancia() {

		if (instancia == null) {
			instancia = new UsuarioDAO();
			listaUsuarios = new ArrayList<>();
		}

		return instancia;
	}
	
	@Override
	public boolean inserirUsuario(Usuario usuario) {
		if (usuario != null) {
			listaUsuarios.add(usuario);
			return true;
		}
		return false;
	}

	@Override
	public boolean alterarUsuario(Usuario usuario) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removerUsuario(int idUsuario) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ArrayList<Usuario> listarUsuarios() {
		// TODO Auto-generated method stub
		return listaUsuarios;
	}

	@Override
	public Usuario buscaUsuarioPorId(int idUsuario) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
}
