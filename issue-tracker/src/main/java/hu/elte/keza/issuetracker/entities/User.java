/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.elte.keza.issuetracker.entities;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
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
public class User extends BaseWithUpdateInfo {
    
    @Column
    private String userName;    
    
    @Column
    private String password;
    
    @OneToMany(targetEntity = Issue.class, mappedBy = "createdBy")
    private List<Issue> createdIssue;
    
    @OneToMany(targetEntity = Issue.class, mappedBy = "updatedBy")
    private List<Issue> updatedIssue;
    
    @OneToMany(targetEntity = Message.class, mappedBy = "createdBy")
    private List<Message> createdMessage;

    @OneToMany(targetEntity = User.class, mappedBy = "createdBy")
    private List<Issue> createdUser;
    
    @OneToMany(targetEntity = User.class, mappedBy = "updatedBy")
    private List<Issue> updatedUser;
}






















