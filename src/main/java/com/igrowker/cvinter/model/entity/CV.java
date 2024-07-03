package com.igrowker.cvinter.model.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "cv")
public class CV {
    @Id
    private String email;
    @Indexed(unique = true)
    private String userId;



}
