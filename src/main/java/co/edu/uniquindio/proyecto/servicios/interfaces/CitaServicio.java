package co.edu.uniquindio.proyecto.servicios.interfaces;

import co.edu.uniquindio.proyecto.modelo.entidades.Cita;

public interface CitaServicio {
    //Contrato de los servicios de cita
    boolean registrarCita(Cita cita) throws Exception;
    boolean actualizarCita(Cita cita) throws Exception;
    void eliminarCita(Long id) throws Exception;
    Cita obtenerCita(Long id) throws Exception;
}
