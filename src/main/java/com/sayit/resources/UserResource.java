package com.sayit.resources;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class UserResource {
    private String userName;
    private Long phoneNo;
    private Long userId;
}
