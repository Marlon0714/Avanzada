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
public class Consulta implements Serializable {
    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    @Column(name = "id_consulta", unique = true)
    private Long idConsulta;

    @NotNull
    private LocalDate fecha;

    @Size(max = 500)
    @Column(name = "notas_medico")
    private String notasMedico;

    @Size(max = 500)
    private String diagnostico;

    @OneToOne
    private Cita cita;

    @OneToOne(mappedBy = "consulta")
    private PQRS pqrs;

    @ManyToMany
    @JoinTable(
            name = "consulta_medicamento",
            joinColumns = @JoinColumn(name = "id_consulta"),
            inverseJoinColumns = @JoinColumn(name = "id_medicamento")
    )
    private List<Medicamento> medicamentos;


    public Consulta() {
        super();
    }
}
