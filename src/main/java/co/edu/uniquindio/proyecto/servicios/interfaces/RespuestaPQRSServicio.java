package co.edu.uniquindio.proyecto.servicios.interfaces;

import co.edu.uniquindio.proyecto.modelo.entidades.RespuestaPQRS;

public interface RespuestaPQRSServicio {
    //Contrato de los servicios de RespuestaPQRS
    boolean registrarRespuestaPQRS(RespuestaPQRS respuestaPQRS) throws Exception;
    boolean actualizarRespuestaPQRS(RespuestaPQRS respuestaPQRS) throws Exception;
    void eliminarRespuestaPQRS(String id) throws Exception;
    RespuestaPQRS obtenerRespuestaPQRS(String id) throws Exception;
}
