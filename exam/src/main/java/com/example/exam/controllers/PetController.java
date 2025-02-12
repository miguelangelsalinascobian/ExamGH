package com.example.exam.controllers;

import com.example.exam.entities.Pet;
import com.example.exam.services.PetServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api/pet")
public class PetController {
    @Autowired
    private PetServiceImpl petServiceImpl;

    @GetMapping("{Id}")
    public ResponseEntity<Pet> getPetById(@PathVariable Long Id){
        Optional<Pet> petOptional = petServiceImpl.getPetById(Id);
        if(petOptional.isPresent()){
            return ResponseEntity.ok(petOptional.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }
}
