package co.edu.uniquindio.proyecto.Test;

import co.edu.uniquindio.proyecto.modelo.entidades.EPS;
import co.edu.uniquindio.proyecto.servicios.interfaces.EPSServicio;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional
public class EPSServicioTest {

    @Autowired
    private EPSServicio epsServicio;

    //Test para registrar
    @Test
    public void registrarEPS() {
        EPS eps = new EPS();
        eps.setIdEPS("6");
        eps.setNombre("Sura");
        try {
            epsServicio.registrarEPS(eps);
            EPS e2 = epsServicio.obtenerEPS("6");
            System.out.println(e2);
            Assertions.assertNotNull(e2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //Test para actualizar
    @Test
    @Sql("classpath:pruebas.sql")
    public void actualizarEPS() throws Exception {
        EPS e = epsServicio.obtenerEPS("EPS001");
        System.out.println("Nombre antiguo: " + e.getNombre());
        e.setNombre("Sura");
        epsServicio.actualizarEPS(e);
        System.out.println(e.getNombre());
        Assertions.assertEquals("Sura", e.getNombre());
    }

    //Test para eliminar
    @Test
    @Sql("classpath:pruebas.sql")
    public void eliminarEPS() throws Exception {
        try {
            epsServicio.eliminarEPS("EPS001");
            Assertions.assertThrows(Exception.class, () -> epsServicio.obtenerEPS("EPS001"));
        } catch (Exception e) {
            Assertions.assertTrue(e.getMessage().equals("No existe una EPS con el id dado"));
        }

    }
    //Test para obtener
    @Test
    @Sql("classpath:pruebas.sql")
    public void obtenerEPS() throws Exception {
        EPS e = epsServicio.obtenerEPS("EPS001");
        System.out.println(e);
        Assertions.assertNotNull(e);
    }


}