package co.edu.uniquindio.proyecto.servicios.implementacion;

import co.edu.uniquindio.proyecto.modelo.entidades.Paciente;
import co.edu.uniquindio.proyecto.repositorios.PacienteRepo;
import co.edu.uniquindio.proyecto.servicios.interfaces.PacienteServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class PacienteServicioImpl implements PacienteServicio {

    @Autowired
    private final PacienteRepo pacienteRepo;

    public PacienteServicioImpl(PacienteRepo pacienteRepo) {
        this.pacienteRepo = pacienteRepo;
    }


    @Override
    public boolean registrarPaciente(Paciente paciente) throws Exception{
        if(pacienteRepo.existsById(paciente.getIdUsuario())){
            throw new Exception("El paciente ya existe");
        }else{
            pacienteRepo.save(paciente);
            return true;
        }
    }
    @Override
    public boolean actualizarPaciente(Paciente paciente) throws Exception{
        if(pacienteRepo.existsById(paciente.getIdUsuario())){
            pacienteRepo.save(paciente);
            return true;
        }else{
            throw new Exception("El paciente no existe");
        }
    }
    @Override
    public void eliminarPaciente(String id) throws Exception{
        if(pacienteRepo.existsById(id)){
            pacienteRepo.deleteById(id);
        }else{
            throw new Exception("El paciente no existe");
        }
    }
    @Override
    public Paciente obtenerPaciente(String id) throws Exception{
        return pacienteRepo.findById(id).orElseThrow(()-> new Exception("No existe un paciente con el id dado"));
    }

    @Override
    public List<Paciente> listarPacientes() {
        return pacienteRepo.findAll();
    }
}
