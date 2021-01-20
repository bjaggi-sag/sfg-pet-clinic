package jaggi.balpreet.sfgpetclinic.services.map;

import jaggi.balpreet.sfgpetclinic.model.BaseEntity;
import jaggi.balpreet.sfgpetclinic.services.CrudService;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public abstract class AbstractMapService<T extends BaseEntity,ID> implements CrudService<T,ID> {

    protected Map<ID,T> map = new HashMap<>();

    @Override
    public Set<T> findAll() {
        return new HashSet<>(map.values());

    }

    @Override
    public T findById(ID id) {
        return map.get(id);

    }
    @Override
    public T save(T object){
        map.put((ID)object.getId(), object);
        return object;
    }

    @Override
    public void delete(T object) {
        map.entrySet().removeIf(entry -> entry.getValue().equals(object));
    }

    @Override
    public void deletById(ID id) {
        map.remove(id);
    }
}
