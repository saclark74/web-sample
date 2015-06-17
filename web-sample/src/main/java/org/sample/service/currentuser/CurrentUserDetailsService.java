package org.sample.service.currentuser;

/**
 * Created by Scott on 6/15/2015.
 */
import org.sample.repository.UserRepository;
import org.sample.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CurrentUserDetailsService implements UserDetailsService {

    private static final Logger LOG = LoggerFactory.getLogger(CurrentUserDetailsService.class);
    //private final UserService userService;
    private final UserRepository userRepository;

    @Autowired
    public CurrentUserDetailsService(UserRepository userRepository) {
        //this.userService = userService;
        this.userRepository = userRepository;
    }

    @Override
    public CurrentUser loadUserByUsername(String email) throws UsernameNotFoundException {
        LOG.debug("Authenticating user with email={}", email.replaceFirst("@.*", "@***"));
        User user = userRepository.findOneByEmail(email)
            .orElseThrow(() -> new UsernameNotFoundException(String.format("User with email=%s was not found", email)));
        return new CurrentUser(user);
    }

}