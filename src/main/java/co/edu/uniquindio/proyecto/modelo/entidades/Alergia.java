package co.edu.uniquindio.proyecto.modelo.entidades;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.ManyToMany;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
@Getter
@Setter
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Alergia implements Serializable {
    @Id
    @EqualsAndHashCode.Include
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "id_alergia", unique = true, length = 50)
    private String idAlergia;

    @NotNull
    @Size(min = 1, max = 100)
    private String nombre;

    @ManyToMany(mappedBy = "alergias")
    private List<Paciente> pacientes;

    public Alergia() {
        super();
    }
}
