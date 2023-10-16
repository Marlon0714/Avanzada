package co.edu.uniquindio.proyecto.servicios.interfaces;

import co.edu.uniquindio.proyecto.modelo.entidades.Especializacion;

public interface EspecializacionServicio {
    //Contrato para los servicios de Especializacion
    boolean registrarEspecializacion(Especializacion especializacion) throws Exception;
    boolean actualizarEspecializacion(Especializacion especializacion) throws Exception;
    void eliminarEspecializacion(Long id) throws Exception;
    Especializacion obtenerEspecializacion(Long id) throws Exception;

}
