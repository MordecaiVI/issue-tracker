/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.elte.keza.issuetracker.entities;

import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import lombok.Data;

/**
 *
 * @author keza13
 */
@Data
@MappedSuperclass
public class BaseWithUpdateInfo extends BaseWithCreationInfo {
    @Column(updatable = false, nullable = false)
    private LocalDateTime updatedAt;

    @JoinColumn(updatable = false, nullable = false)
    @ManyToOne(targetEntity = User.class)
    private User updatedBy;

}






















