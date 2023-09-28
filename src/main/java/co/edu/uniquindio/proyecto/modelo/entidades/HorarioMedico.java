package co.edu.uniquindio.proyecto.modelo.entidades;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
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
public class HorarioMedico implements Serializable {

    @Id
    @EqualsAndHashCode.Include
    @NotNull
    @Column(name = "id_horario", unique = true)
    private String idHorario;

    @NotNull
    @Column(name = "hora_inicio")
    private LocalTime horaInicio;

    @NotNull
    @Column(name = "hora_final")
    private LocalTime horaFinal;

    @NotNull
    @Column(name = "fecha_libre")
    private LocalDate fechaDiaLibre;

    @OneToOne
    @MapsId
    private Medico medico;

    public HorarioMedico() {
        super();
    }
}
