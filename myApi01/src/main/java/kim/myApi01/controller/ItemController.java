package kim.myApi01.controller;

import kim.myApi01.dto.ItemDto;
import kim.myApi01.entity.Item;
import kim.myApi01.service.ItemService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ItemController {
    private final ItemService itemService;
    @GetMapping("/items/{id}")
    public ResponseEntity<ItemDto> find(@PathVariable("id")Long id){
        Item item = itemService.find(id);
        return ResponseEntity.ok().body(new ItemDto(item));
    }
    @PostMapping("/items")
    public Item add(@RequestBody ItemDto itemDto){
        return itemService.save(itemDto);
    }
    @GetMapping("/items")
    public List<ItemDto> add(){
        return itemService.findAll()
                .stream()
                .map(ItemDto::new)
                .toList();
    }
    @DeleteMapping("/items/{id}")
    public void delete(@PathVariable("id")Long id){
        itemService.delete(id);
    }
    @PutMapping("/items/{id}")
    public Item update(@PathVariable("id")Long id, @RequestBody ItemDto itemDto){
        return itemService.update(id,itemDto);
    }
}
