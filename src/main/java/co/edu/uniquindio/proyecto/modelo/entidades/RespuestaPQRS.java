package co.edu.uniquindio.proyecto.modelo.entidades;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Getter
@Setter
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class RespuestaPQRS implements Serializable {
    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "id_repuesta",length = 10, unique = true)
    private Long idRespuesta;

    @NotNull
    private LocalDate fechaCreacion;

    @NotNull
    private LocalTime horaCreacion;

    @NotNull
    @Size(max = 500)
    private String detalle;

    @ManyToOne
    private PQRS pqrs;

    @OneToOne
    private Usuario usuario;

    public RespuestaPQRS() {
        super();
    }
}
