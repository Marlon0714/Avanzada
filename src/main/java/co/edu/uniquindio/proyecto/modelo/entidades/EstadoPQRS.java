package co.edu.uniquindio.proyecto.modelo.entidades;

import java.io.Serializable;

public enum EstadoPQRS implements Serializable {
    NUEVO("Nuevo"),
    EN_PROCESO("En Proceso"),
    RESUELTO("Resuelto"),
    ARCHIVADO("Archivado");

    private final String estado;

    EstadoPQRS(String estado) {
        this.estado = estado;
    }

    public String getEstado() {
        return estado;
    }
    EstadoPQRS() {
        this.estado = name();
    }
}
