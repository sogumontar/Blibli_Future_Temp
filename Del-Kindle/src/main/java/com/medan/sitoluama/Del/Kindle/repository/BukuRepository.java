package com.medan.sitoluama.Del.Kindle.repository;

import com.medan.sitoluama.Del.Kindle.Model.Buku;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BukuRepository extends JpaRepository<Buku,Long> {
    Buku findFirstById(Long id);
}
