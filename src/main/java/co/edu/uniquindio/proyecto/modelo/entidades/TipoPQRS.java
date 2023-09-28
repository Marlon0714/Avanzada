package co.edu.uniquindio.proyecto.modelo.entidades;

public enum TipoPQRS {
    PETICION("Peticion"),
    QUEJA("Queja"),
    RECLAMO("Reclamo"),
    SOLICITUDES("Solicitudes");

    private final String tipo;

    TipoPQRS(String tipo) {
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }
    TipoPQRS() {
        this.tipo = name();
    }
}
