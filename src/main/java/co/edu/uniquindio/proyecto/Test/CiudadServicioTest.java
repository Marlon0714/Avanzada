package co.edu.uniquindio.proyecto.Test;

import co.edu.uniquindio.proyecto.modelo.entidades.Ciudad;
import co.edu.uniquindio.proyecto.servicios.interfaces.CiudadServicio;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional
public class CiudadServicioTest {
    @Autowired
    private CiudadServicio ciudadServicio;

    @Test
    @Sql("classpath:pruebas.sql")
    public void registrarCiudad() {
        Ciudad ciudad = new Ciudad();
        ciudad.setIdCiudad("6");
        ciudad.setNombre("Armenia");
        try {
            ciudadServicio.registrarCiudad(ciudad);
            System.out.println(ciudad);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //Método para actualizar ciudad
    @Test
    @Sql("classpath:pruebas.sql")
    public void actualizarCiudad() throws Exception {
        Ciudad c = ciudadServicio.obtenerCiudad("1");
        System.out.println("Nombre antiguo: " + c.getNombre());
        c.setNombre("Armenia");
        ciudadServicio.actualizarCiudad(c);
        System.out.println(c.getNombre());
    }

    //Método para eliminar ciudad
    @Test
    @Sql("classpath:pruebas.sql")
    public void eliminarCiudad(){
        try {
            ciudadServicio.eliminarCiudad("1");
            Assertions.assertThrows(Exception.class, () -> ciudadServicio.obtenerCiudad("1"));
        } catch (Exception e) {
            Assertions.assertTrue(e.getMessage().equals("No existe una ciudad con el id dado"));
        }
    }

    //Método para obtener ciudad
    @Test
    @Sql("classpath:pruebas.sql")
    public void obtenerCiudad() throws Exception {
            Ciudad c = ciudadServicio.obtenerCiudad("1");
            System.out.println(c);
            Assertions.assertEquals("1", c.getIdCiudad());
    }

}
