package hello.core;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.MemberRepository;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//@Configuration
public class AppConfig {

    @Bean
    public MemberService memberService() {
        System.out.println("call AppConfig.memberService");
        //return new MemberServiceImpl(new MemoryMemberRepository());
        //MemberSerivice 구현 객체가 생성이 될 때 메모리멤버 리포지토리를 불러옴
        return new MemberServiceImpl(memberRepository()); //생성자 주입
    }

    @Bean
    public OrderService orderService() {
        System.out.println("AppConfig.orderService");
        //return new OrderServiceImpl(new MemoryMemberRepository(),new FixDiscountPolicy());
        //OrderServiceImpl 반환될 때 2가지를 불러옴
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    @Bean
    public MemberRepository memberRepository() {
        System.out.println("AppConfig.memberRepository");
        return new MemoryMemberRepository();
    }

    @Bean
    public DiscountPolicy discountPolicy() {
        //return new FixDiscountPolicy();
        return new RateDiscountPolicy();    //정률 할인으로 변경

    }
}
