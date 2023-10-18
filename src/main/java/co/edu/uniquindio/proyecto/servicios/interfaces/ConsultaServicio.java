package co.edu.uniquindio.proyecto.servicios.interfaces;

import co.edu.uniquindio.proyecto.modelo.entidades.Consulta;

import java.util.List;

public interface ConsultaServicio {
    //Contrato de los servicios de consulta
    boolean registrarConsulta(Consulta consulta) throws Exception;
    boolean actualizarConsulta(Consulta consulta) throws Exception;
    void eliminarConsulta(Long id) throws Exception;
    Consulta obtenerConsulta(Long id) throws Exception;
    List<Consulta> listarConsultas();
}
