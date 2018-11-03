package org.zzu.persistence;

import org.springframework.data.repository.CrudRepository;
import org.zzu.domain.QWebBoard;
import org.zzu.domain.WebBoard;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Predicate;

public interface CustomCrudRepository 
    extends CrudRepository<WebBoard, Long>, CustomWebBoard {

	
}
