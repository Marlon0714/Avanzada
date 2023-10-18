package co.edu.uniquindio.proyecto.servicios.interfaces;

import co.edu.uniquindio.proyecto.modelo.entidades.EPS;

import java.util.List;

public interface EPSServicio {
    //Contrato de los servicios de EPS
    boolean registrarEPS(EPS eps) throws Exception;
    boolean actualizarEPS(EPS eps) throws Exception;
    void eliminarEPS(String id) throws Exception;
    EPS obtenerEPS(String id) throws Exception;
    List<EPS> listarEPS();
}
