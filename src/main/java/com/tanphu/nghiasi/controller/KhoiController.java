package com.tanphu.nghiasi.controller;

import com.tanphu.nghiasi.exception.ResourcesNotFoundException;
import com.tanphu.nghiasi.model.Khoi;
import com.tanphu.nghiasi.repository.KhoiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class KhoiController {

    @Autowired
    KhoiRepository khoiRepository;

    //Get All Khoi
    @GetMapping("/khoi")
    public List<Khoi> getAllKhoi() {
        return khoiRepository.findAll();
    }

    //Get a Single Khoi
    @GetMapping("/khoi/{id}")
    public Khoi getKhoiById(@PathVariable(value = "id") Long khoiId) {
        return khoiRepository.findById(khoiId).orElseThrow(() -> new ResourcesNotFoundException("Khoi", "id", khoiId));
    }

    //Create a new Khoi
//    @PostMapping("/khoi")
//    public Khoi createKhoi(@Valid @RequestBody Khoi khoi) {
//        return khoiRepository.save(khoi);
//    }

    //Delete a Khoi
//    @DeleteMapping("/khoi/{id}")
//    public void deleteById(@PathVariable(value = "id") Long khoiId) {
//        khoiRepository.deleteById(khoiId);
//    }

    //Update a Khoi
//    @PutMapping("/khoi/{id}")
//    public Khoi updateKhoi(@PathVariable(value = "id") Long khoiId, @Valid @RequestBody Khoi khoiDetails) {
//        Khoi khoi = khoiRepository.findById(khoiId).orElseThrow(() -> new ResourcesNotFoundException("Khoi", "id", khoiId));
//
//        khoi.setTen(khoiDetails.getTen());
//
//        Khoi updatedKhoi = khoiRepository.save(khoi);
//
//        return updatedKhoi;
//    }
}
