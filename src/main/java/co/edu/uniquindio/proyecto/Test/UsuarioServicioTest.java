package co.edu.uniquindio.proyecto.Test;

import co.edu.uniquindio.proyecto.modelo.entidades.Usuario;
import co.edu.uniquindio.proyecto.servicios.interfaces.UsuarioServicio;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional
public class UsuarioServicioTest {

    @Autowired
    private UsuarioServicio usuarioServicio;

    @Test
    public void registrarUsuario() {
        Usuario u = new Usuario();
        u.setIdUsuario("111");
        u.setNombre("Juanita");
        u.setEmail("email@email.com");
        u.setPassword("1234");
        try{
            usuarioServicio.registrarUsuario(u);
            Usuario guardado = usuarioServicio.obtenerUsuario("111");
            Assertions.assertNotNull(guardado);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    //Test para actualizar
    @Test
    @Sql("classpath:pruebas.sql")
    public void actualizarUsuario() throws Exception {
        Usuario u = usuarioServicio.obtenerUsuario("1");
        System.out.println("Nombre antiguo: " + u.getNombre());
        u.setNombre("Juanita");
        usuarioServicio.actualizarUsuario(u);
        System.out.println(u.getNombre());
        Assertions.assertEquals("Juanita", u.getNombre());
    }
    //Test para eliminar
    @Test
    @Sql("classpath:pruebas.sql")
    public void eliminarUsuario() throws Exception {
        try {
            usuarioServicio.eliminarUsuario("1");
            Assertions.assertThrows(Exception.class, () -> usuarioServicio.obtenerUsuario("1"));
        } catch (Exception e) {
            Assertions.assertTrue(e.getMessage().equals("No existe un usuario con el id dado"));
        }

    }
    //Test para obtener
    @Test
    @Sql("classpath:pruebas.sql")
    public void obtenerUsuario() throws Exception{
        Usuario usuario = usuarioServicio.obtenerUsuario("2");
        System.out.println(usuario);
        Assertions.assertNotNull(usuario);
    }


}
