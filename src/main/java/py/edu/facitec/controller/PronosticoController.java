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

import py.edu.facitec.model.Pronostico;
import py.edu.facitec.repository.PronosticoRepository;



import org.springframework.data.jpa.repository.JpaRepository;


/**
* @author  Magno Portillo
* @version 1.0
*/	

@RestController
@RequestMapping("/api")
@Tag(name = "Pronostico",description = "Api de la entidad Pronostico")	
public class PronosticoController  {

@Autowired
	private PronosticoRepository pronosticoRepository;
	



@Operation(summary="Retorna una lista de Pronostico",description = "Retorna una lista con todos los Pronosticos")
	@ApiResponses(value = { 
			  @ApiResponse(responseCode = "200", description = "Consulta de datos exitosa", 
		    content = { @Content(mediaType = "application/json") })
			})
	@GetMapping("/pronosticos")
public ResponseEntity<List<Pronostico>> getAll(){
	
	List<Pronostico> pronosticos=pronosticoRepository.findAll();
	
	return new ResponseEntity<List<Pronostico>>(pronosticos, HttpStatus.OK);
}



@Operation(summary="Guarda un Pronostico")
	@ApiResponses(value = { 
			  @ApiResponse(responseCode = "200", description = "Registro exitoso", 
		    content = { @Content(mediaType = "application/json") })
			})
	@PostMapping("/pronostico")						
	public ResponseEntity<Pronostico> create(@RequestBody Pronostico pronostico){
		try {
			
			Pronostico pronosticoretorno=pronosticoRepository.save(pronostico);
			return new ResponseEntity<Pronostico>(pronosticoretorno, HttpStatus.OK);
		} catch (Exception e) {
			
			return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
		}
		}




@Operation(summary="Retorna un Pronostico unico")
	@ApiResponses(value = { 
			  @ApiResponse(responseCode = "200", description = "Consulta de datos exitosa", 
		    content = { @Content(mediaType = "application/json") })
			})
	@GetMapping("/pronostico/{id}")	
	public ResponseEntity<Pronostico> getOne(@PathVariable Long id){
		

		Optional<Pronostico> pronostico=pronosticoRepository.findById(id);
		
		if(pronostico.isPresent()) {
			
			return new ResponseEntity<Pronostico>(pronostico.get(), HttpStatus.OK);
		}else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		
	}


@Operation(summary="Elimina un Pronostico")
	@ApiResponses(value = { 
			  @ApiResponse(responseCode = "200", description = "Eliminación exitosa"),
			  @ApiResponse(responseCode = "417", description = "Registro no encontrado")
			})
	@DeleteMapping("/pronostico/{id}")
	public ResponseEntity<Pronostico>  deleteById(@PathVariable Long id){
		
		try {
			pronosticoRepository.deleteById(id);
			
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
		}
		
		
	}



		
		}
