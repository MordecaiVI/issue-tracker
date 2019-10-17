/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.elte.keza.issuetracker.controllers;

import hu.elte.keza.issuetracker.entities.Issue;
import hu.elte.keza.issuetracker.entities.Message;
import hu.elte.keza.issuetracker.repositories.IssueRepository;
import hu.elte.keza.issuetracker.repositories.UserRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
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
@CrossOrigin
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
       Optional<Issue> issue = issueRepository.findById(id);
        if (!issue.isPresent()) {
            return ResponseEntity.notFound().build();
        } 
        return ResponseEntity.ok(issue.get());
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Issue> update(@PathVariable Long id, @RequestBody Issue issue) {
        Optional<Issue> oIssue = issueRepository.findById(id);
        if (oIssue.isPresent()) {
            issue.setId(id);
            return ResponseEntity.ok(issueRepository.save(issue));
        }
        return ResponseEntity.notFound().build();
    }
    
    @PostMapping("")
    public ResponseEntity<Issue> post(@RequestBody Issue issue) {
        return ResponseEntity.ok(issueRepository.save(issue));
    }
            
    @DeleteMapping("/{id}")
    public ResponseEntity<Issue> delete(@PathVariable Long id) {
        Optional<Issue> issue = issueRepository.findById(id);
        if (!issue.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        issueRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }
    
    @GetMapping("createdby/{id}")
    public ResponseEntity<Issue> getByCreatedUser(@PathVariable Long id){
        return new ResponseEntity(
            issueRepository.findAllByCreatedBy(
                    userRepository.findById(id).get()
            ), 
            HttpStatus.OK);
    }
    
    @GetMapping("/{id}/messages")
    public ResponseEntity<Iterable<Message>> messages(@PathVariable Long id) {
        Optional<Issue> issue = issueRepository.findById(id);
        if (!issue.isPresent()) {
            return ResponseEntity.notFound().build();
        } 
        return ResponseEntity.ok(issue.get().getMessage());
    }
    
}
