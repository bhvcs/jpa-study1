package jpaStudy.jpaShop.repository;

import jpaStudy.jpaShop.domain.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Long> {
}
