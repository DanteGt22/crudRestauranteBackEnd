
package daniel.CrudRestaurante.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "restaurantes")
public class Restaurante {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    
    @Column(name = "razonSocial", length = 60, nullable = false)
    private String razonSocial;
      
    @Column(name = "nombreComercial", length = 60, nullable = false)
    private String nombreComercial;
    
    @Column(name = "tipoRestaurante", length = 60, nullable = false)
    private int tipoRestaurante;
    
    @Column(name = "ciudadUbicacion", length = 60, nullable = false)
    private String ciudadUbicacion;
    
    @Column(name = "horaApertura", length = 60, nullable = false)
    private String horaApertura;
    
    @Column(name = "horaCierre", length = 60, nullable = false)
    private String horaCierre;
    
    public Restaurante(){
        
    }

    public Restaurante(long id, String razonSocial, String nombreComercial, int tipoRestaurante, String ciudadUbicacion, String horaApertura, String horaCierre) {
        this.id = id;
        this.razonSocial = razonSocial;
        this.nombreComercial = nombreComercial;
        this.tipoRestaurante = tipoRestaurante;
        this.ciudadUbicacion = ciudadUbicacion;
        this.horaApertura = horaApertura;
        this.horaCierre = horaCierre;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public String getNombreComercial() {
        return nombreComercial;
    }

    public void setNombreComercial(String nombreComercial) {
        this.nombreComercial = nombreComercial;
    }

    public int getTipoRestaurante() {
        return tipoRestaurante;
    }

    public void setTipoRestaurante(int tipoRestaurante) {
        this.tipoRestaurante = tipoRestaurante;
    }

    public String getCiudadUbicacion() {
        return ciudadUbicacion;
    }

    public void setCiudadUbicacion(String ciudadUbicacion) {
        this.ciudadUbicacion = ciudadUbicacion;
    }

    public String getHoraApertura() {
        return horaApertura;
    }

    public void setHoraApertura(String horaApertura) {
        this.horaApertura = horaApertura;
    }

    public String getHoraCierre() {
        return horaCierre;
    }

    public void setHoraCierre(String horaCierre) {
        this.horaCierre = horaCierre;
    }
    
    
    
    
}
