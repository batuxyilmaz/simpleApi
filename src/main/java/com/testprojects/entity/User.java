package com.testprojects.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name="USER")
public class User {

    @Id
    Long id;

    String name;
    String password;
}
