package co.edu.uniquindio.proyecto.Test;

import co.edu.uniquindio.proyecto.modelo.entidades.Cita;
import co.edu.uniquindio.proyecto.servicios.interfaces.CitaServicio;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import java.time.LocalDate;
import java.time.LocalTime;

@SpringBootTest
@Transactional
public class CitaServicioTest {

    @Autowired
    private CitaServicio citaServicio;

    @Test
    @Sql("classpath:pruebas.sql")
    public void registrarCita() {
        Cita cita = new Cita();
        cita.setIdCita(1L);
        cita.setFecha(LocalDate.parse("2021-10-10"));
        cita.setHora(LocalTime.parse("10:00"));
        cita.setMotivo("Cita de prueba");
        try {
            citaServicio.registrarCita(cita);
            System.out.println(cita);
            Assertions.assertNotNull(cita);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Test
    @Sql("classpath:pruebas.sql")
    public void actualizarCita() throws Exception {
        Cita c = citaServicio.obtenerCita(1L);
        System.out.println("Motivo antiguo: " + c.getMotivo());
        c.setMotivo("Cita de prueba");
        citaServicio.actualizarCita(c);
        Cita b = c;
        System.out.println(b);
        Assertions.assertEquals("Cita de prueba", c.getMotivo());
    }
    @Test
    @Sql("classpath:pruebas.sql")
    public void eliminarCita() throws Exception{
        try{
         citaServicio.eliminarCita(1L);
         Assertions.assertThrows(Exception.class,()->citaServicio.obtenerCita(1L));
        }catch (Exception e){
            Assertions.assertTrue(e.getMessage().equals("No existe una cita con el id dado"));
        }
    }
    //Test para el metodo de obtener cita
    @Test
    @Sql("classpath:pruebas.sql")
    public void obtenerCita() throws Exception{
        Cita c = citaServicio.obtenerCita(1L);
        System.out.println(c);
        Assertions.assertNotNull(c);
    }
}
