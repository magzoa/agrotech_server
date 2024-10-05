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

import py.edu.facitec.model.About;
import py.edu.facitec.repository.AboutRepository;



import org.springframework.data.jpa.repository.JpaRepository;


/**
* @author  Magno Portillo
* @version 1.0
*/	

@RestController
@RequestMapping("/api")
@Tag(name = "About",description = "Api de la entidad About")	
public class AboutController  {

@Autowired
	private AboutRepository aboutRepository;
	



@Operation(summary="Retorna una lista de About",description = "Retorna una lista con todos los Abouts")
	@ApiResponses(value = { 
			  @ApiResponse(responseCode = "200", description = "Consulta de datos exitosa", 
		    content = { @Content(mediaType = "application/json") })
			})
	@GetMapping("/abouts")
public ResponseEntity<List<About>> getAll(){
	
	List<About> abouts=aboutRepository.findAll();
	
	return new ResponseEntity<List<About>>(abouts, HttpStatus.OK);
}



@Operation(summary="Guarda un About")
	@ApiResponses(value = { 
			  @ApiResponse(responseCode = "200", description = "Registro exitoso", 
		    content = { @Content(mediaType = "application/json") })
			})
	@PostMapping("/about")						
	public ResponseEntity<About> create(@RequestBody About about){
		try {
			
			About aboutretorno=aboutRepository.save(about);
			return new ResponseEntity<About>(aboutretorno, HttpStatus.OK);
		} catch (Exception e) {
			
			return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
		}
		}




@Operation(summary="Retorna un About unico")
	@ApiResponses(value = { 
			  @ApiResponse(responseCode = "200", description = "Consulta de datos exitosa", 
		    content = { @Content(mediaType = "application/json") })
			})
	@GetMapping("/about/{id}")	
	public ResponseEntity<About> getOne(@PathVariable Long id){
		

		Optional<About> about=aboutRepository.findById(id);
		
		if(about.isPresent()) {
			
			return new ResponseEntity<About>(about.get(), HttpStatus.OK);
		}else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		
	}


@Operation(summary="Elimina un About")
	@ApiResponses(value = { 
			  @ApiResponse(responseCode = "200", description = "Eliminación exitosa"),
			  @ApiResponse(responseCode = "417", description = "Registro no encontrado")
			})
	@DeleteMapping("/about/{id}")
	public ResponseEntity<About>  deleteById(@PathVariable Long id){
		
		try {
			aboutRepository.deleteById(id);
			
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
		}
		
		
	}



		
		}
