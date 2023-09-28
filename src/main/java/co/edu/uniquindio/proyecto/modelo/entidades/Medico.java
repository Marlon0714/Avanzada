package co.edu.uniquindio.proyecto.modelo.entidades;

import jakarta.persistence.*;
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
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = false)
public class Medico extends Usuario implements Serializable {
//    @Id
//    @EqualsAndHashCode.Include
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @NotNull
//    @Size(min = 1, max = 20)
//    @AttributeOverride(name = "idUsuario", column = @Column(name = "id_medico", unique = true))
//    private String idMedico;

    @ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(
            name = "medico_telefonos",
            joinColumns = @JoinColumn(name = "id_medico")
    )
    @Size(max = 20)
    @Column(name = "telefono",length = 20)
    private List<String> telefonos;

    @ManyToOne
    private Ciudad ciudad;

    @ManyToOne
    private Especializacion especialidad;

    @OneToOne(mappedBy = "medico", cascade = CascadeType.ALL, orphanRemoval = true)
    private HorarioMedico horario;

    @OneToMany(mappedBy = "medico")
    private List<Cita> citas;

    public Medico() {
        super();
    }

}
