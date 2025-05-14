package com.example.demo.repos;

import com.example.demo.models.Kategori;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KategoriRepo extends JpaRepository<Kategori, Long> {
}
