package com.ups.oop.entity;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Client extends Person {
    private String ClientCode;


    public Client(){
        super();
    }
    public Client (String ClientCode, String personId, String name, String lastname, Integer age){
        super(personId, name, lastname, age);
        this.ClientCode = ClientCode;
    }
}
