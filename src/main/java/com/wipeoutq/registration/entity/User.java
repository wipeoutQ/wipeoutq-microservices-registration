package com.wipeoutq.registration.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.io.Serializable;

@Data
@AllArgsConstructor
@Document(collection = "user")
public class User implements Serializable {

    @Id
    private String id;
    private String name;
    @Field("mobile")
    private String mobile;
    private String email;
    private String password;

}
