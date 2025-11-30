package com.example.CRUD.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class User {

    @Id //Primary Key
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false) // NOT NULL 제약조건
    private String name;

    @Column(nullable = false) // NOT NULL 제약조건
    private int age;

    public User() {}

    //편하게 객체 생성하려고 만든 생성자
    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
