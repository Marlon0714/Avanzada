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
import java.util.List;

@Entity
@Getter
@Setter
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class PQRS implements Serializable {
    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    @Column(name = "num_radicado", unique = true)
    private Long numRadicado;

    @NotNull
    private LocalDate fechaCreacion;

    @NotNull
    @Column(length = 500)
    private String detalle;

    @Size(max = 50)
    @Enumerated(EnumType.STRING)
    private EstadoPQRS estado;

    @Size(max = 50)
    @Enumerated(EnumType.STRING)
    private TipoPQRS tipo;

    @ManyToOne
    private Paciente paciente;

    @OneToOne
    private Consulta consulta;

    @OneToMany(mappedBy = "pqrs")
    private List<RespuestaPQRS> respuestas;

    public PQRS() {
        super();
    }

}
