package co.edu.uniquindio.proyecto.servicios.interfaces;

import co.edu.uniquindio.proyecto.modelo.entidades.HorarioMedico;

public interface HorarioMedicoServicio {
    //Contrato para los servicios de HorarioMedico
    boolean registrarHorarioMedico(HorarioMedico horarioMedico) throws Exception;
    boolean actualizarHorarioMedico(HorarioMedico horarioMedico) throws Exception;
    void eliminarHorarioMedico(String id) throws Exception;
    HorarioMedico obtenerHorarioMedico(String id) throws Exception;
}
