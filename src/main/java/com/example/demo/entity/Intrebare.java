package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "intrebare")
public class Intrebare {

    @Id
    private Long id_i;

    @Column(nullable = false, length = 500)
    private String intrebare;

    private String poza;

    @Column(nullable = false)
    private String sectiune;

    @Column(nullable = false)
    private String categoria;

    public Long getId_i() {
        return id_i;
    }

    public void setId_i(Long id_i) {
        this.id_i = id_i;
    }

    public String getIntrebare() {
        return intrebare;
    }

    public void setIntrebare(String intrebare) {
        this.intrebare = intrebare;
    }

    public String getPoza() {
        return poza;
    }

    public void setPoza(String poza) {
        this.poza = poza;
    }

    public String getSectiune() {
        return sectiune;
    }

    public void setSectiune(String sectiune) {
        this.sectiune = sectiune;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
}
