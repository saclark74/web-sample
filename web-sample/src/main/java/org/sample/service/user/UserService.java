package org.sample.service.user;

/**
 * Created by Scott on 6/15/2015.
 */
import org.sample.model.Role;
import org.sample.model.User;
import org.sample.ui.UserCreateForm;

public interface UserService {

//    Optional<User> getUserById(long id);
//
//    Optional<User> getUserByEmail(String email);
//
//    Collection<User> getAllUsers();

    User create(String email, String password, Role role);

}