/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.elte.keza.issuetracker.repositories;

import hu.elte.keza.issuetracker.entities.Issue;
import hu.elte.keza.issuetracker.entities.User;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author ZKereszti
 */
@Repository
public interface IssueRepository extends CrudRepository<Issue, Long> {
    List<Issue> findAllByCreatedBy(User user);
}
