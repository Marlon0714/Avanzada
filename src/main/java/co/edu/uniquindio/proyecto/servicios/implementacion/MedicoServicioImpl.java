package co.edu.uniquindio.proyecto.servicios.implementacion;

import co.edu.uniquindio.proyecto.modelo.entidades.Medico;
import co.edu.uniquindio.proyecto.repositorios.MedicoRepo;
import co.edu.uniquindio.proyecto.servicios.interfaces.MedicoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class MedicoServicioImpl implements MedicoServicio {
    @Autowired
    private final MedicoRepo medicoRepo;

    public MedicoServicioImpl(MedicoRepo medicoRepo) {
        this.medicoRepo = medicoRepo;
    }

    @Override
    public boolean registrarMedico(Medico medico) throws Exception{
        if(medicoRepo.existsById(medico.getIdUsuario())){
            throw new Exception("El medico ya existe");
        }else{
            medicoRepo.save(medico);
            return true;
        }
    }
    @Override
    public boolean actualizarMedico(Medico medico) throws Exception{
        if(medicoRepo.existsById(medico.getIdUsuario())){
            medicoRepo.save(medico);
            return true;
        }else{
            throw new Exception("El medico no existe");
        }
    }
    @Override
    public void eliminarMedico(String id) throws Exception{
        if(medicoRepo.existsById(id)){
            medicoRepo.deleteById(id);
        }else{
            throw new Exception("El medico no existe");
        }
    }
    @Override
    public Medico obtenerMedico(String id) throws Exception{
        return medicoRepo.findById(id).orElseThrow(()-> new Exception("No existe un medico con el id dado"));
    }

}
