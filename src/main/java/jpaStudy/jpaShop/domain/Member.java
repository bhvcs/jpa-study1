package jpaStudy.jpaShop.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Member {
    @Getter
    @Id
    @GeneratedValue//DB의 id 자동 생성 값을 사용하겠다
    @Column(name = "MEMBER_ID")
    private Long id; //id는 엔티티의 식별자 이름이 된다

    @Getter @Setter
    private String name;

    @Getter @Setter
    @Embedded
    private Address address;

    @Getter
    @OneToMany(mappedBy = "member")
    private List<Order> orders = new ArrayList<Order>();
}