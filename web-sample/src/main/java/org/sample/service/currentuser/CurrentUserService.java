package org.sample.service.currentuser;

/**
 * Created by Scott on 6/15/2015.
 */
public interface CurrentUserService {

    boolean canAccessUser(CurrentUser currentUser, Long userId);

}