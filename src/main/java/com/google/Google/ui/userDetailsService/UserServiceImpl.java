package com.google.Google.ui.userDetailsService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import ui.model.request.UserDetailsRequestModel;
import ui.model.response.UserRest;

@Service
public class UserServiceImpl implements UserService {

    @Override
    public UserRest createUser(UserDetailsRequestModel userDetailsRequestModel) {
        UserRest userRest=new UserRest();
        userRest.setFirstName(userDetailsRequestModel.getFirstName());
        userRest.setLastName(userDetailsRequestModel.getLastName());
        userRest.setEmail(userDetailsRequestModel.getEmail());
        userRest.setPassword(userDetailsRequestModel.getPassword());
        return userRest;
    }

    /* @Override
    UserRest createUser(UserDetailsRequestModel userDetailsRequestModel)
    {
        UserRest userRest=new UserRest();
        userRest.setFirstName(userDetailsRequestModel.getFirstName());
        userRest.setLastName(userDetailsRequestModel.getLastName());
        userRest.setEmail(userDetailsRequestModel.getEmail());
        userRest.setPassword(userDetailsRequestModel.getPassword());
        return userRest;
    }*/
}
