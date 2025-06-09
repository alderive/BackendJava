package com.example.TestBmx.repositorys;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.TestBmx.Entitys.User;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

@Repository
public class UserRepositoryCustomClass implements UserRepositoryCustom {

	@PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<User> findUsersByCriteria(String name, String email, Integer status, String password) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<User> query = cb.createQuery(User.class);
        Root<User> user = query.from(User.class);

        Predicate predicate = cb.conjunction(); // Start with an empty predicate

        if (name != null) {
            predicate = cb.and(predicate, cb.equal(user.get("name"), name));
        }
        if (email != null) {
            predicate = cb.and(predicate, cb.greaterThan(user.get("email"), email));
        }
        
        if (status != null && status > 0) {
            predicate = cb.and(predicate, cb.greaterThan(user.get("status"), status));
        }
        
        if (password != null) {
            predicate = cb.and(predicate, cb.greaterThan(user.get("password"), password));
        }

        query.where(predicate);
        return entityManager.createQuery(query).getResultList();
    }

}
