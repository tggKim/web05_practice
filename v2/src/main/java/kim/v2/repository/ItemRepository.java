package kim.v2.repository;

import java.util.ArrayList;
import java.util.List;

public interface ItemRepository {
    public Item save(Item item);

    public Item findById(Long id);
    public List<Item> findAll();

    public Item update(Long id,Item updateItem);

    public void delete(Long id);

    public void clear();
}
