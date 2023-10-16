package co.edu.uniquindio.proyecto.servicios.implementacion;

import co.edu.uniquindio.proyecto.modelo.entidades.Medicamento;
import co.edu.uniquindio.proyecto.repositorios.MedicamentoRepo;
import co.edu.uniquindio.proyecto.servicios.interfaces.MedicamentoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class MedicamentoServicioImpl implements MedicamentoServicio {

    @Autowired
    private final MedicamentoRepo medicamentoRepo;

    public MedicamentoServicioImpl(MedicamentoRepo medicamentoRepo) {
        this.medicamentoRepo = medicamentoRepo;
    }

    @Override
    public boolean registrarMedicamento(Medicamento medicamento) throws Exception{
        medicamentoRepo.save(medicamento);
        return true;
    }
    @Override
    public boolean actualizarMedicamento(Medicamento medicamento) throws Exception{
        if(medicamentoRepo.existsById(medicamento.getIdMedicamento())){
            medicamentoRepo.save(medicamento);
            return true;
        }else{
            throw new Exception("El medicamento no existe");
        }
    }
    @Override
    public void eliminarMedicamento(Long id) throws Exception{
        if(medicamentoRepo.existsById(id)){
            medicamentoRepo.deleteById(id);
        }else{
            throw new Exception("El medicamento no existe");
        }
    }
    @Override
    public Medicamento obtenerMedicamento(Long id) throws Exception{
        return medicamentoRepo.findById(id).orElseThrow(()-> new Exception("No existe un medicamento con el id dado"));
    }
}
