package jpaStudy.jpaShop.domain;

import jakarta.persistence.criteria.*;
import jpaStudy.jpaShop.domain.status.OrderStatus;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;

public class OrderSpec {//명세를 작성하기 위한 클래스

    public static Specification<Order> memberNameLike(final String memberName) {
        return new Specification<Order>(){
            public Predicate toPredicate(Root<Order> root, CriteriaQuery<?> query, CriteriaBuilder builder) {
                if(StringUtils.isEmpty(memberName)) return null;

                Join<Order, Member> m = root.join("member", JoinType.INNER);// 회원과 조인
                return builder.like(m.<String>get("name"), "%" + memberName + "%");
            }
        };
    }

    public static Specification<Order> orderStatusEq(final OrderStatus orderStatus) {
        return new Specification<Order>(){//Specification<Order> 형의 객체를 반환하는데 이는 밑의 메서드를 포함하는 클래스의 객체다
            public Predicate toPredicate(Root<Order> root, CriteriaQuery<?> query, CriteriaBuilder builder) {
                if(orderStatus == null) return null;

                return builder.equal(root.get("status"), orderStatus);
            }
        };
    }
}
