package com.gaodashang.demo.repository;

import com.gaodashang.demo.domain.User;

import java.util.List;

/**
 * comments.
 *
 * @author eva
 */
public interface UserRepositoryCustom {

    List<User> myCustomBatchOperation();

}
