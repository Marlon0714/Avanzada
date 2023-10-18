package co.edu.uniquindio.proyecto.servicios.implementacion;

import co.edu.uniquindio.proyecto.modelo.entidades.PQRS;
import co.edu.uniquindio.proyecto.repositorios.PQRSRepo;
import co.edu.uniquindio.proyecto.servicios.interfaces.PQRSServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class PQRSServicioImpl implements PQRSServicio {

    @Autowired
    private final PQRSRepo pqrsRepo;

    public PQRSServicioImpl(PQRSRepo pqrsRepo) {
        this.pqrsRepo = pqrsRepo;
    }

    @Override
    public boolean registrarPQRS(PQRS pqrs) throws Exception{
        pqrsRepo.save(pqrs);
        return true;
    }
    @Override
    public boolean actualizarPQRS(PQRS pqrs) throws Exception{
        if(pqrsRepo.existsById(pqrs.getNumRadicado())){
            pqrsRepo.save(pqrs);
            return true;
        }else{
            throw new Exception("La PQRS no existe");
        }
    }
    @Override
    public void eliminarPQRS(Long id) throws Exception{
        if(pqrsRepo.existsById(id)){
            pqrsRepo.deleteById(id);
        }else{
            throw new Exception("La PQRS no existe");
        }
    }
    @Override
    public PQRS obtenerPQRS(Long id) throws Exception{
        return pqrsRepo.findById(id).orElseThrow(()-> new Exception("No existe una PQRS con el id dado"));
    }

    @Override
    public List<PQRS> listarPQRS() {
        return pqrsRepo.findAll();
    }
}
