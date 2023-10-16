package co.edu.uniquindio.proyecto.servicios.implementacion;

import co.edu.uniquindio.proyecto.modelo.entidades.EPS;
import co.edu.uniquindio.proyecto.repositorios.EPSRepo;
import co.edu.uniquindio.proyecto.servicios.interfaces.EPSServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class EPSServicioImpl implements EPSServicio {

    @Autowired
    private final EPSRepo epsServicio;

    public EPSServicioImpl(EPSRepo epsServicio) {
        this.epsServicio = epsServicio;
    }

    @Override
    public boolean registrarEPS(EPS eps) throws Exception{
        //Validar que el id de la EPS no este repetido
        if(epsServicio.existsById(eps.getIdEPS())){
            throw new Exception("El id de la EPS ya existe");
        }
        epsServicio.save(eps);
        return true;
    }

    @Override
    public boolean actualizarEPS(EPS eps) throws Exception{
        //Validar que la EPS exista
        if(epsServicio.existsById(eps.getIdEPS())){
            epsServicio.save(eps);
            return true;
        }else{
            throw new Exception("La EPS no existe");
        }
    }

    @Override
    public void eliminarEPS(String id) throws Exception{
        //Validar que la EPS exista
        if(epsServicio.existsById(id)){
            epsServicio.deleteById(id);
        }else{
            throw new Exception("La EPS no existe");
        }
    }

    @Override
    public EPS obtenerEPS(String id) throws Exception{
        return epsServicio.findById(id).orElseThrow(()-> new Exception("No existe una EPS con el id dado"));
    }
}
