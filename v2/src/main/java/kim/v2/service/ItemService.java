package kim.v2.service;

import kim.v2.repository.Item;
import kim.v2.repository.ItemRepository;
import kim.v2.repository.MemoryItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ItemService {
    private final ItemRepository itemRepository;
    public Item saveItem(Item item) {
        return itemRepository.save(item);
    }

    public Item findItem(Long id) {
        return itemRepository.findById(id);
    }


    public List<Item> findAllItems() {
        return itemRepository.findAll();
    }

    public Item updateItem(Long id, Item updateItem) {
        return itemRepository.update(id,updateItem);
    }

    public void deleteItem(Long id) {
        itemRepository.delete(id);
    }

    public void deleteAllItems() {
        itemRepository.clear();
    }
}
