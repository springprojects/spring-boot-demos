package com.gaodashang.demo.repository;

import com.gaodashang.demo.domain.Note;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;


@RestResource(path = "notes")
public interface NoteRepository extends CrudRepository<Note, Long> {

	@RestResource(path = "title", rel = "titles")
	public Note findByTitleLike(@Param("title") String title);
}
