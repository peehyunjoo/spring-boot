package org.zzu;

import java.util.Collection;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit4.SpringRunner;
import org.zzu.domain.Board;
import org.zzu.domain.QBoard;
import org.zzu.persistence.BoardRepository;

import com.querydsl.core.BooleanBuilder;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Boot03ApplicationTests {

	@Autowired
	private BoardRepository repo;
	
	@Test
	public void testWInsert200() {
		for(int i =0; i <=200; i++) {
			Board board = new Board();
			board.setTitle("제목:" + i);
			board.setContent("내용:" + i);
			board.setWriter("작성자:" + i);
			//repo.save(board);
		}
	}
	
	@Test
	public void testByTitle() {
		repo.findBoardByTitle("제목:149").forEach(board-> System.out.println(board));
	}
	
	@Test
	public void testBnoOrderByPaging() {
		Pageable paging = PageRequest.of(0,10);
		List<Board> results = repo.findByBnoGreaterThanOrderByBnoDesc(0L, paging);
		results.forEach(board-> System.out.println(board));
	}
	
	@Test
	public void testPredicate() {
		
		String type = "t";
		String keyword = "17";
		
		BooleanBuilder builder = new BooleanBuilder();
		
		QBoard board = QBoard.board;
		
		if(type.equals("t")) {
			builder.and(board.title.like("%" + keyword + "%"));
		}
		
		builder.and(board.bno.gt(0L));
		Pageable pageable = PageRequest.of(0, 10);
		
		Page<Board> result = repo.findAll(builder,pageable);
		
		System.out.println("PAGE SIZE: " + result.getSize());
		System.out.println("TOTAL PAGES:" + result.getTotalPages());
		System.out.println("TOTAL COUNT: " + result.getTotalElements());
		System.out.println("NEXT:" + result.nextPageable());
		
		List<Board> list = result.getContent();
		list.forEach(b -> System.out.println(b));
	}
	
	@Test
	public void contextLoads() {
	}

}
