package co.edu.uniquindio.proyecto.servicios.implementacion;

import co.edu.uniquindio.proyecto.modelo.entidades.Especializacion;
import co.edu.uniquindio.proyecto.servicios.interfaces.EspecializacionServicio;

public class EspecializacionServicioImpl implements EspecializacionServicio {
    //Contrato para los servicios de Especializacion
    boolean registrarEspecializacion(Especializacion especializacion) throws Exception;
    boolean actualizarEspecializacion(Especializacion especializacion) throws Exception;
    void eliminarEspecializacion(String id) throws Exception;
    Especializacion obtenerEspecializacion(String id) throws Exception;

}
