package com.giuseppefrattura.tid.model;


import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
@Document(collection = "Users")
@Data
public class UserModel {
    private String name;
    private String photo;
    private String sex;
    private Date birthDate;

    public UserModel() {
    }



}
