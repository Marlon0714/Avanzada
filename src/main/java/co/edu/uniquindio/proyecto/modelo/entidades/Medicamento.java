package co.edu.uniquindio.proyecto.modelo.entidades;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Medicamento implements Serializable {
    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    @Column(name = "id_medicamento", unique = true)
    private Long idMedicamento;

    @NotNull
    @Column(length = 100)
    private String nombre;

    @Column(length = 100)
    private String descripcion;

    @ManyToMany(mappedBy = "medicamentos")
    private List<Consulta> consultas;

    public Medicamento() {
        super();
    }
}
