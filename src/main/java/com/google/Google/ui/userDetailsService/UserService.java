package com.google.Google.ui.userDetailsService;

import org.springframework.stereotype.Service;
import ui.model.request.UserDetailsRequestModel;
import ui.model.response.UserRest;

@Service
public interface UserService {
    UserRest createUser(UserDetailsRequestModel userDetailsRequestModel);
}
