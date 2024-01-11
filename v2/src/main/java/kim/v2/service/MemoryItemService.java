package kim.v2.service;

import kim.v2.repository.Item;
import kim.v2.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MemoryItemService implements ItemService{
    private final ItemRepository itemRepository;
    @Override
    public Item saveItem(Item item) {
        return itemRepository.save(item);
    }

    @Override
    public Item findItem(Long id) {
        return itemRepository.findById(id);
    }

    @Override
    public List<Item> findAllItems() {
        return itemRepository.findAll();
    }

    @Override
    public Item updateItem(Long id, Item updateItem) {
        return itemRepository.update(id,updateItem);
    }

    @Override
    public void deleteItem(Long id) {
        itemRepository.delete(id);
    }

    @Override
    public void deleteAllItems() {
        itemRepository.clear();
    }
}
