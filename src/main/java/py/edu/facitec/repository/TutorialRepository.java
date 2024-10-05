		package py.edu.facitec.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import py.edu.facitec.model.Tutorial;

/**
* @author  Magno Portillo
* @version 1.0
*/	

public interface TutorialRepository extends JpaRepository<Tutorial, Long> {
		
		}
