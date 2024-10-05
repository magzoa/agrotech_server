		package py.edu.facitec.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import py.edu.facitec.model.Usuario;

/**
* @author  Magno Portillo
* @version 1.0
*/	

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
		
		}
