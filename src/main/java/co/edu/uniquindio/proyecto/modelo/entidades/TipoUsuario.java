package co.edu.uniquindio.proyecto.modelo.entidades;

import java.io.Serializable;

public enum TipoUsuario implements Serializable {
    ADMINISTRADOR("Administrador"),
    MEDICO("Médico"),
    PACIENTE("Paciente");
    private final String tipo;

    TipoUsuario(String tipo) {
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }

    TipoUsuario() {
        this.tipo = name();
    }
}
