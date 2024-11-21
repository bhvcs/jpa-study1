package jpaStudy.jpaShop.domain;

import jpaStudy.jpaShop.domain.status.OrderStatus;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.domain.Specification;

import static jpaStudy.jpaShop.domain.OrderSpec.memberNameLike;
import static jpaStudy.jpaShop.domain.OrderSpec.orderStatusEq;
import static org.springframework.data.jpa.domain.Specification.where;

@Getter @Setter
public class OrderSearch {
    private String memberName;
    private OrderStatus orderStatus;

    public Specification<Order> toSpecification(){
        return where(memberNameLike(memberName)).and(orderStatusEq(orderStatus));
    }

}
