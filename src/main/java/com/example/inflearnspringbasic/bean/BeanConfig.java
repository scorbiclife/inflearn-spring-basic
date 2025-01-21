package com.example.inflearnspringbasic.bean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class BeanConfig {

    @Bean
    public ClassA beanA() {
        return new ClassA();
    }

    @Bean
    public ClassB beanB() {
        return new ClassB();
    }

    @Bean
    public ClassB beanB2() {
        return new ClassB();
    }


    @Bean
    public ClassC beanC() {
        return new ClassC(beanA());
    }

    @Bean
    public ClassD beanD() {
        return new ClassD();
    }

    @Bean
    public ClassD childBeanD() {
        return new ChildClassD();
    }

    public static class ClassA {
    }

    public static class ClassB {
    }

    public static class ClassC {
        private final ClassA instanceA;

        public ClassC(ClassA instanceA) {
            this.instanceA = instanceA;
        }
    }

    public static class ClassD {
    }

    public static class ChildClassD extends ClassD {
    }
}