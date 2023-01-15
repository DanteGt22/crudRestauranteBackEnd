package daniel.CrudRestaurante.controlador;

import daniel.CrudRestaurante.excepciones.resourceNotFoundException;
import daniel.CrudRestaurante.modelo.Restaurante;
import daniel.CrudRestaurante.repositorio.RestauranteRepositorio;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/")
@CrossOrigin(origins = "http://localhost:4200")
public class RestauranteControlador {
    

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    @Autowired
    private RestauranteRepositorio repositorio;
    
    //este metodo sirve para listar todos los restaurantes
    @GetMapping("/restaurantes")
    public List<Restaurante> listarTodosLosRestautantes() {
        return repositorio.findAll();
    }
    
    //este metodo sirve para guardar el restaurante
    @PostMapping("/restaurantes")
    public Restaurante guardarRestaurante(@RequestBody Restaurante restaurante){
        return repositorio.save(restaurante);
    }
    
    //este metodo sirve para buscar un restaurante por id
    @GetMapping ("/restaurantes/{id}")
    public ResponseEntity<Restaurante> obtenerRestaurantePorId(@PathVariable Long id){
        Restaurante restaurante = repositorio.findById(id)
                                  .orElseThrow(()-> new resourceNotFoundException("No existe el restaurante con el ID: "+ id));
        return ResponseEntity.ok(restaurante);
    }
    
    @PutMapping ("/restaurantes/{id}")
    public ResponseEntity<Restaurante> actualizarRestaurante(@PathVariable Long id, @RequestBody Restaurante detallesRestaurante){
        Restaurante restaurante = repositorio.findById(id)
                                  .orElseThrow(()-> new resourceNotFoundException("No existe el restaurante con el ID: "+ id));
        restaurante.setRazonSocial(detallesRestaurante.getRazonSocial());
        restaurante.setNombreComercial(detallesRestaurante.getNombreComercial());
        restaurante.setTipoRestaurante(detallesRestaurante.getTipoRestaurante());
        restaurante.setCiudadUbicacion(detallesRestaurante.getCiudadUbicacion());
        restaurante.setHoraApertura(detallesRestaurante.getHoraApertura());
        restaurante.setHoraCierre(detallesRestaurante.getHoraCierre());
        
        Restaurante restauranteActualizado = repositorio.save(restaurante);
        return ResponseEntity.ok(restauranteActualizado); 
    }
    
     //este metodo sirve para eliminar un restaurante
     @DeleteMapping("/restaurantes/{id}")
     
     public ResponseEntity<Map<String,Boolean>> eliminarRestaurante(@PathVariable Long id){
         Restaurante restaurante = repositorio.findById(id)
                                              .orElseThrow(() -> new resourceNotFoundException("No existe el restaurante con el ID : " + id));
         repositorio.delete(restaurante);
         Map<String, Boolean> respuesta = new HashMap<>();
         respuesta.put("eliminar", Boolean.TRUE);
         return ResponseEntity.ok(respuesta);
         
     }
 ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////       
 
    }
  

