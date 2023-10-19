package co.edu.uniquindio.proyecto.Test;

import co.edu.uniquindio.proyecto.modelo.entidades.PQRS;
import co.edu.uniquindio.proyecto.modelo.entidades.RespuestaPQRS;
import co.edu.uniquindio.proyecto.servicios.interfaces.PQRSServicio;
import co.edu.uniquindio.proyecto.servicios.interfaces.RespuestaPQRSServicio;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalTime;

@SpringBootTest
@Transactional
public class RespuestaPQRSServicioTest {

    @Autowired
    private RespuestaPQRSServicio respuestaPQRSServicio;
    @Autowired
    private PQRSServicio pqrsServicio;

    @Test
    @Sql("classpath:pruebas.sql")
    public void registrarRespuestaPQRS() throws Exception {

        RespuestaPQRS respuestaPQRS = new RespuestaPQRS();
        respuestaPQRS.setDetalle("Respuesta a la PQRS");
        PQRS pqrs = pqrsServicio.obtenerPQRS(1L);
        respuestaPQRS.setIdRespuesta(10L);
        respuestaPQRS.setPqrs(pqrs);
        respuestaPQRS.setFechaCreacion(LocalDate.parse("2021-10-10"));
        respuestaPQRS.setHoraCreacion(LocalTime.parse("08:00:00"));
        System.out.println(respuestaPQRS);
        respuestaPQRSServicio.registrarRespuestaPQRS(respuestaPQRS);
        RespuestaPQRS r = respuestaPQRSServicio.obtenerRespuestaPQRS(respuestaPQRS.getIdRespuesta());
        System.out.println(r);
        Assertions.assertNotNull(r);
    }
    //Test para actualizar
    @Test
    @Sql("classpath:pruebas.sql")
    public void actualizarRespuestaPQRSTest() throws Exception {

        RespuestaPQRS respuestaPQRS = respuestaPQRSServicio.obtenerRespuestaPQRS(1L);
        respuestaPQRS.setDetalle("Respuesta a la PQRS");
        respuestaPQRSServicio.actualizarRespuestaPQRS(respuestaPQRS);
        RespuestaPQRS respuestaPQRS1 = respuestaPQRSServicio.obtenerRespuestaPQRS(1L);
        System.out.println(respuestaPQRS1);
        Assertions.assertEquals("Respuesta a la PQRS", respuestaPQRS1.getDetalle());
    }
    //Test para eliminar
    @Test
    @Sql("classpath:pruebas.sql")
    public void eliminarRespuestaPQRSTest() throws Exception {
        try {
            respuestaPQRSServicio.eliminarRespuestaPQRS(1L);
            Assertions.assertThrows(Exception.class, () -> respuestaPQRSServicio.obtenerRespuestaPQRS(1L));
        }catch (Exception e){
            Assertions.assertTrue(e.getMessage().equals("No existe una respuestaPQRS con el id dado"));
        }
    }
    //Test para obtener
    @Test
    @Sql("classpath:pruebas.sql")
    public void obtenerRespuestaPQRSTest() throws Exception {
        RespuestaPQRS respuestaPQRS = respuestaPQRSServicio.obtenerRespuestaPQRS(1L);
        System.out.println(respuestaPQRS);
        Assertions.assertEquals("Respuesta 1", respuestaPQRS.getDetalle());
    }

    //Test para listar
    @Test
    @Sql("classpath:pruebas.sql")
    public void listarRespuestaPQRS() {
        respuestaPQRSServicio.listarRespuestasPQRS().forEach(respuestaPQRS -> System.out.println(respuestaPQRS.getDetalle()));
    }
}
