package co.edu.uniquindio.proyecto.servicios.interfaces;

import co.edu.uniquindio.proyecto.modelo.entidades.Alergia;

public interface AlergiaServicio {
    //Contrato para los servcios de Alergia
    boolean registrarAlergia(Alergia alergia) throws Exception;
    boolean actualizarAlergia(Alergia alergia) throws Exception;
    void eliminarAlergia(String id) throws Exception;
    Alergia obtenerAlergia(String id) throws Exception;

}
