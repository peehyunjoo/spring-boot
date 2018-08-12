package org.zzu.persistence;

import java.util.Collection;
import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.CrudRepository;
import org.zzu.domain.Board;

public interface BoardRepository extends CrudRepository<Board, Long>, QuerydslPredicateExecutor<Board>{
	public List<Board> findBoardByTitle(String title);

	public List<Board> findByBnoGreaterThanOrderByBnoDesc(long l, Pageable paging);
}
