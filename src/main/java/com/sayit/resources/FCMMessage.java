package com.sayit.resources;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FCMMessage {

    private List<String> registration_ids;
}
