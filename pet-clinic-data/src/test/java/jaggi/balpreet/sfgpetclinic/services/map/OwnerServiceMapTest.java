package jaggi.balpreet.sfgpetclinic.services.map;

import jaggi.balpreet.sfgpetclinic.model.Owner;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class OwnerServiceMapTest {

    OwnerServiceMap ownerServiceMap;
    final Long id = 1L;
    final String lastName = "smith";

    @BeforeEach
    void setUp() {

        ownerServiceMap = new OwnerServiceMap(new PetServiceMap(), new PetTypeServiceMap());
        Owner owner = Owner.builder().id(id).lastName(lastName).build();
        ownerServiceMap.save(owner);


    }

    @Test
    void findAll() {
        Set<Owner> ownerSet = ownerServiceMap.findAll();
        assertEquals(1,ownerSet.size());
    }

    @Test
    void findById() {
        Owner savedOwner = ownerServiceMap.findById(id);
        assertEquals(id,savedOwner.getId());
    }

    @Test
    void save() {
        Long id2 = 2L;
        Owner owner2 = ownerServiceMap.save(Owner.builder().id(id2).build());
        assertEquals(id2,owner2.getId());
    }

    @Test
    void delete() {
        ownerServiceMap.delete(ownerServiceMap.findById(id));
        assertEquals(0, ownerServiceMap.findAll().size());
    }

    @Test
    void deleteById() {
        ownerServiceMap.deleteById(id);
        assertEquals(0,ownerServiceMap.findAll().size());
    }

    @Test
    void findByLastName() {
        Owner smith = ownerServiceMap.findByLastName(lastName);
        assertNotNull(smith);
        assertEquals(id,smith.getId());
    }
}