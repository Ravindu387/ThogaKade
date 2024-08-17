package org.example.model;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class Customer {
    private String id;
    private String type;
    private String name;
    private String fname;
    private String address;
    private String cnumber;
    private LocalDate birthday;

    public Customer(String id,String type,String name,String address, String cnumber, LocalDate birthday) {
        this.id = id;
        this.fname=type+name;
        this.address = address;
        this.cnumber = cnumber;
        this.birthday = birthday;
        this.type=type;
        this.name=name;
    }
}
