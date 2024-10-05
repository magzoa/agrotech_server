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

import py.edu.facitec.model.Usuario;
import py.edu.facitec.repository.UsuarioRepository;



import org.springframework.data.jpa.repository.JpaRepository;


/**
* @author  Magno Portillo
* @version 1.0
*/	

@RestController
@RequestMapping("/api")
@Tag(name = "Usuario",description = "Api de la entidad Usuario")	
public class UsuarioController  {

@Autowired
	private UsuarioRepository usuarioRepository;
	



@Operation(summary="Retorna una lista de Usuario",description = "Retorna una lista con todos los Usuarios")
	@ApiResponses(value = { 
			  @ApiResponse(responseCode = "200", description = "Consulta de datos exitosa", 
		    content = { @Content(mediaType = "application/json") })
			})
	@GetMapping("/usuarios")
public ResponseEntity<List<Usuario>> getAll(){
	
	List<Usuario> usuarios=usuarioRepository.findAll();
	
	return new ResponseEntity<List<Usuario>>(usuarios, HttpStatus.OK);
}



@Operation(summary="Guarda un Usuario")
	@ApiResponses(value = { 
			  @ApiResponse(responseCode = "200", description = "Registro exitoso", 
		    content = { @Content(mediaType = "application/json") })
			})
	@PostMapping("/usuario")						
	public ResponseEntity<Usuario> create(@RequestBody Usuario usuario){
		try {
			
			Usuario usuarioretorno=usuarioRepository.save(usuario);
			return new ResponseEntity<Usuario>(usuarioretorno, HttpStatus.OK);
		} catch (Exception e) {
			
			return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
		}
		}




@Operation(summary="Retorna un Usuario unico")
	@ApiResponses(value = { 
			  @ApiResponse(responseCode = "200", description = "Consulta de datos exitosa", 
		    content = { @Content(mediaType = "application/json") })
			})
	@GetMapping("/usuario/{id}")	
	public ResponseEntity<Usuario> getOne(@PathVariable Long id){
		

		Optional<Usuario> usuario=usuarioRepository.findById(id);
		
		if(usuario.isPresent()) {
			
			return new ResponseEntity<Usuario>(usuario.get(), HttpStatus.OK);
		}else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		
	}


@Operation(summary="Elimina un Usuario")
	@ApiResponses(value = { 
			  @ApiResponse(responseCode = "200", description = "Eliminación exitosa"),
			  @ApiResponse(responseCode = "417", description = "Registro no encontrado")
			})
	@DeleteMapping("/usuario/{id}")
	public ResponseEntity<Usuario>  deleteById(@PathVariable Long id){
		
		try {
			usuarioRepository.deleteById(id);
			
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
		}
		
		
	}



		
		}
