package jaggi.balpreet.sfgpetclinic.services.map;

import jaggi.balpreet.sfgpetclinic.model.PetType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class PetTypeServiceMapTest {

    PetTypeServiceMap petTypeServiceMap;
    Long id = 2L;

    @BeforeEach
    void setUp() {
        petTypeServiceMap = new PetTypeServiceMap();
        PetType petType = PetType.builder().id(id).build();
        petTypeServiceMap.save(petType);
    }

    @Test
    void findAll() {
        Set<PetType> petTypes = petTypeServiceMap.findAll();
        assertEquals(1,petTypes.size());
    }

    @Test
    void deleteById() {
        petTypeServiceMap.deleteById(id);
        assertNull(petTypeServiceMap.findById(id));
    }

    @Test
    void delete() {
        petTypeServiceMap.delete(petTypeServiceMap.findById(id));
        assertNull(petTypeServiceMap.findById(id));
    }

    @Test
    void save() {
        Long id2 = 2L;
        PetType petType2 = PetType.builder().id(id2).build();
        petTypeServiceMap.save(petType2);
        assertEquals(id2, petType2.getId());
    }

    @Test
    void findById() {
        PetType petType = petTypeServiceMap.findById(id);
        assertEquals(id,petType.getId());
    }
}