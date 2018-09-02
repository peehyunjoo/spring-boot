package org.zzu.persistence;

import org.springframework.data.repository.CrudRepository;
import org.zzu.domain.WebBoard;

public interface CustomCrudRepository extends CrudRepository<WebBoard, Long>, CustomWebBoard{

}
