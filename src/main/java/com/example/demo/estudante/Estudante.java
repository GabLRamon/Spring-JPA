package com.example.demo.estudante;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Estudante {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column
    private String name;

    @Column(unique = true)
    private String email;

    public Estudante(Long id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public Estudante() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Estudante {id = " + id + ", nome = " + name + ", email = " + email + "}";
    }
}
