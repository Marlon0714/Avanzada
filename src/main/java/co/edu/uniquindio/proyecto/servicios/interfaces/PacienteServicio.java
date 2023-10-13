package co.edu.uniquindio.proyecto.servicios.interfaces;

import co.edu.uniquindio.proyecto.modelo.entidades.Paciente;

public interface PacienteServicio {
    //Contrato de los servicios del paciente
    boolean registrarPaciente(Paciente paciente) throws Exception;
    boolean actualizarPaciente(Paciente paciente) throws Exception;
    void eliminarPaciente(String id) throws Exception;
    Paciente obtenerPaciente(String id) throws Exception;
}
