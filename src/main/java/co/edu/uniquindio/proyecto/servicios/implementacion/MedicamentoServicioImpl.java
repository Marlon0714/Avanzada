package co.edu.uniquindio.proyecto.servicios.implementacion;

import co.edu.uniquindio.proyecto.modelo.entidades.Medicamento;
import co.edu.uniquindio.proyecto.servicios.interfaces.MedicamentoServicio;

public class MedicamentoServicioImpl implements MedicamentoServicio {
    //Contrato de los servicios de medicamento
    boolean registrarMedicamento(Medicamento medicamento) throws Exception;
    boolean actualizarMedicamento(Medicamento medicamento) throws Exception;
    void eliminarMedicamento(String id) throws Exception;
    Medicamento obtenerMedicamento(String id) throws Exception;
}
