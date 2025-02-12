package com.example.exam.services;
import com.example.exam.entities.Pet;
import com.example.exam.entities.PetResponse;
import com.example.exam.third.PetStore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

@Service
public class PetServiceImpl {

    @Autowired
    private PetStore petStore;

    public Optional<Pet> getPetById(Long PetId) {
        Pet pet = petStore.getPetById(PetId);
        System.out.println("Se obtuvo la información de la mascota: " + pet);
        return Optional.ofNullable(pet);
    }

    public PetResponse savePet(Pet pet) {
        Pet createdPet = petStore.savePet(pet);
        PetResponse petResponse = new PetResponse();
        petResponse.setTransactionId(UUID.randomUUID().toString());
        petResponse.setDateCreated(LocalDateTime.now());
        petResponse.setStatus(createdPet.getStatus());
        petResponse.setName(createdPet.getName());
        System.out.println("Se guardó la información de la mascota: " + petResponse);
        return petResponse;
    }
}
