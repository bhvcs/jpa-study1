package jpaStudy.jpaShop.repository;

import jpaStudy.jpaShop.domain.Item;
import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.List;

@Repository
public class ItemRepository_notInterface {
    @PersistenceContext
    EntityManager em; //컨테이너로부터 엔티티 메니저를 주입 받음

    public void save(Item item) {
        if (item.getId() == null) {
            em.persist(item);
        }else{
            em.merge(item);//준영속 상태의 엔티티를 수정할 떄 사용함
        }
    }

    public Item findOne(Long id) {
        return em.find(Item.class, id);
    }

    public List<Item> findAll() {
        return em.createQuery("select i from Item i", Item.class).getResultList();
    }
}
