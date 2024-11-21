package jpaStudy.jpaShop.repository;

import jpaStudy.jpaShop.domain.Order;

import jpaStudy.jpaShop.repository.custom.CustomOrderRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long>, JpaSpecificationExecutor<Order>, CustomOrderRepository {
}//OrderRepository의 복잡한 검색 기능을 명세로 구현하겠다
