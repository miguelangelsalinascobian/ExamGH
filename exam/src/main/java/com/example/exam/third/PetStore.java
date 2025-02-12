package com.example.exam.third;

import com.example.exam.entities.Pet;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class PetStore {
    private final String url = "https://petstore.swagger.io/v2/pet/";
    private RestTemplate restTemplate = new RestTemplate();

    public Pet getPetById(Long petId) {
        return restTemplate.getForObject(url + petId, Pet.class);
    }

    public Pet savePet(Pet pet) {
        return restTemplate.postForObject(url, pet, Pet.class);
    }
}