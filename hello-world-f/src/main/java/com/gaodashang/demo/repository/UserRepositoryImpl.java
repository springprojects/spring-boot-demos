package com.gaodashang.demo.repository;

import com.gaodashang.demo.domain.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

/**
 * comments.
 *
 * @author eva
 */
class UserRepositoryImpl implements UserRepositoryCustom {

    @PersistenceContext
    private EntityManager em;

    public void setEntityManager(EntityManager em) {
        this.em = em;
    }

    public List<User> myCustomBatchOperation() {
        CriteriaQuery<User> criteriaQuery = em.getCriteriaBuilder().createQuery(User.class);
        criteriaQuery.select(criteriaQuery.from(User.class));
        return em.createQuery(criteriaQuery).getResultList();
    }
}