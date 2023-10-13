package co.edu.uniquindio.proyecto.servicios.interfaces;

import co.edu.uniquindio.proyecto.modelo.entidades.Ciudad;

public interface CiudadServicio {
    //Contrato de los servicios de la entidad Ciudad
    boolean registrarCiudad(Ciudad ciudad) throws Exception;
    boolean actualizarCiudad(Ciudad ciudad) throws Exception;
    void eliminarCiudad(String id) throws Exception;
    Ciudad obtenerCiudad(String id) throws Exception;
}
