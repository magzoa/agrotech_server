		package py.edu.facitec.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import py.edu.facitec.model.About;

/**
* @author  Magno Portillo
* @version 1.0
*/	

public interface AboutRepository extends JpaRepository<About, Long> {
		
		}
