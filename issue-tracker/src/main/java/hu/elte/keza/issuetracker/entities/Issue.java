/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.elte.keza.issuetracker.entities;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
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
@Table(name = "issue")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Issue extends BaseWithUpdateInfo {

    @Column
    private String title;    
    
    @Column
    private String description;
    
    @Column
    private String place;

    @OneToMany(targetEntity = Message.class, mappedBy = "issue")
    private List<Message> message;
    
    @ManyToMany(targetEntity = Label.class)
    private List<Label> label;

}






















