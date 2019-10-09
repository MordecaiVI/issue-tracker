/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.elte.keza.issuetracker.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 *
 * @author keza13
 */
@Entity
@Table(name = "message")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Message extends BaseWithCreationInfo {

    @Column(nullable = false)
    private String message;    
    
    @JsonIgnore
    @JoinColumn(updatable = false)
    @ManyToOne(targetEntity = Issue.class)
    private Issue issue;

}






















