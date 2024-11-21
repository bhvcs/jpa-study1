package jpaStudy.jpaShop.domain;

import jpaStudy.jpaShop.domain.status.DeliveryStatus;
import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.*;

@Entity
public class Delivery {
    @Id
    @GeneratedValue
    @Column(name = "DELIVERY_ID")
    private Long id;

    @Setter
    @OneToOne(mappedBy = "delivery")// 연관관계의 하인
    private Order order;

    @Embedded
    private Address address;

    @Getter
    @Enumerated(EnumType.STRING)
    private DeliveryStatus status; // READY(준비), COMP(배송)

    public Delivery() {
    }

    public Delivery(Address address) {
        this.address = address;
        this.status = DeliveryStatus.READY;
    }
}
