package com.sayit.resources;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class UserResource {

    private String userId;
    private String regId;
    private Long phoneNo;
    private String userName;
}
