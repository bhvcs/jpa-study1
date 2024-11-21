package jpaStudy.jpaShop.domain;

import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.*;

@Entity
@Table(name = "ORDER_ITEM")
public class OrderItem {
    @Id
    @GeneratedValue
    @Column(name = "ORDER_ITEM_ID")
    private Long id;

    @Setter
    @Getter
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ITEM_ID")
    private Item item;

    @Setter
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ORDER_ID")// 연관관계의 주인은 어떤 fk에 맵핑하는지 체크해야됨
    private Order order;

    @Getter
    @Setter
    private int orderPrice; // 주문 가격

    @Setter
    private int count; // 주문 수량

    //생성 메서드
    public static OrderItem createOrderItem(Item item, int orderPrice, int count) {
        OrderItem orderItem = new OrderItem();
        orderItem.setItem(item);
        orderItem.setOrderPrice(orderPrice);
        orderItem.setCount(count);

        item.removeStock(count);// 뭔가 애플리케이션 사용자가 직접 기능을 사용하냐 안하냐로 서비스에서 다룰지,
        // 엔티티에서 구현할지 갈리는 것 같음
        return orderItem;
    }

    //비즈니스 로직

    /**
     * 주문 취소
     */
    public void cancel() {
        getItem().addStock(count);
    }//말 그래도 주문에서 취소하는 것이기 떄문에, Order에서 필요한 것만 구현하면 될 듯

    //조회 로직

    /**
     * 주문상품 전체 가격 조회
     */
    public int getTotalPrice() {
        return count * getOrderPrice();
    }
}