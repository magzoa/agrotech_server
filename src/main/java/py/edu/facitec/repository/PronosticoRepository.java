		package py.edu.facitec.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import py.edu.facitec.model.Pronostico;

/**
* @author  Magno Portillo
* @version 1.0
*/	

public interface PronosticoRepository extends JpaRepository<Pronostico, Long> {
		
		}
