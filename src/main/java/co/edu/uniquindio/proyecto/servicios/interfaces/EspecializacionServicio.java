package co.edu.uniquindio.proyecto.servicios.interfaces;

import co.edu.uniquindio.proyecto.modelo.entidades.Especializacion;

public interface EspecializacionServicio {
    //Contrato para los servicios de Especializacion
    boolean registrarEspecializacion(Especializacion especializacion) throws Exception;
    boolean actualizarEspecializacion(Especializacion especializacion) throws Exception;
    void eliminarEspecializacion(String id) throws Exception;
    Especializacion obtenerEspecializacion(String id) throws Exception;

}
