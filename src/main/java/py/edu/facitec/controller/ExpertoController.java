		package py.edu.facitec.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

import py.edu.facitec.model.Experto;
import py.edu.facitec.repository.ExpertoRepository;



import org.springframework.data.jpa.repository.JpaRepository;


/**
* @author  Magno Portillo
* @version 1.0
*/	

@RestController
@RequestMapping("/api")
@Tag(name = "Experto",description = "Api de la entidad Experto")	
public class ExpertoController  {

@Autowired
	private ExpertoRepository expertoRepository;
	



@Operation(summary="Retorna una lista de Experto",description = "Retorna una lista con todos los Expertos")
	@ApiResponses(value = { 
			  @ApiResponse(responseCode = "200", description = "Consulta de datos exitosa", 
		    content = { @Content(mediaType = "application/json") })
			})
	@GetMapping("/expertos")
public ResponseEntity<List<Experto>> getAll(){
	
	List<Experto> expertos=expertoRepository.findAll();
	
	return new ResponseEntity<List<Experto>>(expertos, HttpStatus.OK);
}



@Operation(summary="Guarda un Experto")
	@ApiResponses(value = { 
			  @ApiResponse(responseCode = "200", description = "Registro exitoso", 
		    content = { @Content(mediaType = "application/json") })
			})
	@PostMapping("/experto")						
	public ResponseEntity<Experto> create(@RequestBody Experto experto){
		try {
			
			Experto expertoretorno=expertoRepository.save(experto);
			return new ResponseEntity<Experto>(expertoretorno, HttpStatus.OK);
		} catch (Exception e) {
			
			return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
		}
		}




@Operation(summary="Retorna un Experto unico")
	@ApiResponses(value = { 
			  @ApiResponse(responseCode = "200", description = "Consulta de datos exitosa", 
		    content = { @Content(mediaType = "application/json") })
			})
	@GetMapping("/experto/{id}")	
	public ResponseEntity<Experto> getOne(@PathVariable Long id){
		

		Optional<Experto> experto=expertoRepository.findById(id);
		
		if(experto.isPresent()) {
			
			return new ResponseEntity<Experto>(experto.get(), HttpStatus.OK);
		}else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		
	}


@Operation(summary="Elimina un Experto")
	@ApiResponses(value = { 
			  @ApiResponse(responseCode = "200", description = "Eliminación exitosa"),
			  @ApiResponse(responseCode = "417", description = "Registro no encontrado")
			})
	@DeleteMapping("/experto/{id}")
	public ResponseEntity<Experto>  deleteById(@PathVariable Long id){
		
		try {
			expertoRepository.deleteById(id);
			
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
		}
		
		
	}



		
		}
