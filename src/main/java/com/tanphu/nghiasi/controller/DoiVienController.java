package com.tanphu.nghiasi.controller;

import com.tanphu.nghiasi.exception.ResourcesNotFoundException;
import com.tanphu.nghiasi.model.DoiVien;
import com.tanphu.nghiasi.model.Htdt;
import com.tanphu.nghiasi.repository.DoiVienRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class DoiVienController {
    @Autowired
    DoiVienRepository doiVienRepository;

    //Get all Doi Vien
    @GetMapping("/doiVien")
    public List<DoiVien> getAllDoiVien() {
        return doiVienRepository.findAll();
    }

    //Get a Single Doi Vien
    @GetMapping("/doiVien/{id}")
    public DoiVien getDoiVienById(@PathVariable(value = "id") Long doiVienId) {
        return doiVienRepository.findById(doiVienId).orElseThrow(() -> new ResourcesNotFoundException("Doi Vien", "Id", doiVienId));
    }

    //Crate Doi Vien
    @PostMapping("/doiVien")
    public DoiVien createHtdt(@Valid @RequestBody DoiVien doiVien) {
        return doiVienRepository.save(doiVien);
    }

    //Update Doi Vien
    @PutMapping("/doiVien/{id}")
    public DoiVien updateDoiVien(@PathVariable(value = "id") Long doiVienId,@Valid @RequestBody DoiVien doiVienDetail) {
        return doiVienRepository.findById(doiVienId).map(doiVien -> {
            doiVien.setTenThanh(doiVienDetail.getTenThanh());
            doiVien.setHo(doiVienDetail.getHo());
            doiVien.setTen(doiVienDetail.getTen());
            doiVien.setNgaySinh(doiVienDetail.getNgaySinh());
            doiVien.setQuanThay(doiVienDetail.getQuanThay());
            doiVien.setDiaChi(doiVienDetail.getDiaChi());
            doiVien.setDienThoai(doiVienDetail.getDienThoai());
            doiVien.setGiaoHo(doiVienDetail.getGiaoHo());

            return doiVienRepository.save(doiVien);
        }).orElseThrow(() -> new ResourcesNotFoundException("Doi Vien", "Id", doiVienId));
    }

    //Delete Doi Vien
    @DeleteMapping("/doiVien/{id}")
    public ResponseEntity<?> deleteDoiVien(@PathVariable(value = "id") Long doiVienId) {
        return doiVienRepository.findById(doiVienId).map(doiVien -> {
            doiVienRepository.deleteById(doiVienId);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourcesNotFoundException("Doi Vien", "Id", doiVienId));
    }

    //Get all Doi Vien of Toan
    @GetMapping("/toan/{id}/doiViens")
    public Page<DoiVien> getAllDoiVienByToanId(@PathVariable(value = "id") Long toanId, Pageable pageable) {
        return doiVienRepository.findByToanId(toanId, pageable);
    }

}
