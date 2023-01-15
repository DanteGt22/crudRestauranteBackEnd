
package daniel.CrudRestaurante.repositorio;

import daniel.CrudRestaurante.modelo.Restaurante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RestauranteRepositorio extends JpaRepository<Restaurante, Long>{
    
}
