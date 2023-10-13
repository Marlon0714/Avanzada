package co.edu.uniquindio.proyecto.servicios.implementacion;

import co.edu.uniquindio.proyecto.modelo.entidades.RespuestaPQRS;
import co.edu.uniquindio.proyecto.servicios.interfaces.RespuestaPQRSServicio;

public class RespuestaPQRSServicioImpl implements RespuestaPQRSServicio {
    //Contrato de los servicios de RespuestaPQRS
    boolean registrarRespuestaPQRS(RespuestaPQRS respuestaPQRS) throws Exception;
    boolean actualizarRespuestaPQRS(RespuestaPQRS respuestaPQRS) throws Exception;
    void eliminarRespuestaPQRS(String id) throws Exception;
    RespuestaPQRS obtenerRespuestaPQRS(String id) throws Exception;
}
