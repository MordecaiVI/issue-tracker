/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.elte.keza.issuetracker.controllers;

import hu.elte.keza.issuetracker.entities.Message;
import hu.elte.keza.issuetracker.repositories.MessageRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author ZKereszti
 */
@RestController
@RequestMapping("message")
public class MessageController{
    
    @Autowired
    private MessageRepository messageRepository;
    
    @GetMapping("/{id}")
    public ResponseEntity<Message> get(@PathVariable Long id) {
        Optional<Message> message = messageRepository.findById(id);
        if (!message.isPresent()) {
            return ResponseEntity.notFound().build();
        } 
        return ResponseEntity.ok(message.get());        
    }
    
}
