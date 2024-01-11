package kim.v2.repository;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Repository
public class ItemRepository {
    private static Map<Long, Item> store = new HashMap<>();
    private static Long count=0L;

    public Item save(Item item){
        item.setId(++count);
        store.put(item.getId(),item);
        return store.get(count);
    }

    public Item findById(Long id){
        return store.get(id);
    }
    public List<Item> findAll(){
        return new ArrayList<>(store.values());
    }

    public Item update(Long id,Item updateItem){
        Item item = store.get(id);
        item.setItemName(updateItem.getItemName());
        item.setPrice(updateItem.getPrice());
        item.setQuantity(updateItem.getQuantity());
        return item;
    }

    public void delete(Long id){
        store.remove(id);
    }

    public void clear(){
        count=0L;
        store.clear();
    }

    @PostConstruct
    public void method(){
        Item item1 = new Item("item1",10000L,10L);
        Item item2 = new Item("item2",20000L,20L);
        save(item1);
        save(item2);
    }
}
