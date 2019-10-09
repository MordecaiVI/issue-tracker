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
import javax.persistence.ManyToMany;
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
@Table(name = "label")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Label extends BaseWithCreationInfo {
    
    @Column
    private String label;    
    
    @JsonIgnore
    @ManyToMany(targetEntity = Issue.class, mappedBy = "label")
    private List<Issue> issue;
    
}






















