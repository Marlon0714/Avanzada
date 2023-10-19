package co.edu.uniquindio.proyecto.Test.Repositorios;

import co.edu.uniquindio.proyecto.modelo.entidades.*;
import co.edu.uniquindio.proyecto.repositorios.UsuarioRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;


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
    //Test para actualizar
    @Test
    @Sql("classpath:pruebas.sql")
    public void actualizarUsuarioTest() {
    Usuario u = usuarioRepo.findByEmail("emai@email.com").orElse(null);
    System.out.println("Nombre antiguo: " + u.getNombre());
    u.setNombre("Juanita");
    usuarioRepo.save(u);
    System.out.println(u.getNombre());
    Assertions.assertEquals("Juanita", u.getNombre());
    }

}
