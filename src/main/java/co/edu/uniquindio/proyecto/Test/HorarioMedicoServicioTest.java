package co.edu.uniquindio.proyecto.Test;

import co.edu.uniquindio.proyecto.modelo.entidades.HorarioMedico;
import co.edu.uniquindio.proyecto.modelo.entidades.Medico;
import co.edu.uniquindio.proyecto.servicios.interfaces.HorarioMedicoServicio;
import co.edu.uniquindio.proyecto.servicios.interfaces.MedicoServicio;
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
public class HorarioMedicoServicioTest {

    @Autowired
    private HorarioMedicoServicio horarioMedicoServicio;
    @Autowired
    private MedicoServicio medicoServicio;

    @Test
    @Sql("classpath:pruebas.sql")
    public void registrarHorarioMedicoTest() throws Exception {
        HorarioMedico horarioMedico = new HorarioMedico();
        horarioMedico.setIdHorario("1");
        horarioMedico.setHoraInicio(LocalTime.parse("08:00:00"));
        horarioMedico.setHoraFinal(LocalTime.parse("12:00:00"));
        horarioMedico.setFechaDiaLibre(LocalDate.parse("2021-10-10"));

        Medico m = medicoServicio.obtenerMedico("usuario1");
        horarioMedico.setMedico(m);


        try{
            horarioMedicoServicio.registrarHorarioMedico(horarioMedico);
            HorarioMedico h = horarioMedico;
            System.out.println(h);
            Assertions.assertNotNull(h);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    //Test para actualizar un horario medico
    @Test
    @Sql("classpath:pruebas.sql")
    public void actualizarHorarioMedicoTest() throws Exception {
        HorarioMedico horarioMedico = horarioMedicoServicio.obtenerHorarioMedico("123");
        System.out.println("Hora inicio antigua: " + horarioMedico.getHoraInicio());
        horarioMedico.setHoraInicio(LocalTime.parse("08:00:00"));
        horarioMedicoServicio.actualizarHorarioMedico(horarioMedico);
        System.out.println(horarioMedico.getHoraInicio());
        Assertions.assertEquals(LocalTime.parse("08:00:00"), horarioMedico.getHoraInicio());
    }

    //Test para eliminar un horario
    @Test
    @Sql("classpath:pruebas.sql")
    public void eliminarHorarioMedicoTest() throws Exception {
        try {
            horarioMedicoServicio.eliminarHorarioMedico("123");
            Assertions.assertThrows(Exception.class, () -> horarioMedicoServicio.obtenerHorarioMedico("123"));
        } catch (Exception e) {
            Assertions.assertTrue(e.getMessage().equals("No existe un horario con el id dado"));
        }

    }
    //Test para obtener un horario
    @Test
    @Sql("classpath:pruebas.sql")
    public void obtenerHorarioMedicoTest() throws Exception {
        HorarioMedico horarioMedico = horarioMedicoServicio.obtenerHorarioMedico("123");
        System.out.println(horarioMedico);
        Assertions.assertNotNull(horarioMedico);
    }

    //Test para listar los horarios
    @Test
    @Sql("classpath:pruebas.sql")
    public void listarHorariosMedicosTest() {
        horarioMedicoServicio.listarHorariosMedicos().forEach(horarioMedico -> System.out.println(horarioMedico.getHoraInicio()));
    }

}
