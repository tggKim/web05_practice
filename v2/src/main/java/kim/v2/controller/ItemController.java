package kim.v2.controller;

import kim.v2.repository.Item;
import kim.v2.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/items")
public class ItemController {
    private final ItemService itemService;
    @GetMapping
    public String items(Model model){
        List<Item> items = itemService.findAllItems();
        model.addAttribute("items",items);
        return "items";
    }
    @GetMapping("/add")
    public String itemAdd(){
        return "addForm";
    }
    @PostMapping("/add")
    public String add(@ModelAttribute Item item){
        itemService.saveItem(item);
        return "redirect:/items";
    }
    @GetMapping("/{itemId}")
    public String item(@PathVariable("itemId") Long id,Model model){
        Item item = itemService.findItem(id);
        model.addAttribute("item",item);
        return "item";
    }
    @GetMapping("/{itemId}/update")
    public String update(@PathVariable("itemId")Long id,Model model){
        Item item = itemService.findItem(id);
        model.addAttribute("item",item);
        return "updateForm";
    }
    @PostMapping("/{itemId}/update")
    public String update2(@PathVariable("itemId")Long id,@ModelAttribute Item item,Model model){
        Item updateItem = itemService.updateItem(id,item);
        model.addAttribute("item",updateItem);
        return "redirect:/items/"+updateItem.getId();
    }
    @GetMapping("/{itemId}/delete")
    public String del(@PathVariable("itemId") Long id){
        itemService.deleteItem(id);
        return "redirect:/items";
    }
    @GetMapping("/deleteAll")
    public String delAll(){
        itemService.deleteAllItems();
        return "redirect:/items";
    }
}
