/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.elte.keza.issuetracker.controllers;

import hu.elte.keza.issuetracker.entities.Issue;
import hu.elte.keza.issuetracker.repositories.IssueRepository;
import hu.elte.keza.issuetracker.repositories.UserRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author ZKereszti
 */
@RestController
@RequestMapping("issue")
public class IssueController{
    
    @Autowired
    private IssueRepository issueRepository;
    
    @Autowired
    private UserRepository userRepository;
    
 
    @GetMapping("")
    public ResponseEntity<Iterable<Issue>> getAll(){
        return new ResponseEntity(issueRepository.findAll(), HttpStatus.OK);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Issue> get(@PathVariable Long id){
        return new ResponseEntity(issueRepository.findById(id), HttpStatus.OK);
    }
    
    @PostMapping("")
    public ResponseEntity<Issue> update(@RequestBody Issue entity){
        Optional<Issue> baseEntity = issueRepository.findById(entity.getId());
        
        if(baseEntity.isPresent()){
            issueRepository.save(entity);
            return new ResponseEntity(issueRepository.findById(entity.getId()), HttpStatus.OK) ;
        }
        
        return ResponseEntity.notFound().build();
    }
    
    @GetMapping("createdby/{id}")
    public ResponseEntity<Issue> getByCreatedUser(@PathVariable Long id){
        return new ResponseEntity(
                issueRepository.findAllByCreatedBy(
                        userRepository.findById(id).get()
                ), 
                HttpStatus.OK);
    }
    
    @PutMapping("")
    public ResponseEntity<Issue> create(@RequestBody Issue entity){
        issueRepository.save(entity);
        return new ResponseEntity(issueRepository.findById(entity.getId()), HttpStatus.OK) ;
        
    }
    
}
