package com.polling.ipl;

import com.polling.ipl.model.Person;
import com.polling.ipl.repo.PersonRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PersonController {

    @Autowired
    PersonRepo repo;

    @GetMapping("/get")
    public List<Person> getPerson(){
        return repo.findAll();
    }

    @PostMapping("/post")
    public void addPerson(@RequestBody Person person){
        repo.save(person);
    }
}
