package com.tanphu.nghiasi.controller;

import com.tanphu.nghiasi.exception.ResourcesNotFoundException;
import com.tanphu.nghiasi.model.Role;
import com.tanphu.nghiasi.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class RoleController {

    @Autowired
    RoleRepository roleRepository;

    //Get All Role
    @GetMapping("/role")
    public List<Role> getAllRole() {
        return roleRepository.findAll();
    }

    //Get a Single Role
    @GetMapping("/role/{id}")
    public Role getRoleById(@PathVariable(value = "id") Long roleId) {
        return roleRepository.findById(roleId).orElseThrow(() -> new ResourcesNotFoundException("Role", "id", roleId));
    }
    
//    //Create a new Role
//    @PostMapping("/role")
//    public Role createRole(@Valid @RequestBody Role role) {
//        return roleRepository.save(role);
//    }
//
//    //Delete a Role
//    @DeleteMapping("/role/{id}")
//    public void deleteById(@PathVariable(value = "id") Long roleId) {
//        roleRepository.deleteById(roleId);
//    }
//
//    //Update a Role
//    @PutMapping("/role/{id}")
//    public Role updateRole(@PathVariable(value = "id") Long roleId, @Valid @RequestBody Role roleDetails) {
//        Role role = roleRepository.findById(roleId).orElseThrow(() -> new ResourcesNotFoundException("Role", "id", roleId));
//
//        role.setTen(roleDetails.getTen());
//
//        Role updatedRole = roleRepository.save(role);
//
//        return updatedRole;
//    }
}
