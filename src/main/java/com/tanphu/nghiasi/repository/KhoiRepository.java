package com.tanphu.nghiasi.repository;

import com.tanphu.nghiasi.model.Khoi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KhoiRepository extends JpaRepository<Khoi, Long> {
}
