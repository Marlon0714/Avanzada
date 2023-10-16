package co.edu.uniquindio.proyecto.servicios.implementacion;

import co.edu.uniquindio.proyecto.modelo.entidades.Especializacion;
import co.edu.uniquindio.proyecto.repositorios.EspecializacionRepo;
import co.edu.uniquindio.proyecto.servicios.interfaces.EspecializacionServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class EspecializacionServicioImpl implements EspecializacionServicio {

    @Autowired
    private final EspecializacionRepo especializacionRepo;

    public EspecializacionServicioImpl(EspecializacionRepo especializacionRepo) {
        this.especializacionRepo = especializacionRepo;
    }

    @Override
    public boolean registrarEspecializacion(Especializacion especializacion) throws Exception{
        especializacionRepo.save(especializacion);
        return true;
    }
    public boolean actualizarEspecializacion(Especializacion especializacion) throws Exception{
        if(especializacionRepo.existsById(especializacion.getIdEspecializacion())){
            especializacionRepo.save(especializacion);
            return true;
        }else{
            throw new Exception("La especializacion no existe");
        }
    }
    public void eliminarEspecializacion(Long id) throws Exception{
        if(especializacionRepo.existsById(id)){
            especializacionRepo.deleteById(id);
        }else{
            throw new Exception("La especializacion no existe");
        }
    }
    public Especializacion obtenerEspecializacion(Long id) throws Exception{
        return especializacionRepo.findById(id).orElseThrow(()-> new Exception("No existe una especializacion con el id dado"));
    }

}
