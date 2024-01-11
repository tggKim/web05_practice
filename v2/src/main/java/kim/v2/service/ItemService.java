package kim.v2.service;

import kim.v2.repository.Item;

import java.util.List;

public interface ItemService {
    public Item saveItem(Item item);
    public Item findItem(Long id);
    public List<Item> findAllItems();
    public Item updateItem(Long id,Item updateItem);
    public void deleteItem(Long id);
    public void deleteAllItems();
}
