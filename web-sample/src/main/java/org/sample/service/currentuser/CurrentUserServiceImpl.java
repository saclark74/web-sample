package org.sample.service.currentuser;

/**
 * Created by Scott on 6/15/2015.
 */
import org.sample.model.Role;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class CurrentUserServiceImpl implements CurrentUserService {

    private static final Logger LOG = LoggerFactory.getLogger(CurrentUserDetailsService.class);

    @Override
    public boolean canAccessUser(CurrentUser currentUser, Long userId) {
        LOG.debug("Checking if user={} has access to user={}", currentUser, userId);
        return currentUser != null
            && (currentUser.getRole() == Role.ADMIN || currentUser.getId().equals(userId));
    }

}