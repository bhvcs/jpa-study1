package jpaStudy.jpaShop.repository.custom;

import jpaStudy.jpaShop.domain.Order;
import jpaStudy.jpaShop.domain.OrderSearch;

import java.util.List;

public interface CustomOrderRepository {//스프링 데이터 JPA가 제공하는 공통 인터페이스를 직접 구현할 수 없기 떄문에 이 인터페이스를 생성
    public List<Order> search(OrderSearch orderSearch);
}
