package com.example.demo.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Kpi {

    @Id
    @GeneratedValue
    private long id;

    private long kedditvalidation;

    public Kpi(long kedditvalidation) {
        this.kedditvalidation = kedditvalidation;
    }

    public Kpi() {

    }
}
