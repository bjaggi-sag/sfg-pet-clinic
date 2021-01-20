package jaggi.balpreet.sfgpetclinic.services;

import jaggi.balpreet.sfgpetclinic.model.Owner;


public interface OwnerService extends CrudService<Owner, Long> {

    Owner findByLastName(String lastName);
}
