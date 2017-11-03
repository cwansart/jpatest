package de.cwansart.jpatest.domain;

import java.util.List;

public interface UserService {

  /**
   * Returns all users saved in the database.
   *
   * @return List of all users.
   */
  public List<User> getAll();

  /**
   * Returns a user to the corresponding id.
   *
   * @param id Id of the user.
   * @return user corresponding to id.
   */
  public User getById(final Long id);

  /**
   * Stores a user in the database.
   *
   * @param user user to be stored.
   */
  public void store(final User user);
}
