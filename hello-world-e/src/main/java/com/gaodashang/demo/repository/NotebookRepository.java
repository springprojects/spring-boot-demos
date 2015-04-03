package com.gaodashang.demo.repository;

import com.gaodashang.demo.domain.Notebook;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;


@RestResource(path = "notebooks")
public interface NotebookRepository extends CrudRepository<Notebook, Long> {

	@RestResource(path = "name", rel = "names")
	public Notebook findByNameLike(@Param("name") String name);

}
