
package daniel.CrudRestaurante.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "menus")
public class Menu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    
    @Column(name = "tipoMenu", length = 60, nullable = false)
    private int tipoMenu;
    
    @Column(name = "nombreMenu", length = 60, nullable = false)
    private String nombreMenu;
    
    @Column(name = "precioMenu", length = 60, nullable = false)
    private double precioMenu;

    public Menu() {
    }

    public Menu(long id, int tipoMenu, String nombreMenu, double precioMenu) {
        this.id = id;
        this.tipoMenu = tipoMenu;
        this.nombreMenu = nombreMenu;
        this.precioMenu = precioMenu;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getTipoMenu() {
        return tipoMenu;
    }

    public void setTipoMenu(int tipoMenu) {
        this.tipoMenu = tipoMenu;
    }

    public String getNombreMenu() {
        return nombreMenu;
    }

    public void setNombreMenu(String nombreMenu) {
        this.nombreMenu = nombreMenu;
    }

    public double getPrecioMenu() {
        return precioMenu;
    }

    public void setPrecioMenu(double precioMenu) {
        this.precioMenu = precioMenu;
    }
    
    
    
    
    
}
    
    

