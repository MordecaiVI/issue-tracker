/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.elte.keza.issuetracker.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
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
@Table(name = "user")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class User extends BaseEntity {
    
    @Column
    private String userName;    
    
    @Column
    private String password;
    
    @JsonIgnore
    @OneToMany(targetEntity = Issue.class, mappedBy = "createdBy")
    private List<Issue> createdIssue;
    
    @JsonIgnore
    @OneToMany(targetEntity = Issue.class, mappedBy = "updatedBy")
    private List<Issue> updatedIssue;
    
    @JsonIgnore
    @OneToMany(targetEntity = Message.class, mappedBy = "createdBy")
    private List<Message> createdMessage;

}






















