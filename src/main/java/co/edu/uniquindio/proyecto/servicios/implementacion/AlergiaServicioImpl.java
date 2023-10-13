package co.edu.uniquindio.proyecto.servicios.implementacion;

import co.edu.uniquindio.proyecto.modelo.entidades.Alergia;
import co.edu.uniquindio.proyecto.repositorios.AlergiaRepo;
import co.edu.uniquindio.proyecto.servicios.interfaces.AlergiaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AlergiaServicioImpl implements AlergiaServicio {
    @Autowired
    private final AlergiaRepo alergiaRepo;

    public AlergiaServicioImpl(AlergiaRepo alergiaRepo) {
        this.alergiaRepo = alergiaRepo;
    }

    @Override
    public boolean registrarAlergia(Alergia alergia) throws Exception{
        //Validar que el id de la alergia no este repetido
        if(alergiaRepo.existsById(alergia.getIdAlergia())){
            throw new Exception("El id de la alergia ya existe");
        }
        alergiaRepo.save(alergia);
        return true;
    }

    @Override
    public boolean actualizarAlergia(Alergia alergia) throws Exception{
        //Validar que la alergia exista
        if(alergiaRepo.existsById(alergia.getIdAlergia())){
            alergiaRepo.save(alergia);
            return true;
        }else{
            throw new Exception("La alergia no existe");
        }
    }

    @Override
    public void eliminarAlergia(String id) throws Exception{
        //Validar que la alergia exista
        if(alergiaRepo.existsById(id)){
            alergiaRepo.deleteById(id);
        }else{
            throw new Exception("La alergia no existe");
        }
    }

    @Override
    public Alergia obtenerAlergia(String id) throws Exception{
        return alergiaRepo.findById(id).orElseThrow(()-> new Exception("No existe una alergia con el id dado"));
    }

}
