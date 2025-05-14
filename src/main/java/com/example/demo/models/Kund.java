package com.example.demo.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Kund {
    @Id
    @GeneratedValue
    private long id;

    private String name;
    private String ssn;

    @OneToOne
    @JoinColumn  //(cascade = CascadeType.ALL) vill inte fungera     //(name = "myFK", referencedColumnName = "kedditvalidation") kol sak man kan göra //FK-kolumn kommer att heta kpi_id
    @JsonIgnore
    private Kpi kpi;

    public Kund(String name, String ssn, Kpi kpi) {
        this.name = name;
        this.ssn = ssn;
        this.kpi = kpi;
    }

    public Kund() {

    }

    @ManyToOne
    @JoinColumn
    private Kategori kategori;

    public Kund(String name, String ssn, Kpi kpi, Kategori kat) {
        this.name = name;
        this.ssn = ssn;
        this.kpi = kpi;
        this.kategori = kat;
    }
}
