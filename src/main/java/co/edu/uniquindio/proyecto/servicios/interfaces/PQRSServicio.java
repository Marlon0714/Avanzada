package co.edu.uniquindio.proyecto.servicios.interfaces;

import co.edu.uniquindio.proyecto.modelo.entidades.PQRS;

public interface PQRSServicio {
    //Contrato de los servicios de PQRS
    boolean registrarPQRS(PQRS pqrs) throws Exception;
    boolean actualizarPQRS(PQRS pqrs) throws Exception;
    void eliminarPQRS(String id) throws Exception;
    PQRS obtenerPQRS(String id) throws Exception;
}
