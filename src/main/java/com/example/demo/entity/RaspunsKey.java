package com.example.demo.entity;

import java.io.Serializable;
import java.util.Objects;
import jakarta.persistence.*;

@Embeddable
public class RaspunsKey implements Serializable {

    private Long id_i;
    private String id_r;

    public RaspunsKey() {}

    public Long getId_i() { return id_i; }
    public void setId_i(Long id_i) { this.id_i = id_i; }

    public String getId_r() { return id_r; }
    public void setId_r(String id_r) { this.id_r = id_r; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RaspunsKey that = (RaspunsKey) o;
        return Objects.equals(id_i, that.id_i) && Objects.equals(id_r, that.id_r);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id_i, id_r);
    }
}