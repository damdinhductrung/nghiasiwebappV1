package com.tanphu.nghiasi.repository;

import com.tanphu.nghiasi.model.Htdt;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HtdtRepository extends JpaRepository<Htdt, Long> {
    Page<Htdt> findByToanId(Long toanId, Pageable pageable);
    Page<Htdt> findByRoleId(Long roleId, Pageable pageable);
    Page<Htdt> findByKhoiId(Long khoiId, Pageable pageable);
}
