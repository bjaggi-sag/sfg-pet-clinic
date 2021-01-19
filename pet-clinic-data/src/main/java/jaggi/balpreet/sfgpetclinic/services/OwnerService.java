package jaggi.balpreet.sfgpetclinic.services;

import jaggi.balpreet.sfgpetclinic.model.Owner;

import java.util.Set;

public interface OwnerService {

    Owner findById(Long id);

    Owner save(Owner owner);

    Set<Owner> findAll();
}
