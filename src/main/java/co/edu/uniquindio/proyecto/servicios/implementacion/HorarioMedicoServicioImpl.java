package co.edu.uniquindio.proyecto.servicios.implementacion;

import co.edu.uniquindio.proyecto.modelo.entidades.HorarioMedico;
import co.edu.uniquindio.proyecto.repositorios.HorarioMedicoRepo;
import co.edu.uniquindio.proyecto.servicios.interfaces.HorarioMedicoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class HorarioMedicoServicioImpl implements HorarioMedicoServicio {

    @Autowired
    private final HorarioMedicoRepo horarioMedicoRepo;

    public HorarioMedicoServicioImpl(HorarioMedicoRepo horarioMedicoRepo) {
        this.horarioMedicoRepo = horarioMedicoRepo;
    }

    @Override
    public boolean registrarHorarioMedico(HorarioMedico horarioMedico) throws Exception{
        //Validar que el id del horario no este repetido
        if(horarioMedicoRepo.existsById(horarioMedico.getIdHorario())){
            throw new Exception("El id del horario ya existe");
        }
        horarioMedicoRepo.save(horarioMedico);
        return true;
    }

    @Override
    public boolean actualizarHorarioMedico(HorarioMedico horarioMedico) throws Exception{
        //Validar que el horario exista
        if(horarioMedicoRepo.existsById(horarioMedico.getIdHorario())){
            horarioMedicoRepo.save(horarioMedico);
            return true;
        }else{
            throw new Exception("El horario no existe");
        }
    }

    @Override
    public void eliminarHorarioMedico(String id) throws Exception{
        //Validar que el horario exista
        if(horarioMedicoRepo.existsById(id)){
            horarioMedicoRepo.deleteById(id);
        }else{
            throw new Exception("El horario no existe");
        }
    }

    @Override
    public HorarioMedico obtenerHorarioMedico(String id) throws Exception{
        return horarioMedicoRepo.findById(id).orElseThrow(()-> new Exception("No existe un horario con el id dado"));
    }
}
