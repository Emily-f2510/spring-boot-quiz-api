package com.example.demo.entity;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class RaspunsTestKey implements Serializable {

    @Column(name = "id_t")
    private Long idT;

    @Column(name = "id_i")
    private Long idI;

    @Column(name = "id_r")
    private String idR;

    public RaspunsTestKey() {}

    public Long getIdT() { return idT; }
    public void setIdT(Long idT) { this.idT = idT; }

    public Long getIdI() { return idI; }
    public void setIdI(Long idI) { this.idI = idI; }

    public String getIdR() { return idR; }
    public void setIdR(String idR) { this.idR = idR; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RaspunsTestKey that = (RaspunsTestKey) o;
        return Objects.equals(idT, that.idT) &&
                Objects.equals(idI, that.idI) &&
                Objects.equals(idR, that.idR);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idT, idI, idR);
    }
}