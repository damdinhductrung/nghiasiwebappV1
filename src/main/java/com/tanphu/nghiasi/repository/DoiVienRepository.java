package com.tanphu.nghiasi.repository;

import com.tanphu.nghiasi.model.DoiVien;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DoiVienRepository extends JpaRepository<DoiVien, Long> {
    Page<DoiVien> findByToanId(Long toanId, Pageable pageable);
}
