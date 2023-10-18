package co.edu.uniquindio.proyecto.servicios.interfaces;

import co.edu.uniquindio.proyecto.modelo.entidades.Medicamento;

import java.util.List;

public interface MedicamentoServicio {
    //Contrato de los servicios de medicamento
    boolean registrarMedicamento(Medicamento medicamento) throws Exception;
    boolean actualizarMedicamento(Medicamento medicamento) throws Exception;
    void eliminarMedicamento(Long id) throws Exception;
    Medicamento obtenerMedicamento(Long id) throws Exception;
    List<Medicamento> listarMedicamentos();
}
