package hello.core.beanfind;

import hello.core.AppConfig;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class ApplicationContextBasicFindTest {

    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

    @Test
    @DisplayName("빈 이름으로 조회")       //이름, 타입으로 조회
    void findBeanByName() {
        MemberService memberService = ac.getBean("memberService", MemberService.class); //(빈이름, 타입)
        assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
        //멤버서비스가 임플의 인스턴스면 테스트 성공
        //memberService 변수 내에 담긴 실제 객체(MemberServiceImpl타입의 객체)가
        // MemberServiceImpl 타입의 인스턴스인지 비교
    }

    @Test
    @DisplayName("이름 없이 타입으로만 조회")      //타입으로 조회
    void findBeanByType() {
        MemberService memberService = ac.getBean(MemberService.class); //(타입)
        assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
    }

    @Test
    @DisplayName("구체 타입으로 조회")      //인터페이스가 아닌 구체 타입으로 조회(구현에 의존)
    void findBeanByName2() {
        MemberService memberService = ac.getBean("memberService", MemberServiceImpl.class);
        assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
    }

    @Test       //실패 테스트(등록되지 않은 빈으로 테스트)
    @DisplayName("빈 이름으로 조회")
    void findBeanByNameX() {
        //ac.getBean("xxxx", MemberService.class);
        MemberService xxxx = ac.getBean("xxxx", MemberService.class);
        assertThrows(NoSuchBeanDefinitionException.class,
                () -> ac.getBean("xxxx", MemberService.class));
        //실행했을 때 Nosuch예외가 터지면 테스트 성공
    }

}
