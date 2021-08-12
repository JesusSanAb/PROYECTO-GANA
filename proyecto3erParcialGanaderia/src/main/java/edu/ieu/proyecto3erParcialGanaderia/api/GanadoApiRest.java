package edu.ieu.proyecto3erParcialGanaderia.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import edu.ieu.proyecto3erParcialGanaderia.entities.Ganadero;
import edu.ieu.proyecto3erParcialGanaderia.servicios.GanaderoService;

@RestController
@RequestMapping("/api/ganado")
public class GanadoApiRest {
	@Autowired
	private GanaderoService service; 
	
	@GetMapping
	public ResponseEntity<List<Ganadero>> listAll(){
	List<Ganadero> listaGanaderos = service.findAll();
	if(listaGanaderos.isEmpty()) {
		return new ResponseEntity<List<Ganadero>>(HttpStatus.NO_CONTENT);
	}
	return new ResponseEntity<List<Ganadero>>(listaGanaderos, HttpStatus.OK);
}

@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
public ResponseEntity<Ganadero> getGanado(@PathVariable("id") int id) {
    System.out.println("Fetching ganado with id " + id);
    Ganadero ganado = service.findById(id);
    if (ganado == null) {
        System.out.println("ganado with id " + id + " not found");
        return new ResponseEntity<Ganadero>(HttpStatus.NOT_FOUND);
    }
    return new ResponseEntity<Ganadero>(ganado, HttpStatus.OK);
}

@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
public ResponseEntity<Void> createGanado(@RequestBody Ganadero ganado){
	System.out.println("Creating phone " + ganado.getTipo_de_animal());
	
	service.saveGanado(ganado);
	 return new ResponseEntity<Void>(HttpStatus.CREATED);
}

@PutMapping(value = "/{id}")
public ResponseEntity<Ganadero> updateCel(@PathVariable("id") int id,
		@RequestBody Ganadero ganado){
	 System.out.println("Updating ganado " + id);
	 Ganadero ganadobd = service.findById(id);
	 if(ganadobd == null) {
		 System.out.println("ganado with id " + id + " not found");
		 return new ResponseEntity<Ganadero>(HttpStatus.NOT_FOUND);
	 }
	 ganadobd.setTipo_de_animal( ganado.getTipo_de_animal() );
	 ganadobd.setEstado_de_salud( ganado.getEstado_de_salud() );
	 ganadobd.setTipo_de_produccion_de_alimentos(ganado.getTipo_de_produccion_de_alimentos());
	 ganadobd.setCosto( ganado.getCosto() );
	 ganadobd.setTiempo_de_produccion( ganado.getTiempo_de_produccion() );
	 
	 
	 service.updateGanado(ganadobd);
	 return new ResponseEntity<Ganadero>(ganadobd, HttpStatus.OK );
}

@DeleteMapping(value="/{id}")
public ResponseEntity<Void> deleteGanado(@PathVariable("id") int id){
	System.out.println("Fetching & Deleting ganado with id " + id);
	Ganadero ganado = service.findById(id);
	if(ganado == null) {
		 System.out.println("Unable to delete. ganado with id " + id + " not found");
		 return new ResponseEntity<Void>(HttpStatus.NOT_FOUND); // 404
	}
	service.deleteGanadoById(id);
	return new ResponseEntity<Void>(HttpStatus.NO_CONTENT); // 204 http
}
}