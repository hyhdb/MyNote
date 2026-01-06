package com.example.CRUD.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String userid;

    @Column(nullable = false)
    private String name;

    private int age;

    @Column(nullable = false)
    private String password;

    public Long getId() { return id; }
    public String getUserid() {return userid;}
    public String getName() { return name; }
    public int getAge() { return age; }
    public String getPassword() { return password; }

    public void setUserid(String userid) {this.userid = userid;}
    public void setName(String name) { this.name = name; }
    public void setAge(int age) { this.age = age; }
    public void setPassword(String password) {this.password = password;}
}
