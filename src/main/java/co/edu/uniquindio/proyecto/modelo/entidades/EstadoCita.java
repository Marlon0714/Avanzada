package co.edu.uniquindio.proyecto.modelo.entidades;

import java.io.Serializable;

public enum EstadoCita implements Serializable {
    PROGRAMADA("Programada"),
    COMPLETADA("Completada"),
    CANCELADA("Cancelada");

    private final String descripcion;

    EstadoCita(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    EstadoCita(){
        this.descripcion = name();
    }
}
