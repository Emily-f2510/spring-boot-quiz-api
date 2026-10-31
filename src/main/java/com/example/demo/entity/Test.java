package com.example.demo.entity;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "test")
public class Test {

    @EmbeddedId
    private TestKey id;

    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Date data_test;

    @Column(nullable = false)
    private Integer punctaj_obtinut;

    public TestKey getId() {
        return id;
    }

    public void setId(TestKey id) {
        this.id = id;
    }

    public Date getData_test() {
        return data_test;
    }

    public void setData_test(Date data_test) {
        this.data_test = data_test;
    }

    public Integer getPunctaj_obtinut() {
        return punctaj_obtinut;
    }

    public void setPunctaj_obtinut(Integer punctaj_obtinut) {
        this.punctaj_obtinut = punctaj_obtinut;
    }
}
