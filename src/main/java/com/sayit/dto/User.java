package com.sayit.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class User {
    
    @Id
    @Column(name="userId")
    private Long userId;

}
