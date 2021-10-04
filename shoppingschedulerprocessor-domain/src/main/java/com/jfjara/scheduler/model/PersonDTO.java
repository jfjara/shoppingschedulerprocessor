package com.jfjara.scheduler.model;

import lombok.Builder;
import lombok.Value;

@Value
@Builder(toBuilder = true)
public class PersonDTO {

    String id;
    String firstName;
    String lastName;

}
