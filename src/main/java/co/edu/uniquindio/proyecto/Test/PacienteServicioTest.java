package co.edu.uniquindio.proyecto.Test;

import co.edu.uniquindio.proyecto.modelo.entidades.Paciente;
import co.edu.uniquindio.proyecto.modelo.entidades.Usuario;
import co.edu.uniquindio.proyecto.servicios.interfaces.PacienteServicio;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional
public class PacienteServicioTest {

    @Autowired
    private PacienteServicio pacienteServicio;

    @Test
    public void registrarPaciente(){
        Usuario u = new Usuario();
        Paciente p = new Paciente();
        u.setIdUsuario("10");
        p.setIdUsuario(u.getIdUsuario());
        p.setNombre("Juan");
        try{
            pacienteServicio.registrarPaciente(p);
            Paciente p1 = pacienteServicio.obtenerPaciente("10");
            System.out.println(p1.getNombre());
    } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    //Test para actualizar

    @Test
    @Sql("classpath:pruebas.sql")
public void actualizarPaciente() throws Exception{
        Paciente p = pacienteServicio.obtenerPaciente("usuario3");
        System.out.println("Nombre antiguo: "+p.getNombre());
        p.setNombre("Ricardo");
        pacienteServicio.actualizarPaciente(p);
        System.out.println(p.getNombre());
        Paciente paciente = pacienteServicio.obtenerPaciente("usuario3");
        Assertions.assertNotEquals("usuario 3",paciente.getNombre());

    }
    //Test para eliminar
    @Test
    @Sql("classpath:pruebas.sql")
    public void eliminarPaciente() throws Exception{
        try{
            pacienteServicio.eliminarPaciente("usuario3");
            Assertions.assertThrows(Exception.class,()->pacienteServicio.obtenerPaciente("usuario3"));
        }catch (Exception e){
            Assertions.assertTrue(e.getMessage().equals("No existe un paciente con el id dado"));
        }
    }
    //Test para obtener
    @Test
    @Sql("classpath:pruebas.sql")
    public void obtenerPaciente() throws Exception{
        Paciente p = pacienteServicio.obtenerPaciente("usuario3");
        System.out.println(p.getNombre());
        Assertions.assertEquals("Usuario 3",p.getNombre());
    }

    //Test para listar
    @Test
    @Sql("classpath:pruebas.sql")
    public void listarPacientes(){
        pacienteServicio.listarPacientes().forEach(paciente -> System.out.println(paciente.getNombre()));
    }

}
