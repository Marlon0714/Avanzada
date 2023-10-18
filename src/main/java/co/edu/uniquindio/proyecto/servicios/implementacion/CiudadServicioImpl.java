package co.edu.uniquindio.proyecto.servicios.implementacion;

import co.edu.uniquindio.proyecto.modelo.entidades.Ciudad;
import co.edu.uniquindio.proyecto.repositorios.CiudadRepo;
import co.edu.uniquindio.proyecto.servicios.interfaces.CiudadServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CiudadServicioImpl implements CiudadServicio {

    @Autowired
    private final CiudadRepo ciudadRepo;

    public CiudadServicioImpl(CiudadRepo ciudadRepo) {
        this.ciudadRepo = ciudadRepo;
    }

    @Override
    public boolean registrarCiudad(Ciudad ciudad) throws Exception{
        //Validar que el id de la ciudad no este repetido
        if(ciudadRepo.existsById(ciudad.getIdCiudad())){
            throw new Exception("El id de la ciudad ya existe");
        }
        ciudadRepo.save(ciudad);
        return true;
    }

    @Override
    public boolean actualizarCiudad(Ciudad ciudad) throws Exception{
        //Validar que la ciudad exista
        if(ciudadRepo.existsById(ciudad.getIdCiudad())){
            ciudadRepo.save(ciudad);
            return true;
        }else{
            throw new Exception("La ciudad no existe");
        }
    }

    @Override
    public void eliminarCiudad(String id) throws Exception{
        //Validar que la ciudad exista
        if(ciudadRepo.existsById(id)){
            ciudadRepo.deleteById(id);
        }else{
            throw new Exception("La ciudad no existe");
        }
    }

    @Override
    public Ciudad obtenerCiudad(String id) throws Exception{
        return ciudadRepo.findById(id).orElseThrow(()-> new Exception("No existe una ciudad con el id dado"));
    }

    @Override
    public List<Ciudad> listarCiudades() {
        return ciudadRepo.findAll();
    }
}
