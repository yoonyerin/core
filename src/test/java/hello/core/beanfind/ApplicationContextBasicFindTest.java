package hello.core.beanfind;

import hello.core.AppConfig;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class ApplicationContextBasicFindTest {

    AnnotationConfigApplicationContext ac=new AnnotationConfigApplicationContext(AppConfig.class);

    void findBeanByName(){
        MemberService memberService=ac.getBean("memberService", MemberService.class);
        assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
    }

    @DisplayName("이름없이 타입으로 조회")
    @Test
    void findBeanByType(){
        MemberService memberService=ac.getBean( MemberService.class);
        assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
    }


    @Test
    @DisplayName("구체타입으로 조회")
    void findBeanByName2(){
        MemberServiceImpl memberService=ac.getBean("memberService", MemberServiceImpl.class);
        assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
    }

    @Test
    @DisplayName("구체타입으로 조회")
    void findBeanByNameX(){
        Assertions.assertThrows(NoSuchBeanDefinitionException.class, ()->ac.getBean("xxxxx", MemberService.class));

    }

}
