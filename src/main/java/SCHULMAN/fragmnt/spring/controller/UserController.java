package SCHULMAN.fragmnt.spring.controller;

import SCHULMAN.fragmnt.spring.models.User;
import SCHULMAN.fragmnt.spring.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public User create(@Validated @RequestBody User user){
        userService.add(user);
        return user;

    }

    @GetMapping
    public List<User> getAll(){

        List<User> getallUsers = userService.getValidUsers();
        return getallUsers;
    }

    @GetMapping("/{id}")
    public User get(@PathVariable("id") int id){
        User getUserById = userService.getUser(id);
        return getUserById;
    }
}
