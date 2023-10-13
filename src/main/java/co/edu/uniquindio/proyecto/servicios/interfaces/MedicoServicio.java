package co.edu.uniquindio.proyecto.servicios.interfaces;

import co.edu.uniquindio.proyecto.modelo.entidades.Medico;

public interface MedicoServicio {
    //Contrato de los servicios de medico
    boolean registrarMedico(Medico medico) throws Exception;
    boolean actualizarMedico(Medico medico) throws Exception;
    void eliminarMedico(String id) throws Exception;
    Medico obtenerMedico(String id) throws Exception;

}
