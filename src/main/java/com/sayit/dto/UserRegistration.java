package com.sayit.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "userRegistration")
@Setter
@Getter
public class UserRegistration {
    
    @Id
    @Column(name="phoneNo")
    private Long phoneNo;
  
    @Column
    private String regId;
}
