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
import java.util.Set;

@Entity
@Getter
@Setter
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = false)
public class Paciente extends Usuario implements Serializable {
//    @Id
//    @EqualsAndHashCode.Include
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @NotNull
//    @Size(min = 1, max = 20)
//    @AttributeOverride(name = "idUsuario", column = @Column(name = "id_paciente", unique = true))
//    private String cedula;

    @ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(
            name = "paciente_telefonos",
            joinColumns = @JoinColumn(name = "id_paciente")
    )
    @Size(max = 20)
    @Column(name = "telefono",length = 20)
    private List<String> telefonos;
    @ManyToOne
    private Ciudad ciudad;
    @NotNull
    @Column(name = "fecha_nacimiento")
    private LocalDate fechaNacimiento;
    @ManyToOne
    private EPS eps;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_sangre")
    private TipoSangre tipoSangre;

    @ManyToMany
    @JoinTable(
            name = "paciente_alergias",
            joinColumns = @JoinColumn(name = "id_paciente"),
            inverseJoinColumns = @JoinColumn(name = "id_alergia")
    )
    private Set<Alergia> alergias;

    @OneToMany(mappedBy = "paciente")
    private List<Cita> citas;

    @OneToMany(mappedBy = "paciente")
    private List<PQRS> listaPQRS;

    public Paciente() {
        super();
    }

}
