/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.elte.keza.issuetracker.controllers;

import hu.elte.keza.issuetracker.entities.Issue;
import hu.elte.keza.issuetracker.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author ZKereszti
 */
@RestController
@RequestMapping("user")
public class UserController{
    @Autowired
    private UserRepository userRepository;
    
    @GetMapping("")
    public ResponseEntity<Iterable<Issue>> getAll(){
        return new ResponseEntity(userRepository.findAll(), HttpStatus.OK);
    }
}
