package co.edu.uniquindio.proyecto.modelo.entidades;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import java.io.Serializable;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Getter
@Setter
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Usuario implements Serializable {
    @Id
    @EqualsAndHashCode.Include
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "id_usuario",length = 20,unique = true)
    private String idUsuario;

    @Email
    @NotNull
    @Column(unique = true)
    private String email;

    @NotNull
    private String nombre;

    @Column(nullable = false, length = 64)
    @Size(min = 6, max = 64)
    private String password;

    @Enumerated(EnumType.STRING)
    private TipoUsuario tipo;

    @OneToOne(mappedBy = "usuario")
    private RespuestaPQRS RespuestaPQRS;

    public Usuario() {
        super();
    }
}
