package org.sample.service.user;

/**
 * Created by Scott on 6/15/2015.
 */
import org.sample.model.Role;
import org.sample.model.User;
import org.sample.repository.UserRepository;
import org.sample.ui.UserCreateForm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private static final Logger LOG = LoggerFactory.getLogger(UserServiceImpl.class);

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

//    @Override
//    public Optional<User> getUserById(long id) {
//        LOG.debug("Getting user={}", id);
//        return Optional.ofNullable(userRepository.findOne(id));
//    }
//
//    @Override
//    public Optional<User> getUserByEmail(String email) {
//        LOG.debug("Getting user by email={}", email.replaceFirst("@.*", "@***"));
//        return userRepository.findOneByEmail(email);
//    }
//
//    @Override
//    public Collection<User> getAllUsers() {
//        LOG.debug("Getting all users");
//        return userRepository.findAll(new Sort("email"));
//    }

    @Override
    public User create(String email, String password, Role role) {
        User user = new User(email, password, role);
        return userRepository.save(user);
    }

}