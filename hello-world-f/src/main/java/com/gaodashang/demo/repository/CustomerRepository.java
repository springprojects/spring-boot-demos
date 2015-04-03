package com.gaodashang.demo.repository;

import com.gaodashang.demo.domain.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * comments.
 *
 * @author eva
 */
@RepositoryRestResource(excerptProjection = CustomerExcerpt.class)
public interface CustomerRepository extends CrudRepository<Customer, Long> {
}
