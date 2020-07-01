package SCHULMAN.fragmnt.spring.services;

import SCHULMAN.fragmnt.spring.exception.NotFoundException;
import SCHULMAN.fragmnt.spring.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    private Random random;

   List<User> users = new ArrayList<>();

    public UserService() {

    }

    @PostConstruct
    public void init(){
        User user1 = new User("John_schulman@hotmail.com", "pass", "1", true);
        User user2 = new User("Barry_schulma,@hotmailcom", "pass", "2", true);
        User user3 = new User("Mischa_schulman@hotmail.com", "pass", "3", false);
        User user4 = new User("Joseph_schulman@hotmail.com", "pass", "3", true);
        add(user1);
        add(user2);
        add(user4);
    }

    public void add(User user){
        user.setId(random.nextInt(Integer.MAX_VALUE));
        user.settCreate(LocalDateTime.now());
        users.add(user);

    }

    public List<User> getValidUsers(){

        return users.stream().filter(User::isActive).collect(Collectors.toList());
    }

    public User getUser(int id){
        return users.stream().filter(u -> u.getId() == id).findFirst().orElseThrow(NotFoundException:: new);
    }
}
