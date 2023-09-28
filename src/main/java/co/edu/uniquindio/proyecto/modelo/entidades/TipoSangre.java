package co.edu.uniquindio.proyecto.modelo.entidades;

import java.io.Serializable;

public enum TipoSangre implements Serializable {
    A_POSITIVO("A+"),
    A_NEGATIVO("A-"),
    B_POSITIVO("B+"),
    B_NEGATIVO("B-"),
    O_POSITIVO("O+"),
    O_NEGATIVO("O-"),
    AB_POSITIVO("AB+"),
    AB_NEGATIVO("AB-");

    private final String tipo;

    TipoSangre(String tipo) {
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }

    TipoSangre() {
        this.tipo = name();
    }
}
