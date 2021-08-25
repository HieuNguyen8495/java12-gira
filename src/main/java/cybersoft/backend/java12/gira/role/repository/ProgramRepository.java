package cybersoft.backend.java12.gira.role.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import cybersoft.backend.java12.gira.dto.ProgramDto;
import cybersoft.backend.java12.gira.role.entity.Program;

@Repository
public interface ProgramRepository extends JpaRepository<Program, Long>{
	
	@Transactional(readOnly = true)
	@Query("SELECT p FROM Program p")
	List<ProgramDto> findAllDto();

}
