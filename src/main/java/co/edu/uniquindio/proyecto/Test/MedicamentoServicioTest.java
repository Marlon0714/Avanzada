package co.edu.uniquindio.proyecto.Test;


import co.edu.uniquindio.proyecto.modelo.entidades.Medicamento;
import co.edu.uniquindio.proyecto.servicios.interfaces.MedicamentoServicio;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional
public class MedicamentoServicioTest {

    @Autowired
    private MedicamentoServicio medicamentoServicio;

    @Test
    @Sql("classpath:pruebas.sql")
    public void crearMedicamento(){
        Medicamento medicamento = new Medicamento();
        medicamento.setIdMedicamento(1L);
        medicamento.setNombre("Paracetamol");
        medicamento.setDescripcion("Medicamento para el dolor");
        try{
            medicamentoServicio.registrarMedicamento(medicamento);
            Medicamento m = medicamentoServicio.obtenerMedicamento(1L);
            System.out.println(m.getNombre());
            Assertions.assertNotNull(m);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    //Método para actualizar
    @Test
    @Sql("classpath:pruebas.sql")
    public void actualizarMedicamento() throws Exception{
        Medicamento m = medicamentoServicio.obtenerMedicamento(1L);
        System.out.println("Nombre antiguo: " + m.getNombre());
        m.setNombre("Agua");
        medicamentoServicio.actualizarMedicamento(m);
        System.out.println(m.getNombre());
        Assertions.assertEquals("Agua", m.getNombre());
    }

    //Método para eliminar
    @Test
    @Sql("classpath:pruebas.sql")
    public void eliminarMedicamento() throws Exception{
        try{
            medicamentoServicio.eliminarMedicamento(1L);
            Assertions.assertThrows(Exception.class, ()-> medicamentoServicio.obtenerMedicamento(1L));
        }catch (Exception e){
            Assertions.assertTrue(e.getMessage().equals("No existe un medicamento con el id dado"));
        }
    }
    //Método para obtener
    @Test
    @Sql("classpath:pruebas.sql")
    public void obtenerMedicamento() throws Exception{
        Medicamento m = medicamentoServicio.obtenerMedicamento(1L);
        System.out.println(m.getNombre());
        Assertions.assertNotNull(m);
    }

    //Test para listar
    @Test
    @Sql("classpath:pruebas.sql")
    public void listarMedicamentos(){
        medicamentoServicio.listarMedicamentos().forEach(medicamento -> System.out.println(medicamento.getNombre()));
    }

}
