package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MemberApp {
    public static void main(String[] args) {
//          MemberService memberService = new MemberServiceImpl();   //기존의 DI 하기 전

//        AppConfig appConfig = new AppConfig();                //DI 해준 버전
//        MemberService memberService = appConfig.memberService();
//        // appConfig에서 멤버서비스 요청하면 멤버서비스 인터페이스를 줌(멤버서비스임플이 들어감)

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        //스프링 빈에다가 생성한 객체를 넣어서 관리해줌
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);
        //스프링 컨테이너를 통해 getBean으로 멤버서비스(메소드)의 이름과
        // 반환타입(멤버서비스.class)으로 꺼냄


        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member);

        Member findMember = memberService.findMember(1L);
        System.out.println("new member= " + member.getName());
        System.out.println("find Member" + findMember.getName());
        //가입된 멤버가 제대로 가입됐는지 확인(가입된 멤버와 찾은 멤버가 같은지)
    }
}
