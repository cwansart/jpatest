package de.cwansart.jpatest.domain;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import javax.transaction.UserTransaction;

@ApplicationScoped
public class DefaultUserService implements UserService {

  @PersistenceContext
  private EntityManager em;

  @Inject
  UserTransaction transaction;

  public List<User> getAll() {
    Query query = em.createQuery("SELECT u FROM User u");
    return (List<User>) query.getResultList();
  }

  public User getById(final Long id) {
    return em.find(User.class, id);
  }

  @Transactional
  public void store(final User user) {
    em.persist(user);
  }
}
