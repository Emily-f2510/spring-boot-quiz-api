package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "raspuns_test")
public class RaspunsTest {

    @EmbeddedId
    private RaspunsTestKey id;

    @Column(name = "corect")
    private String corect;

    public RaspunsTestKey getId() {
        return id;
    }

    public void setId(RaspunsTestKey id) {
        this.id = id;
    }

    public String getCorect() {
        return corect;
    }

    public void setCorect(String corect) {
        this.corect = corect;
    }
}
