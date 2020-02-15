package com.google.Google.ui.controller;

import com.google.Google.ui.userDetailsService.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ui.model.request.UserDetailsRequestModel;
import ui.model.response.UserRest;

import javax.validation.Valid;

@RestController
@RequestMapping("users")// http://localhost:8080/users
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping
    public String getUsers(@RequestParam(value = "page",defaultValue = "1") int page,
                           @RequestParam(value = "limit",defaultValue = "50") int limit,
                           @RequestParam(value = "sort",defaultValue = "desc",required = false) String sort)
    {

        return "getUser Data Call page="+page+" limit= "+limit+" sort= "+sort;
    }


    @GetMapping(path = "/{userId}",produces = {MediaType.APPLICATION_XML_VALUE,MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<UserRest> getUser(@PathVariable String userId)
    {
        String firstName=null;
        int length=firstName.length();
        UserRest userRest=new UserRest();
        userRest.setFirstName("Sushil");
        userRest.setLastName("Mall");
        userRest.setEmail("sushilmall96@gmail.com");
        return new ResponseEntity<UserRest>(HttpStatus.BAD_REQUEST);
    }



  /*  @PostMapping(produces = {MediaType.APPLICATION_XML_VALUE,MediaType.APPLICATION_JSON_VALUE},
            consumes = {MediaType.APPLICATION_XML_VALUE,MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<UserRest> createUser(@Valid  @RequestBody UserDetailsRequestModel userDetailsRequestModel)
    {
        UserRest userRest=new UserRest();
        userRest.setFirstName(userDetailsRequestModel.getFirstName());
        userRest.setLastName(userDetailsRequestModel.getLastName());
        userRest.setEmail(userDetailsRequestModel.getEmail());
        userRest.setPassword(userDetailsRequestModel.getPassword());
        return new ResponseEntity<UserRest>(userRest,HttpStatus.OK);
    }*/

    @PostMapping(produces = {MediaType.APPLICATION_XML_VALUE,MediaType.APPLICATION_JSON_VALUE},
            consumes = {MediaType.APPLICATION_XML_VALUE,MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<UserRest> createUser(@Valid  @RequestBody UserDetailsRequestModel userDetailsRequestModel)
    {
          UserRest userRest=userService.createUser(userDetailsRequestModel);
        return new ResponseEntity<UserRest>(userRest,HttpStatus.OK) ;
    }

    @PutMapping
    public String updateUser()
    {
        return "Upadte User Call";
    }

    @DeleteMapping
    public String deleteUser()
    {
        return "delete User Call";
    }

}
