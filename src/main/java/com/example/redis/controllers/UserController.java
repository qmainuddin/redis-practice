package com.example.redis.controllers;

import com.example.redis.models.SearchCriteria;
import com.example.redis.models.User;
import com.example.redis.repositories.UserRepository;
import com.example.redis.repositories.impl.UserRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.jws.soap.SOAPBinding;
import java.time.LocalDate;
import java.util.Map;

/**
 * Created by Mainuddin on 20-Feb-19.
 */
@RestController
@RequestMapping("/api/users")
public class UserController {

    private UserRepository userRepository;

    public UserController(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @GetMapping("/add/{nid}/{firstName}") ///{lastName}/{dateOfBirth}/{contactNumber}
    public User add(@PathVariable("nid") final String nid,
                    @PathVariable("firstName") final String firstName//,
//                    @PathVariable("lastName") final String lastName,
//                    //@PathVariable("dateOfBirth") final LocalDate dateOfBirth,
                    //                    @PathVariable("contactNumber") final String contactNumber
    ){
        userRepository.save(new User(firstName, "", nid, "", LocalDate.now()));

        return userRepository.findByNID(nid);
    }

    @GetMapping("/update/{nid}/{firstName}/{lastName}/{dateOfBirth}/{contactNumber}")
    public User update(@PathVariable("nid") final String nid,
                    @PathVariable("firstName") final String firstName,
                    @PathVariable("lastName") final String lastName,
                    @PathVariable("dateOfBirth") final LocalDate dateOfBirth,
                    @PathVariable("contactNumber") final String contactNumber){
        userRepository.update(new User(firstName, lastName, nid, contactNumber, dateOfBirth));

        return userRepository.findByNID(nid);
    }

    @GetMapping("/all")
    public Map<String, User> findAll(){
        return userRepository.findAll();
    }

    @GetMapping("/delete/{nid}")
    public Map<String, User> delete(@PathVariable("nid") final String nid){
        userRepository.delete(nid);
        return userRepository.findAll();
    }

    @PostMapping("/search")
    public User searchUser(@RequestBody SearchCriteria searchCriteria){
        User searchResult = userRepository.findBySearchCriteria(searchCriteria);
        if(searchResult == null){
            userRepository.save(searchCriteria, new User(
                    searchCriteria.getFirstName(),
                    searchCriteria.getLastName(),
                    searchCriteria.getNid(), "01741672204", LocalDate.now()));
            return null;
        }
        return searchResult;
    }
}
