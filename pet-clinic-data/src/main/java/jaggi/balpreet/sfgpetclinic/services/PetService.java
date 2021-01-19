package jaggi.balpreet.sfgpetclinic.services;


import jaggi.balpreet.sfgpetclinic.model.Pet;

import java.util.Set;

public interface PetService {
    Pet findById(Long id);

    Pet save(Pet pet);

    Set<Pet> findAll();
}
