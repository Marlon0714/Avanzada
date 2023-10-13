package co.edu.uniquindio.proyecto.servicios.implementacion;

import co.edu.uniquindio.proyecto.modelo.entidades.Usuario;
import co.edu.uniquindio.proyecto.servicios.interfaces.UsuarioServicio;

public class UsuarioServicioImpl implements UsuarioServicio {
    //Contratos de los servicios de usuario
    boolean login(String email, String password);
    boolean logout();
    boolean registrarUsuario(Usuario usuario) throws Exception;
    boolean actualizarUsuario(Usuario usuario) throws Exception;
    void eliminarUsuario(String id) throws Exception;
    Usuario obtenerUsuario(String id) throws Exception;
}
