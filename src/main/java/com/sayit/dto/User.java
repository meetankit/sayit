package com.sayit.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "user")
@Setter
@Getter
public class User {
    
    @Id
    @GeneratedValue
    @Column(name="userId")
    private Long userId;
  
    @Column
    private String userName;
    
    @Column
    private Long phoneNo;

}
