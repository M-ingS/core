package hello.autowired;

import hello.core.member.Member;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.lang.Nullable;

import javax.swing.text.html.Option;
import java.util.Optional;

public class AutowiredTest {

    @Test
    void AutowiredOption() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(TestBean.class);
    }

    static class TestBean {
        //1. 스프링 컨테이너에서 관리하는 멤버가 아닌 것을 호출함(없는 멤버)
        @Autowired(required = false)
        public void setNoBean1(Member noBean1) {
            System.out.println("noBean1 = " + noBean1);
        }   //의존관계가 없다면 메소드 자체가 호출이 안됨
        //2. @Nullable
        @Autowired
        public void setNoBean2(@Nullable Member noBean2) {
            System.out.println("noBean2 = " + noBean2);
        }   //의존관계가 없으면 null이라고 넣고 싶을 때
        //3. Optional
        @Autowired
        public void setNoBean3(Optional <Member> noBean3) {
            System.out.println("noBean3 = " + noBean3);
        }   //값이 없으면 .empty 출력
    }
}
