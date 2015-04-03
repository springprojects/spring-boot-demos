package com.gaodashang.demo.repository;

import com.gaodashang.demo.domain.User;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.CrudRepository;

/**
 * comments.
 *
 * @author eva
 */
public interface UserRepository extends CrudRepository<User, Long> {
    @Procedure(name = "User.plus1")
    Integer plus1BackedByOtherNamedStoredProcedure(Integer arg);

    @Procedure
    Integer plus1inout(Integer arg);
}
