package com.gaodashang.demo.repository;

import com.gaodashang.demo.domain.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * comments.
 *
 * @author eva
 */
public interface UserRepository extends CrudRepository<User, Long>, UserRepositoryCustom {

    User findByTheUsersName(String userName);

    List<User> findByLastName(String lastName);

    @Query("select u from User u where u.firstName = ?1")
    List<User> findByFirstName(String firstName);

    @Query("select u from User u where u.firstName = :name or u.lastName = :name")
    List<User> findByFirstNameOrLastName(@Param("name") String name);
}
