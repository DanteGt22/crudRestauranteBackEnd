
package daniel.CrudRestaurante.controlador;

import daniel.CrudRestaurante.excepciones.resourceNotFoundException;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import daniel.CrudRestaurante.repositorio.MenuRepositorio;
import daniel.CrudRestaurante.modelo.Menu;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api2/v1/")
@CrossOrigin(origins = "http://localhost:4200")
public class MenuControlador {
    
     @Autowired
    private MenuRepositorio repositorio;
    @GetMapping("/menus")
    public List<Menu> listarTodosLosMenus() {
        return repositorio.findAll();
    }
    
    
    //este metodo sirve para guardar el restaurante
    @PostMapping("/menus")
    public Menu guardarRestaurante(@RequestBody Menu menu){
        return repositorio.save(menu);
    }
    
     //este metodo sirve para buscar un menu por id
    @GetMapping ("/menus/{id}")
    public ResponseEntity<Menu> obtenerRestaurantePorId(@PathVariable Long id){
        Menu menu = repositorio.findById(id)
                                  .orElseThrow(()-> new resourceNotFoundException("No existe el menu con el ID: "+ id));
        return ResponseEntity.ok(menu);
    }
    
    //este metodo sirve para actualizar un menu
        @PutMapping ("/menus/{id}")
    public ResponseEntity<Menu> actualizarRestaurante(@PathVariable Long id, @RequestBody Menu detallesMenu){
        Menu menu = repositorio.findById(id)
                                  .orElseThrow(()-> new resourceNotFoundException("No existe el restaurante con el ID: "+ id));
        menu.setTipoMenu(detallesMenu.getTipoMenu());
        menu.setNombreMenu(detallesMenu.getNombreMenu());
        menu.setPrecioMenu(detallesMenu.getPrecioMenu());
                
        Menu menuActualizado = repositorio.save(menu);
        return ResponseEntity.ok(menuActualizado); 
    }
    
     //este metodo sirve para eliminar un menu
     @DeleteMapping("/menus/{id}")
     
     public ResponseEntity<Map<String,Boolean>> eliminarMenu(@PathVariable Long id){
         Menu menu = repositorio.findById(id)
                                              .orElseThrow(() -> new resourceNotFoundException("No existe el menu con el ID : " + id));
         repositorio.delete(menu);
         Map<String, Boolean> respuesta = new HashMap<>();
         respuesta.put("eliminar", Boolean.TRUE);
         return ResponseEntity.ok(respuesta);
         
     }    
         
     }
   

