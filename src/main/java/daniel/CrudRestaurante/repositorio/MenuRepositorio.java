
package daniel.CrudRestaurante.repositorio;
import daniel.CrudRestaurante.modelo.Menu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MenuRepositorio extends JpaRepository<Menu, Long>{

}
