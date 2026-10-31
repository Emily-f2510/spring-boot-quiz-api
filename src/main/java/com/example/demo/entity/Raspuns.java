package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "raspuns")
public class Raspuns {

    @EmbeddedId
    private RaspunsKey id;

    @Column(nullable = false)
    private String raspuns;

    @Column(nullable = false)
    private String corect;

    public RaspunsKey getId() {
        return id;
    }

    public void setId(RaspunsKey id) {
        this.id = id;
    }

    public String getRaspuns() {
        return raspuns;
    }

    public void setRaspuns(String raspuns) {
        this.raspuns = raspuns;
    }

    public String getCorect() {
        return corect;
    }

    public void setCorect(String corect) {
        this.corect = corect;
    }
}
