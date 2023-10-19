package co.edu.uniquindio.proyecto.Test;

import co.edu.uniquindio.proyecto.modelo.entidades.PQRS;
import co.edu.uniquindio.proyecto.servicios.interfaces.PQRSServicio;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

@SpringBootTest
@Transactional
public class PQRSservicioTest {

    @Autowired
    private PQRSServicio pqrsServicio;

    //Test oara registrar PQRS
    @Test
    public void registrarPQRS() throws Exception {
        PQRS pqrs = new PQRS();
        pqrs.setFechaCreacion(LocalDate.parse("2021-10-10"));
        pqrs.setDetalle("No me gusta el servicio");
        pqrs.setNumRadicado(1L);
        pqrsServicio.registrarPQRS(pqrs);
        PQRS pqrs2 = pqrsServicio.obtenerPQRS(1L);
        System.out.println(pqrs2.getDetalle());
        Assertions.assertNotNull(pqrs2);
    }

    //Test para actualizar
    @Test
    @Sql("classpath:pruebas.sql")
    public void actualizarPQRS() throws Exception {
        PQRS pqrs = pqrsServicio.obtenerPQRS(1L);
        System.out.println("Detalle antiguo: " + pqrs.getDetalle());
        pqrs.setDetalle("No me gusta el servicio");
        pqrsServicio.actualizarPQRS(pqrs);
        System.out.println(pqrs.getDetalle());
        Assertions.assertEquals("No me gusta el servicio", pqrs.getDetalle());
    }

    //Test para eliminar
    @Test
    @Sql("classpath:pruebas.sql")
    public void eliminarPQRS() throws Exception {
        try {
            pqrsServicio.eliminarPQRS(1L);
            Assertions.assertThrows(Exception.class, () -> pqrsServicio.obtenerPQRS(1L));
        } catch (Exception e) {
            Assertions.assertTrue(e.getMessage().equals("No existe una PQRS con el id dado"));
        }

    }
    //Test para obtener
    @Test
    @Sql("classpath:pruebas.sql")
    public void obtenerPQRS() throws Exception {
        PQRS pqrs = pqrsServicio.obtenerPQRS(1L);
        System.out.println(pqrs);
        Assertions.assertNotNull(pqrs);
    }

    //Test para listar
    @Test
    @Sql("classpath:pruebas.sql")
    public void listarPQRS() {
        pqrsServicio.listarPQRS().forEach(pqrs -> System.out.println(pqrs.getDetalle()));
    }

}
