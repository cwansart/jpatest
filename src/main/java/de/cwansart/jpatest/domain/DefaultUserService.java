package de.cwansart.jpatest.domain;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@ApplicationScoped
public class DefaultUserService implements UserService {

  @PersistenceContext
  private EntityManager em;

  public List<User> getAll() {
    Query query = em.createQuery("SELECT u FROM User u");
    return (List<User>) query.getResultList();
  }

  public User getById(final Integer id) {
    return null;
  }

  public void store(final User user) {
    em.persist(user);
  }
}
