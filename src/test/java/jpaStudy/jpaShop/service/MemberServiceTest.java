package jpaStudy.jpaShop.service;

import jpaStudy.jpaShop.config.AppConfig;
import jpaStudy.jpaShop.domain.Member;
import jpaStudy.jpaShop.repository.MemberRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@ContextConfiguration(classes = AppConfig.class)//, loader = AnnotationConfigContextLoader.class) //스프링 컨테이너에 빈을 추가하기 위해서는 설정 파일이 필요하다
//@ContextConfiguration(locations = "classpath:appConfig.xml")
@ExtendWith(SpringExtension.class)
@Transactional
class MemberServiceTest {

    @Autowired MemberService memberService;
    @Autowired
    MemberRepository memberRepository;

    @Test
    void 회원가입() throws Exception {
        //Given
        Member member = new Member();
        member.setName("kim");

        //When
        Long saveId = memberService.join(member);

        //Then
        assertEquals(member, memberRepository.findById(saveId).get());
        assertTrue(member == memberRepository.findById(saveId).get());//객체와 영속성 컨텍스트
    }

    @Test
    void 중복_회원_예외() throws Exception{
        //Given
        Member member1 = new Member();
        member1.setName("kim");

        Member member2 = new Member();
        member2.setName("kim");

        //When
        memberService.join(member1);

        //Then
        IllegalStateException thrown = assertThrows(IllegalStateException.class, () -> memberService.join(member2));
        assertEquals("이미 존재하는 회원입니다.", thrown.getMessage());
    }




    @Test
    void findMembers() {
    }

    @Test
    void findOne() {
    }
}