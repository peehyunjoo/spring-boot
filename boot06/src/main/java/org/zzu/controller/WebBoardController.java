package org.zzu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.zzu.domain.WebBoard;
import org.zzu.persistence.WebBoardRepository;
import org.zzu.vo.PageMaker;
import org.zzu.vo.PageVO;

import lombok.extern.java.Log;

@Controller
@RequestMapping("/boards/")
@Log
public class WebBoardController {
	
	@Autowired
	private WebBoardRepository repo;
	@GetMapping("/list")
	public void list(PageVO vo, Model model) {
			Pageable page =vo.makePageable(0, "bno");
			
			Page<WebBoard> result = repo.findAll(repo.makePredicate(null,  null), page);
			
			
			log.info("" + page);
			log.info("" + result);
			
			log.info("TOTAL PAGE NUMBER:" + result.getTotalPages());
			model.addAttribute("result", new PageMaker(result));
		}
}