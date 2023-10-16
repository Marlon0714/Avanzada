package co.edu.uniquindio.proyecto.servicios.implementacion;

import co.edu.uniquindio.proyecto.modelo.entidades.Usuario;
import co.edu.uniquindio.proyecto.repositorios.UsuarioRepo;
import co.edu.uniquindio.proyecto.servicios.interfaces.UsuarioServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class UsuarioServicioImpl implements UsuarioServicio {
    @Autowired
    private final UsuarioRepo usuarioRepo;

    public UsuarioServicioImpl(UsuarioRepo usuarioRepo) {
        this.usuarioRepo = usuarioRepo;
    }

    @Override
    public boolean login(String email, String password){
        Optional<Usuario> usuario = usuarioRepo.findByEmail(email);
        if(usuario.isPresent() && usuario.get().getPassword().equals(password)){
            return true;
        }else{
            return false;
        }
    }
    @Override
    public boolean logout(){
        return false;
    }
    @Override
    public boolean registrarUsuario(Usuario usuario) throws Exception{
        if(usuarioRepo.existsById(usuario.getIdUsuario()) || usuarioRepo.findByEmail(usuario.getEmail()).isPresent()){
            throw new Exception("El usuario ya existe");
        }else{
            usuarioRepo.save(usuario);
            return true;
        }
    }
    @Override
    public boolean actualizarUsuario(Usuario usuario) throws Exception{
        if(usuarioRepo.existsById(usuario.getIdUsuario())){
            usuarioRepo.save(usuario);
            return true;
        }else{
            throw new Exception("El usuario no existe");
        }
    }
    @Override
    public void eliminarUsuario(String id) throws Exception{
        if(usuarioRepo.existsById(id)){
            usuarioRepo.deleteById(id);
        }else{
            throw new Exception("El usuario no existe");
        }
    }
    @Override
    public Usuario obtenerUsuario(String id) throws Exception{
        return usuarioRepo.findById(id).orElseThrow(()-> new Exception("No existe un usuario con el id dado"));
    }
}
