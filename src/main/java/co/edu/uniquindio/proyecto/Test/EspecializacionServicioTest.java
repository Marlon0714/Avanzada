package co.edu.uniquindio.proyecto.Test;

import co.edu.uniquindio.proyecto.modelo.entidades.Especializacion;
import co.edu.uniquindio.proyecto.servicios.interfaces.EspecializacionServicio;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional
public class EspecializacionServicioTest {

    @Autowired
    private EspecializacionServicio especializacionServicio;


    @Test
    public void registrarEspecializacion() throws Exception {
        Especializacion e = new Especializacion();
        e.setIdEspecializacion(6L);
        e.setNombre("Medicina general");
        e.setDescripcion("Medicina general");
        especializacionServicio.registrarEspecializacion(e);
        System.out.println(e);
        Especializacion e2 = especializacionServicio.obtenerEspecializacion(6L);
        Assertions.assertNotNull(e2);
    }

    //Test para actualizar
    @Test
    @Sql("classpath:pruebas.sql")
    public void actualizarEspecializacion() throws Exception {
        Especializacion e = especializacionServicio.obtenerEspecializacion(1L);
        System.out.println("Nombre antiguo: " + e.getNombre());
        e.setNombre("Medicina general");
        especializacionServicio.actualizarEspecializacion(e);
        System.out.println(e.getNombre());
        Assertions.assertEquals("Medicina general", e.getNombre());
    }

    //Test para eliminar
    @Test
    @Sql("classpath:pruebas.sql")
    public void eliminarEspecializacion() throws Exception {
        try {
            especializacionServicio.eliminarEspecializacion(1L);
            Assertions.assertThrows(Exception.class, () -> especializacionServicio.obtenerEspecializacion(1L));
        } catch (Exception e) {
            Assertions.assertTrue(e.getMessage().equals("No existe una especializacion con el id dado"));
        }
    }

    //Test para obtener
    @Test
    @Sql("classpath:pruebas.sql")
    public void obtenerEspecializacion() throws Exception {
        Especializacion e = especializacionServicio.obtenerEspecializacion(1L);
        System.out.println(e);
        Assertions.assertNotNull(e);
    }

}
