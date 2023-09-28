package co.edu.uniquindio.proyecto.modelo.entidades;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
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
public class Especializacion implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "id_especializacion", unique = true, length = 50)
    private Long idEspecializacion;

    @NotNull
    @Size(min = 1, max = 50)
    private String nombre;
    @Size(max = 100)
    private String descripcion;

    @OneToMany(mappedBy = "especialidad")
    private List<Medico> medicos;

}
