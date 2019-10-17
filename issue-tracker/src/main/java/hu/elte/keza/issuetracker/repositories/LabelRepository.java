/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.elte.keza.issuetracker.repositories;

import hu.elte.keza.issuetracker.entities.Label;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author ZKereszti
 */
@Repository
public interface LabelRepository extends CrudRepository<Label, Long> {
    
}
