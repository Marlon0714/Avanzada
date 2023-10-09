package co.edu.uniquindio.proyecto.Test;

import co.edu.uniquindio.proyecto.modelo.entidades.*;
import co.edu.uniquindio.proyecto.modelo.repositorios.UsuarioRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;


@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class UsuarioTest {
    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    private UsuarioRepo usuarioRepo;
    @Test
    public void registrarUsuarioTest(){
        Usuario u = new Usuario();
        u.setIdUsuario("111");
        u.setNombre("Juanita");
        u.setEmail("juana@mail.com");

        //Guardamos el registro
        Usuario guardado = usuarioRepo.save(u);
        //Comprobamos que si haya quedado
        Assertions.assertNotNull(guardado);
    }

}
