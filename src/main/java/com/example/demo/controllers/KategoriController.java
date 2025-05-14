package com.example.demo.controllers;

import com.example.demo.models.Kategori;
import com.example.demo.repos.KategoriRepo;
import com.example.demo.repos.KundRepo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class KategoriController {
    private final KategoriRepo kategoriRepo;
    private final KundRepo kundRepo;

    KategoriController(KategoriRepo kategoriRepo, KundRepo kundRepo) {
        this.kategoriRepo = kategoriRepo;
        this.kundRepo = kundRepo;
    }

    @RequestMapping("Kategorier")
    public List<Kategori> getAllKategori() {
        return kategoriRepo.findAll();
    }

    @RequestMapping("Kategorier/add")
    public String addKategori(@RequestParam String name) {
        kategoriRepo.save(new Kategori(name));
        return "Kategori " + name + " lades till";
    }

    @RequestMapping("Kategorier/delete/{id}")
    public String deleteKategori(@PathVariable long id) {
        kategoriRepo.deleteById(id);
        return "Kategori " + id + " lades till";
    }
}
