package jpaStudy.jpaShop.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jpaStudy.jpaShop.domain.Member;

import java.util.List;

//@Repository
public class MemberRepository_notInterface {
    @PersistenceContext//영속성 컨텍스트, 컨테이너가 제공하는 엔티티 메니저를 주입하는 코드임, 이를 사용해야 컨테이너가 제공하는 기능도 사용할 수 있다
    private EntityManager em;

//    public MemberRepository(EntityManager em) {
//        this.em = em;
//    }

    public void save(Member member) {
        em.persist(member);
    }

    public Member findOne(Long id) {
        return em.find(Member.class, id);//영속성 컨텍스트에서 엔티티 식별자로 찾는거지
    }

    public List<Member> findAll() {
        return em.createQuery("select m from Member m", Member.class)
                .getResultList(); // jpql 코드
    }

    public List<Member> findByName(String name) {
        return em.createQuery("select m from Member m where m.name = :name", Member.class)
                .setParameter("name", name).getResultList();
    }
}
