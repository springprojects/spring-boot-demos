package com.gaodashang.demo.repository;

import com.gaodashang.demo.domain.Order;
import org.springframework.data.repository.CrudRepository;

/**
 * comments.
 *
 * @author eva
 */
public interface OrderRepository extends CrudRepository<Order, Long> {
}
