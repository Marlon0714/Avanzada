package co.edu.uniquindio.proyecto.modelo.entidades;

import jakarta.persistence.Column;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Ciudad implements Serializable {
    @Id
    @EqualsAndHashCode.Include
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "id_ciudad", unique = true, length = 50)
    private String idCiudad;
    @NotNull
    @Size(min = 1, max = 50)
    private String nombre;

    @OneToMany(mappedBy = "ciudad")
    private List<Paciente> pacientes;
    @OneToMany(mappedBy = "ciudad")
    private List<Medico> medicos;

    public Ciudad() {
        super();
    }
}
