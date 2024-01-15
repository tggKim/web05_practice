package kim.myApi01.dto;

import kim.myApi01.entity.Item;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class ItemDto {
    private String title;
    private String name;

    public ItemDto(Item item){
        this.title=item.getTitle();
        this.name=item.getName();
    }
    public Item make(){
        return Item.builder().title(title).name(name).build();
    }
}
