package hello.core.beanfind;

import hello.core.AppConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

class ApplicationContextInfoTest {

    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

    @Test
    @DisplayName("모든 빈 출력하기")
    void findAllBean(){
        String[] beanDefinitionNames = ac.getBeanDefinitionNames(); // 스프링에 등록된 모든 빈이름 조회(배열로)
        for (String beanDefinitionName : beanDefinitionNames) { // 키: beanDefinition
            Object bean = ac.getBean(beanDefinitionName);       //값: bean, 타입지정x
            System.out.println("name = " + beanDefinitionName + "object = " + bean);
            //ac(스프링 컨테이너)에 등록한 빈을 가져와 object로 꺼내서 출력
        }
    }

    @Test
    @DisplayName("애플리케이션 빈 출력하기")
    void findApplicationBean(){
        String[] beanDefinitionNames = ac.getBeanDefinitionNames(); // 빈 정의된 이름들을 등록(배열로)
        for (String beanDefinitionName : beanDefinitionNames) { // 키: beanDefinition
            BeanDefinition beanDefinition = ac.getBeanDefinition(beanDefinitionName);
            //BeanDefinition:빈에 하나하나에 대한 정보
            //Role ROLE_APPLICATION: 직접 등록한 애플리케이션 빈
            //Role ROLE_INFRASTRUCTURE: 스프링이 내부에서 사용하는 빈
            if (beanDefinition.getRole() == BeanDefinition.ROLE_APPLICATION){ //스프링 내부의 빈이 아닌 내가 개발해서 등록한 빈
                Object bean = ac.getBean(beanDefinitionName);       //값: bean
                System.out.println("name = " + beanDefinitionName + "object = " + bean);
            }
        }
    }

}
