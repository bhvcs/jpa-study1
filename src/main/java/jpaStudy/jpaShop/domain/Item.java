package jpaStudy.jpaShop.domain;

import lombok.Getter;

import jakarta.persistence.*;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "DTYPE") //상속
public abstract class Item implements TitleView {

    @Getter @Setter
    @Id
    @GeneratedValue
    @Column(name = "ITEM_ID")
    private Long id;

    @Setter @Getter
    private String name;

    @Setter @Getter
    private int price;
    @Setter @Getter
    private int stockQuantity;

    @ManyToMany(mappedBy = "items")
    private List<Category> categories = new ArrayList<Category>();

    //비즈니스 로직
    public void addStock(int quantity) {
        this.stockQuantity += quantity;
    }

    public void removeStock(int quantity) {
        int restStock = this.stockQuantity - quantity;
        if (restStock < 0) {
            throw new NotEnoughStockException("need more stock");
        }
        this.stockQuantity = restStock;
    }
}
