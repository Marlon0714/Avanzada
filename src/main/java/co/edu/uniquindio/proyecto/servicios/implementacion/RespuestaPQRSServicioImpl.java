package co.edu.uniquindio.proyecto.servicios.implementacion;

import co.edu.uniquindio.proyecto.modelo.entidades.RespuestaPQRS;
import co.edu.uniquindio.proyecto.repositorios.RespuestaPQRSRepo;
import co.edu.uniquindio.proyecto.servicios.interfaces.RespuestaPQRSServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class RespuestaPQRSServicioImpl implements RespuestaPQRSServicio {

    @Autowired
    private final RespuestaPQRSRepo respuestaPQRSRepo;

    public RespuestaPQRSServicioImpl(RespuestaPQRSRepo respuestaPQRSRepo) {
        this.respuestaPQRSRepo = respuestaPQRSRepo;
    }

    @Override
    public boolean registrarRespuestaPQRS(RespuestaPQRS respuestaPQRS) throws Exception{
        respuestaPQRSRepo.save(respuestaPQRS);
        return true;
    }
    @Override
    public boolean actualizarRespuestaPQRS(RespuestaPQRS respuestaPQRS) throws Exception{
        if(respuestaPQRSRepo.existsById(respuestaPQRS.getIdRespuesta())){
            respuestaPQRSRepo.save(respuestaPQRS);
            return true;
        }else{
            throw new Exception("La respuestaPQRS no existe");
        }
    }
    @Override
    public void eliminarRespuestaPQRS(Long id) throws Exception{
        if(respuestaPQRSRepo.existsById(id)){
            respuestaPQRSRepo.deleteById(id);
        }else{
            throw new Exception("La respuestaPQRS no existe");
        }
    }
    @Override
    public RespuestaPQRS obtenerRespuestaPQRS(Long id) throws Exception{
        return respuestaPQRSRepo.findById(id).orElseThrow(()-> new Exception("No existe una respuestaPQRS con el id dado"));
    }

    @Override
    public List<RespuestaPQRS> listarRespuestasPQRS() {
        return respuestaPQRSRepo.findAll();
    }
}
