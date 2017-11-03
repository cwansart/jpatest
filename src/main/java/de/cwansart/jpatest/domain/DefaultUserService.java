package de.cwansart.jpatest.domain;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.NotSupportedException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;
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

  public void store(final User user) {
    try {
      transaction.begin();
      em.persist(user);
    } catch (NotSupportedException e) {
      e.printStackTrace();
    } catch (SystemException e) {
      e.printStackTrace();
    } finally {
      try {
        transaction.commit();
      } catch (RollbackException e) {
        e.printStackTrace();
      } catch (HeuristicMixedException e) {
        e.printStackTrace();
      } catch (HeuristicRollbackException e) {
        e.printStackTrace();
      } catch (SystemException e) {
        e.printStackTrace();
      }
    }
  }
}
