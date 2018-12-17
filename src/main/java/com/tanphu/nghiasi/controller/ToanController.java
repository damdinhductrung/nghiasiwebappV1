package com.tanphu.nghiasi.controller;

import com.tanphu.nghiasi.exception.ResourcesNotFoundException;
import com.tanphu.nghiasi.model.Toan;
import com.tanphu.nghiasi.repository.ToanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class ToanController {

    @Autowired
    ToanRepository toanRepository;

    //Get all Toan
    @GetMapping("/toan")
    public List<Toan> getAllToan() {
        return toanRepository.findAll();
    }

    //Get a Single Toan
    @GetMapping("/toan/{id}")
    public Toan getToanById(@PathVariable(value = "id") Long toanId) {
        return toanRepository.findById(toanId).orElseThrow(() -> new ResourcesNotFoundException("Toan", "Id", toanId));
    }

    //Create a Toan
    @PostMapping("/toan")
    public Toan creatToan(@Valid @RequestBody Toan toan) {
        return toanRepository.save(toan);
    }

    //Update a Toan
    @PutMapping("/toan/{id}")
    public Toan updateToan(@PathVariable(value = "id") Long toanId, @Valid @RequestBody Toan toanDetails) {
        return toanRepository.findById(toanId).map(toan -> {
            toan.setTen(toanDetails.getTen());
            toan.setQuanThay(toanDetails.getQuanThay());
            toan.setTieuSu(toanDetails.getTieuSu());

            return toanRepository.save(toan);
        }).orElseThrow(() -> new ResourcesNotFoundException("Toan", "Id", toanId));
    }

    //Delete a Toan
    @DeleteMapping("/toan/{id}")
    public ResponseEntity<?> deleteToan(@PathVariable(value = "id") Long toanId) {
        return toanRepository.findById(toanId).map(toan -> {
            toanRepository.delete(toan);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourcesNotFoundException("Toan", "Id", toanId));
    }
}
