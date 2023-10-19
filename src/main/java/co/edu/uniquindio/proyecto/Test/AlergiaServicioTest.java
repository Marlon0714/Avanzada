package co.edu.uniquindio.proyecto.Test;


import co.edu.uniquindio.proyecto.modelo.entidades.Alergia;
import co.edu.uniquindio.proyecto.servicios.interfaces.AlergiaServicio;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

@SpringBootTest
@Transactional
public class AlergiaServicioTest {

    @Autowired
    private AlergiaServicio alergiaServicio;

    @Test
    @Sql("classpath:pruebas.sql")
    public void registrarAlergia() {
        Alergia alergia = new Alergia();
        alergia.setIdAlergia("7");
        alergia.setNombre("Alergia a la penicilina");
        try {
            alergiaServicio.registrarAlergia(alergia);
            Assertions.assertNotNull(alergia);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    @Sql("classpath:pruebas.sql")
    public void actualizarAlergia() throws Exception {
        Alergia a = alergiaServicio.obtenerAlergia("1");
        System.out.println("Nombre antiguo: " + a.getNombre());
        a.setNombre("Alergia a la penicilina");
        alergiaServicio.actualizarAlergia(a);
        System.out.println(a.getNombre());
        Assertions.assertEquals("Alergia a la penicilina", a.getNombre());
    }

    @Test
    @Sql("classpath:pruebas.sql")
    public void eliminarAlergia() throws Exception {
        try {
            alergiaServicio.eliminarAlergia("1");
            Assertions.assertThrows(Exception.class, () -> alergiaServicio.obtenerAlergia("1"));
        } catch (Exception e) {
            Assertions.assertTrue(e.getMessage().equals("No existe una alergia con el id dado"));
        }

    }

    //Test para el metodo de obtener alergia
    @Test
    @Sql("classpath:pruebas.sql")
    public void obtenerAlergia() throws Exception {
        Alergia a = alergiaServicio.obtenerAlergia("1");
        System.out.println(a.getNombre());
        Assertions.assertEquals("Alergia a paracetamol", a.getNombre());
    }

    //Test para el metodo de listar alergias|
    @Test
    @Sql("classpath:pruebas.sql")
    public void listarAlergias() {
        alergiaServicio.listarAlergias().forEach(alergia -> System.out.println(alergia.getNombre()));
    }

}