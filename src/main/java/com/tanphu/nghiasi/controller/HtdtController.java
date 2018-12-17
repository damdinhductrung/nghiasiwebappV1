package com.tanphu.nghiasi.controller;

import com.tanphu.nghiasi.exception.ResourcesNotFoundException;
import com.tanphu.nghiasi.model.Htdt;
import com.tanphu.nghiasi.repository.HtdtRepository;
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
public class HtdtController {
    @Autowired
    HtdtRepository htdtRepository;

    //Get all Htdt
    @GetMapping("/htdt")
    public List<Htdt> getAllHtdt() {
        return htdtRepository.findAll();
    }

    //Get a Single Htdt
    @GetMapping("/htdt/{id}")
    public Htdt getHtdtById(@PathVariable(value = "id") Long htdtId) {
        return htdtRepository.findById(htdtId).orElseThrow(() -> new ResourcesNotFoundException("Htdt", "Id", htdtId));
    }

    //Create Htdt
    @PostMapping("/htdt")
    public Htdt createHtdt(@Valid @RequestBody Htdt htdt) {
        return htdtRepository.save(htdt);
    }

    //Update Htdt details
    @PutMapping("/htdt/{id}")
    public Htdt updateHtdt(@PathVariable(value = "id") Long htdtId, @Valid @RequestBody Htdt htdtDetails) {
        return htdtRepository.findById(htdtId).map(htdt -> {
            htdt.setTenThanh(htdtDetails.getTenThanh());
            htdt.setHo(htdtDetails.getHo());
            htdt.setTen(htdtDetails.getTen());
            htdt.setNgaySinh(htdtDetails.getNgaySinh());
            htdt.setQuanThay(htdtDetails.getQuanThay());
            htdt.setDiaChi(htdtDetails.getDiaChi());
            htdt.setDienThoai(htdtDetails.getDienThoai());
            htdt.setGiaoHo(htdtDetails.getGiaoHo());

            return htdt;
        }).orElseThrow(() -> new ResourcesNotFoundException("Htdt", "Id", htdtId));
    }



    //Delete Htdt
    @DeleteMapping("/htdt/{id}")
    public ResponseEntity<?> deleteHtdt(@PathVariable(value = "id") Long htdtId) {
        return htdtRepository.findById(htdtId).map(htdt -> {
            htdtRepository.delete(htdt);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourcesNotFoundException("Htdt", "Id", htdtId));
    }

    //Get all Htdt of Toan
    @GetMapping("/toan/{id}/htdts")
    public Page<Htdt> getAllHtdtsByToanId(@PathVariable(value = "id") Long toanId, Pageable pageable) {
        return htdtRepository.findByToanId(toanId, pageable);
    }

    //Get all Htdt of Khoi
    @GetMapping("/khoi/{id}/htdts")
    public Page<Htdt> getAllHtdtsByKhoiId(@PathVariable(value = "id") Long khoiId, Pageable pageable) {
        return htdtRepository.findByKhoiId(khoiId, pageable);
    }

    //Get all Htdt of Role
    @GetMapping("/role/{id}/htdts")
    public Page<Htdt> getAllHtdtsByRoleId(@PathVariable(value = "id") Long roleId, Pageable pageable) {
        return htdtRepository.findByRoleId(roleId, pageable);
    }
}
