package org.zzu.persistence;

import org.springframework.data.repository.CrudRepository;
import org.zzu.domain.Board;

public interface BoardRepository extends CrudRepository<Board, Long>{
	
}
