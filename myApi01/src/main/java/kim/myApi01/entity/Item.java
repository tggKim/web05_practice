package kim.myApi01.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
@Entity
@NoArgsConstructor(access= AccessLevel.PROTECTED)
@Getter
public class Item {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String title;
    @Column
    private String name;
    @Builder
    public Item(String title,String name){
        this.title=title;
        this.name=name;
    }
    public void update(String title,String name){
        this.title=title;
        this.name=name;
    }
}
