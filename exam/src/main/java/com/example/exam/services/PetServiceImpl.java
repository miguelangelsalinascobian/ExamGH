package com.example.exam.services;
import com.example.exam.entities.Pet;
import com.example.exam.third.PetStore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PetServiceImpl {

    @Autowired
    private PetStore petStore;

    public Optional<Pet> getPetById(Long PetId) {
        Pet pet = petStore.getPetById(PetId);
        System.out.println("Se obtuvo la información del pet: " + pet);
        return Optional.ofNullable(pet);
    }
}
