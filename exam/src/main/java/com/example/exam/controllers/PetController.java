package com.example.exam.controllers;

import com.example.exam.entities.Pet;
import com.example.exam.entities.PetResponse;
import com.example.exam.services.PetServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping
    public ResponseEntity<PetResponse> createPet(@RequestBody Pet pet) {
        return ResponseEntity.status(HttpStatus.CREATED).body(petServiceImpl.savePet(pet));
    }
}
