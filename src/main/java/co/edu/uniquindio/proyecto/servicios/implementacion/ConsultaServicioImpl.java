package co.edu.uniquindio.proyecto.servicios.implementacion;

import co.edu.uniquindio.proyecto.modelo.entidades.Consulta;
import co.edu.uniquindio.proyecto.repositorios.ConsultaRepo;
import co.edu.uniquindio.proyecto.servicios.interfaces.ConsultaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ConsultaServicioImpl implements ConsultaServicio {

    @Autowired
    private final ConsultaRepo consultaRepo;

    public ConsultaServicioImpl(ConsultaRepo consultaRepo) {
        this.consultaRepo = consultaRepo;
    }

    @Override
    public boolean registrarConsulta(Consulta consulta) throws Exception{
        consultaRepo.save(consulta);
        return true;
    }
    @Override
    public boolean actualizarConsulta(Consulta consulta) throws Exception{
        if(consultaRepo.existsById(consulta.getIdConsulta())){
            consultaRepo.save(consulta);
            return true;
        }else{
            throw new Exception("La consulta no existe");
        }
    }

    @Override
    public void eliminarConsulta(Long id) throws Exception{
        if(consultaRepo.existsById(id)){
            consultaRepo.deleteById(id);
        }else{
            throw new Exception("La consulta no existe");
        }
    }

    @Override
    public Consulta obtenerConsulta(Long id) throws Exception{
        return consultaRepo.findById(id).orElseThrow(()-> new Exception("No existe una consulta con el id dado"));
    }

    @Override
    public List<Consulta> listarConsultas() {
        return consultaRepo.findAll();
    }
}
