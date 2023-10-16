package co.edu.uniquindio.proyecto.servicios.interfaces;

import co.edu.uniquindio.proyecto.modelo.entidades.RespuestaPQRS;

public interface RespuestaPQRSServicio {
    //Contrato de los servicios de RespuestaPQRS
    boolean registrarRespuestaPQRS(RespuestaPQRS respuestaPQRS) throws Exception;
    boolean actualizarRespuestaPQRS(RespuestaPQRS respuestaPQRS) throws Exception;
    void eliminarRespuestaPQRS(Long id) throws Exception;
    RespuestaPQRS obtenerRespuestaPQRS(Long id) throws Exception;
}
