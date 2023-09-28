package co.edu.uniquindio.proyecto.modelo.entidades;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@Entity
@Getter
@Setter
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = false)
public class Administrador extends Usuario implements Serializable {

//    @Id
//    @EqualsAndHashCode.Include
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @NotNull
//    @Size(min = 1, max = 20)
//    @AttributeOverride(name = "idUsuario", column = @Column(name = "id_admin", unique = true))
//    private String idAdministrador;

    public Administrador() {
        super();
    }

}
