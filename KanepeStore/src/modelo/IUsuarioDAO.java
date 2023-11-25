package modelo;

import java.util.ArrayList;

public interface IUsuarioDAO {
	public boolean inserirUsuario(Usuario usuario);

	public boolean alterarUsuario(Usuario usuario);

	public boolean removerUsuario(int idUsuario);

	public ArrayList<Usuario> listarUsuarios();

	public Usuario buscaUsuarioPorId(int idUsuario);
}
