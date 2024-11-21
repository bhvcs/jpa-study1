package jpaStudy.jpaShop.repository;

import jpaStudy.jpaShop.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MemberRepository extends JpaRepository<Member, Long> {
    List<Member> findByName(String name);//스프링 데이터 JPA가 메서드의 이름을 분석하여 쿼리를 실행해 줄 것이다
}
