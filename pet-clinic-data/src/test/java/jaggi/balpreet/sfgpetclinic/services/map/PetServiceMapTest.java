package jaggi.balpreet.sfgpetclinic.services.map;

import jaggi.balpreet.sfgpetclinic.model.Pet;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class PetServiceMapTest {
    private PetServiceMap petServiceMap;
    private Long id=1L;

    @BeforeEach
    void setUp() {
        petServiceMap = new PetServiceMap();
        petServiceMap.save(Pet.builder().id(id).build());
    }

    @Test
    void findAll() {
        Set<Pet> petSet = petServiceMap.findAll();
        assertEquals(1,petSet.size());
    }

    @Test
    void findById() {
        Pet pet = petServiceMap.findById(id);
        assertEquals(id,pet.getId());
    }

    @Test
    void save() {
        Long id2 = 2L;
        Pet pet2 = Pet.builder().id(id2).build();
        Pet savedPet = petServiceMap.save(pet2);
        assertEquals(id2, savedPet.getId());
    }

    @Test
    void delete() {
        petServiceMap.delete(petServiceMap.findById(id));
        assertNull(petServiceMap.findById(id));
    }

    @Test
    void deleteById() {
        petServiceMap.deleteById(id);
        assertNull(petServiceMap.findById(id));
    }
}