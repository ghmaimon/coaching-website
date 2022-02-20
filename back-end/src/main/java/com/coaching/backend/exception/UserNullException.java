package com.coaching.backend.exception;

import com.coaching.backend.enumeration.Role;

public class UserNullException extends UserException{
    public UserNullException(Role role) {
        super(UserNullException.class.getSimpleName(), "expected a "+role.name()+", found : null");
    }
    public UserNullException() {
        super(UserNullException.class.getSimpleName(), "expected a user, found : null");
    }
}
