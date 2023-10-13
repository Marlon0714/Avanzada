package co.edu.uniquindio.proyecto.repositorios;

import co.edu.uniquindio.proyecto.modelo.entidades.RespuestaPQRS;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RespuestaPQRSRepo extends JpaRepository<RespuestaPQRS, Long> {
}
