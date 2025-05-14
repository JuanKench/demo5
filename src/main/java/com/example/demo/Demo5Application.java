package com.example.demo;

import com.example.demo.models.Kpi;
import com.example.demo.models.Kund;
import com.example.demo.repos.KpiRepo;
import com.example.demo.repos.KundRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Demo5Application {

    public static void main(String[] args) {
        SpringApplication.run(Demo5Application.class, args);
    }

    @Bean
    public CommandLineRunner demo5(KpiRepo kpiRepo, KundRepo kundRepo) {
        return (args -> {
            Kpi k1 = new Kpi(45);
            Kpi k2 = new Kpi(65);
            Kpi k3 = new Kpi(75);
            Kpi k4 = new Kpi(85);

            kpiRepo.save(k1);
            kpiRepo.save(k2);
            kpiRepo.save(k3);
            kpiRepo.save(k4);

            Kund kund1 = new Kund("Johan", "34534", k1);
            Kund kund2 = new Kund("Jane", "34534", k2);
            Kund kund3 = new Kund("Jane", "34534", k3);
            Kund kund4 = new Kund("Jane", "34534", k4);

            kundRepo.save(kund1);
            kundRepo.save(kund2);
            kundRepo.save(kund3);
            kundRepo.save(kund4);
        });
    }
}
