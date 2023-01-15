
package daniel.CrudRestaurante.controlador;

import daniel.CrudRestaurante.excepciones.resourceNotFoundException;
import daniel.CrudRestaurante.modelo.Ingrediente;
import daniel.CrudRestaurante.repositorio.IngredineteRepositorio;
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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api3/v1/")
@CrossOrigin(origins = "http://localhost:4200")
public class IngredienteControlador {
    
    @Autowired
    private IngredineteRepositorio repositorio;
    @GetMapping("/ingredientes")
    public List<Ingrediente> listarTodosLosIngredientes() {
        return repositorio.findAll();
    }
    
        //este metodo sirve para guardar el ingrediente
    @PostMapping("/ingredientes")
    public Ingrediente guardarIngrediente(@RequestBody Ingrediente ingrediente){
        return repositorio.save(ingrediente);
    }
    
         //este metodo sirve para eliminar un menu
     @DeleteMapping("/ingredientes/{id}")
     
     public ResponseEntity<Map<String,Boolean>> eliminarIngrediente(@PathVariable Long id){
         Ingrediente ingrediente = repositorio.findById(id)
                                              .orElseThrow(() -> new resourceNotFoundException("No existe el ingrediente con el ID : " + id));
         repositorio.delete(ingrediente);
         Map<String, Boolean> respuesta = new HashMap<>();
         respuesta.put("eliminar", Boolean.TRUE);
         return ResponseEntity.ok(respuesta);
         
     }  
    
    
    
}
