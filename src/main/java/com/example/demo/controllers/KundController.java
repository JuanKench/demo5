package com.example.demo.controllers;

import com.example.demo.models.Kategori;
import com.example.demo.models.Kpi;
import com.example.demo.models.Kund;
import com.example.demo.repos.KategoriRepo;
import com.example.demo.repos.KpiRepo;
import com.example.demo.repos.KundRepo;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class KundController {
    private final KpiRepo kpiRepo;
    private final KundRepo kundRepo;
    private final KategoriRepo kategoriRepo;

    KundController(KpiRepo kpiRepo, KundRepo kundRepo, KategoriRepo kategoriRepo) {
        this.kpiRepo = kpiRepo;
        this.kundRepo = kundRepo;
        this.kategoriRepo = kategoriRepo;
    }

    @RequestMapping("Kunder")
    public List<Kund> getAllKunder() {
        return kundRepo.findAll();
    }

    @RequestMapping("Kunder/add")
    public String addKund(@RequestParam String name, @RequestParam String ssn, @RequestParam Long id) {
        Kpi kpi = kpiRepo.findById(id).get();
        kundRepo.save(new Kund(name, ssn, kpi));
        return "Kund " + name + " added";
    }
    @RequestMapping("Kunder/delete")
    public String deleteKund(@RequestParam Long id) {
        kpiRepo.deleteById(id);
        return "Kund " + id + " deleted";
    }

    @RequestMapping("Kunder/add2")
    public String addKund2(@RequestParam String name, @RequestParam String ssn, @RequestParam long cred, @RequestParam Long kategoriid) {
        Kategori kat = kategoriRepo.findById(kategoriid).get();
        if(kat != null) {
            kundRepo.save(new Kund(name, ssn, new Kpi(cred), kat));
            return "Kund " + name + " added";
        }
        return "Kund " + name + " not found";
    }

}
