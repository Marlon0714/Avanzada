package co.edu.uniquindio.proyecto.servicios.interfaces;

import co.edu.uniquindio.proyecto.modelo.entidades.PQRS;

import java.util.List;

public interface PQRSServicio {
    //Contrato de los servicios de PQRS
    boolean registrarPQRS(PQRS pqrs) throws Exception;
    boolean actualizarPQRS(PQRS pqrs) throws Exception;
    void eliminarPQRS(Long id) throws Exception;
    PQRS obtenerPQRS(Long id) throws Exception;
    List<PQRS> listarPQRS();
}
