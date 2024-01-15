package kim.myApi01.service;

import kim.myApi01.dto.ItemDto;
import kim.myApi01.entity.Item;
import kim.myApi01.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ItemService {
    private final ItemRepository itemRepository;
    public Item save(ItemDto itemDto){
        Item item = itemDto.make();
        itemRepository.save(item);
        return item;
    }
    public Item find(Long id){
        return itemRepository.findById(id)
                .orElseThrow(()->new IllegalArgumentException("not found: "+id));
    }
    public List<Item> findAll(){
        return itemRepository.findAll();
    }
    public void delete(Long id){
        itemRepository.deleteById(id);
    }
    @Transactional
    public Item update(Long id,ItemDto itemDto){
        Item item = itemRepository.findById(id)
                .orElseThrow(()->new IllegalArgumentException("not found: "+id));
        item.update(itemDto.getTitle(),itemDto.getName());
        return item;
    }
}
