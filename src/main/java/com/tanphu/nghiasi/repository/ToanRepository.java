package com.tanphu.nghiasi.repository;

import com.tanphu.nghiasi.model.Toan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ToanRepository extends JpaRepository<Toan, Long> {
}
