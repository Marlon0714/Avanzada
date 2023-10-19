package co.edu.uniquindio.proyecto.Test;

import co.edu.uniquindio.proyecto.modelo.entidades.Medico;
import co.edu.uniquindio.proyecto.modelo.entidades.Usuario;
import co.edu.uniquindio.proyecto.servicios.interfaces.MedicoServicio;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional
public class MedicoServicioTest {

    @Autowired
    private MedicoServicio medicoServicio;

    @Test
    public void registrarMedico(){
        Usuario usuario = new Usuario();
        Medico medico = new Medico();
        usuario.setIdUsuario("1");
        usuario.setEmail("correo@ejemplo.com");
        medico.setIdUsuario(usuario.getIdUsuario());
        medico.setNombre("Juan");

        try{
            medicoServicio.registrarMedico(medico);
            Medico medico1 = medicoServicio.obtenerMedico("1");
            System.out.println(medico1.getNombre());
            Assertions.assertNotNull(medico1);
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    //Test para actualizar
    @Test
    @Sql("classpath:pruebas.sql")
    public void actualizarMedico() throws Exception{
        Medico m = medicoServicio.obtenerMedico("usuario1");
        System.out.println("Nombre antiguo: "+m.getNombre());
        m.setNombre("Ricardo");
        medicoServicio.actualizarMedico(m);
        System.out.println(m.getNombre());
        Medico medico = medicoServicio.obtenerMedico("usuario1");
        Assertions.assertNotEquals("Usuario 1",medico.getNombre());

    }
    //Test para eliminar
    @Test
    @Sql("classpath:pruebas.sql")
    public void eliminarMedico() throws Exception{
        try{
            medicoServicio.eliminarMedico("usuario1");
            Assertions.assertThrows(Exception.class,()->medicoServicio.obtenerMedico("usuario1"));
        }catch (Exception e){
            Assertions.assertTrue(e.getMessage().equals("No existe un medico con el id dado"));
        }
    }
    //Test para obtener
    @Test
    @Sql("classpath:pruebas.sql")
    public void obtenerMedico() throws Exception{
        Medico m = medicoServicio.obtenerMedico("usuario1");
        System.out.println(m.getNombre());
        Assertions.assertEquals("Usuario 1",m.getNombre());
    }
}
