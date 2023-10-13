package co.edu.uniquindio.proyecto.servicios.implementacion;

import co.edu.uniquindio.proyecto.modelo.entidades.Cita;
import co.edu.uniquindio.proyecto.repositorios.CitaRepo;
import co.edu.uniquindio.proyecto.servicios.interfaces.CitaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CitaServicioImpl implements CitaServicio {
    @Autowired
    private final CitaRepo citaRepo;

    public CitaServicioImpl(CitaRepo citaRepo) {
        this.citaRepo = citaRepo;
    }

    @Override
    public boolean registrarCita(Cita cita) throws Exception{
        citaRepo.save(cita);
        return true;
    }

    @Override
    public boolean actualizarCita(Cita cita) throws Exception{
        if(citaRepo.existsById(cita.getIdCita())){
            citaRepo.save(cita);
            return true;
        }else{
            throw new Exception("La cita no existe");
        }
    }

    @Override
    public void eliminarCita(Long id) throws Exception{
        if(citaRepo.existsById(id)){
            citaRepo.deleteById(id);
        }else{
            throw new Exception("La cita no existe");
        }
    }

    @Override
    public Cita obtenerCita(Long id) throws Exception{
        return citaRepo.findById(id).orElseThrow(()-> new Exception("No existe una cita con el id dado"));
    }
}
