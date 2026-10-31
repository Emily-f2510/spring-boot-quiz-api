package com.example.demo.entity;

import java.io.Serializable;
import java.util.Objects;
import jakarta.persistence.*;

@Embeddable
public class TestKey implements Serializable {

    private Long id_t;
    private Long id_i;

    public TestKey() {}

    public Long getId_t() { return id_t; }
    public void setId_t(Long id_t) { this.id_t = id_t; }

    public Long getId_i() { return id_i; }
    public void setId_i(Long id_i) { this.id_i = id_i; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TestKey testKey = (TestKey) o;
        return Objects.equals(id_t, testKey.id_t) && Objects.equals(id_i, testKey.id_i);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id_t, id_i);
    }
}