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
public class Cita implements Serializable {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    @Column(name = "id_cita", unique = true)
    private Long idCita;

    @NotNull
    @Column(name = "fecha_creacion")
    private LocalDate fechaCreacion;

    @NotNull
    private LocalTime hora;

    @NotNull
    private LocalDate fecha;

    @NotNull
    @Size(max = 255)
    private String motivo;

    @Enumerated(EnumType.STRING)
    private EstadoCita estado;

    @ManyToOne
    private Medico medico;
    @ManyToOne
    private Paciente paciente;

    @OneToOne(mappedBy = "cita")
    private Consulta consulta;

    public Cita() {
        super();
    }

}
