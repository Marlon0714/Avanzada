package co.edu.uniquindio.proyecto.Test;

import co.edu.uniquindio.proyecto.modelo.entidades.Consulta;
import co.edu.uniquindio.proyecto.servicios.interfaces.ConsultaServicio;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

@SpringBootTest
@Transactional
public class ConsultaServicioTest {

    @Autowired
    private ConsultaServicio consultaServicio;

    @Test
    @Sql("classpath:pruebas.sql")
    public void registrarConsulta() {
        Consulta consulta = new Consulta();
        consulta.setIdConsulta(6L);
        consulta.setDiagnostico("Dolor de cabeza");
        consulta.setNotasMedico("Tomar acetaminofen");
        consulta.setFecha(LocalDate.parse("2021-10-10"));
        try {
            consultaServicio.registrarConsulta(consulta);
            System.out.println(consulta);
            Assertions.assertNotNull(consulta);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //Test para actualizar una consulta
    @Test
    @Sql("classpath:pruebas.sql")
    public void actualizarConsulta() throws Exception {
        Consulta c = consultaServicio.obtenerConsulta(1L);
        System.out.println("Diagnostico antiguo: " + c.getDiagnostico());
        c.setDiagnostico("Dolor de cabeza");
        consultaServicio.actualizarConsulta(c);
        System.out.println(c.getDiagnostico());
        Assertions.assertEquals("Dolor de cabeza", c.getDiagnostico());
    }

    //Test para eliminar una consulta
    @Test
    @Sql("classpath:pruebas.sql")
    public void eliminarConsulta() throws Exception {
        try {
            consultaServicio.eliminarConsulta(1L);
            Assertions.assertThrows(Exception.class, () -> consultaServicio.obtenerConsulta(1L));
        } catch (Exception e) {
            Assertions.assertTrue(e.getMessage().equals("No existe una consulta con el id dado"));
        }

    }

    //Test para obtener una consulta e imprimirla
    @Test
    @Sql("classpath:pruebas.sql")
    public void obtenerConsulta() throws Exception {
        Consulta c = consultaServicio.obtenerConsulta(1L);
        System.out.println(c.getDiagnostico());
        Assertions.assertEquals("Diagnóstico 1", c.getDiagnostico());
    }
    //Test para listar las consultas
    @Test
    @Sql("classpath:pruebas.sql")
    public void listarConsultas() {
        consultaServicio.listarConsultas().forEach(consulta -> System.out.println(consulta.getDiagnostico()));
    }
}
