package com.gaodashang.demo.repository;

import com.gaodashang.demo.domain.Person;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "people", path = "people")
public interface PersonRepository extends PagingAndSortingRepository<Person, Long> {
    
    List<Person> findByFirstName(@Param("name") String name);

	List<Person> findByLastName(@Param("name") String name);
	
	//@Query("select p from Person p where p.firstName = ?1 and p.lastName = ?2")
	List<Person> findByFirstNameAndLastName(@Param("firstName") String firstName, @Param("lastName") String lastName);
	
	List<Person> findByFirstNameLike(@Param("name") String name);
	
	@Query("select p from Person p where p.firstName = :firstName")
	List<Person> querySql(@Param("firstName") String firstName);
	
	@Query("select p from Person p where p.firstName = :firstName and p.lastName = :lastName")
	List<Person> querySql2(@Param("firstName") String firstName, @Param("lastName") String lastName);

	@Query(nativeQuery = true, value = "SELECT d.* FROM person d WHERE d.id = :id ")
	List<Person> queryNativeSql(@Param("id") Long id);

}
