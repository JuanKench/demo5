package com.example.demo.controllers;

import com.example.demo.models.Kpi;
import com.example.demo.repos.KpiRepo;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class KpiController {
    private final KpiRepo kpiRepo;

    KpiController(KpiRepo kpiRepo) {
        this.kpiRepo = kpiRepo;
    }

    @RequestMapping("kpis")
    public List<Kpi> getAllKpi() {
        return kpiRepo.findAll();
    }
    @RequestMapping("kpis/add")
    public String addKpi(@RequestParam int cred) {
        kpiRepo.save(new Kpi(cred));
        return "kpi " + cred + " added";
    }

}
