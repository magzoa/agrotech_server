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

import py.edu.facitec.model.Tutorial;
import py.edu.facitec.repository.TutorialRepository;



import org.springframework.data.jpa.repository.JpaRepository;


/**
* @author  Magno Portillo
* @version 1.0
*/	

@RestController
@RequestMapping("/api")
@Tag(name = "Tutorial",description = "Api de la entidad Tutorial")	
public class TutorialController  {

@Autowired
	private TutorialRepository tutorialRepository;
	



@Operation(summary="Retorna una lista de Tutorial",description = "Retorna una lista con todos los Tutorials")
	@ApiResponses(value = { 
			  @ApiResponse(responseCode = "200", description = "Consulta de datos exitosa", 
		    content = { @Content(mediaType = "application/json") })
			})
	@GetMapping("/tutorials")
public ResponseEntity<List<Tutorial>> getAll(){
	
	List<Tutorial> tutorials=tutorialRepository.findAll();
	
	return new ResponseEntity<List<Tutorial>>(tutorials, HttpStatus.OK);
}



@Operation(summary="Guarda un Tutorial")
	@ApiResponses(value = { 
			  @ApiResponse(responseCode = "200", description = "Registro exitoso", 
		    content = { @Content(mediaType = "application/json") })
			})
	@PostMapping("/tutorial")						
	public ResponseEntity<Tutorial> create(@RequestBody Tutorial tutorial){
		try {
			
			Tutorial tutorialretorno=tutorialRepository.save(tutorial);
			return new ResponseEntity<Tutorial>(tutorialretorno, HttpStatus.OK);
		} catch (Exception e) {
			
			return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
		}
		}




@Operation(summary="Retorna un Tutorial unico")
	@ApiResponses(value = { 
			  @ApiResponse(responseCode = "200", description = "Consulta de datos exitosa", 
		    content = { @Content(mediaType = "application/json") })
			})
	@GetMapping("/tutorial/{id}")	
	public ResponseEntity<Tutorial> getOne(@PathVariable Long id){
		

		Optional<Tutorial> tutorial=tutorialRepository.findById(id);
		
		if(tutorial.isPresent()) {
			
			return new ResponseEntity<Tutorial>(tutorial.get(), HttpStatus.OK);
		}else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		
	}


@Operation(summary="Elimina un Tutorial")
	@ApiResponses(value = { 
			  @ApiResponse(responseCode = "200", description = "Eliminación exitosa"),
			  @ApiResponse(responseCode = "417", description = "Registro no encontrado")
			})
	@DeleteMapping("/tutorial/{id}")
	public ResponseEntity<Tutorial>  deleteById(@PathVariable Long id){
		
		try {
			tutorialRepository.deleteById(id);
			
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
		}
		
		
	}



		
		}
