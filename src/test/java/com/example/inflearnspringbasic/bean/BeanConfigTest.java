package com.example.inflearnspringbasic.bean;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.beans.factory.NoUniqueBeanDefinitionException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Map;

import static com.example.inflearnspringbasic.bean.BeanConfig.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

class BeanConfigTest {

    private final AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(BeanConfig.class);

    @Test
    public void testBeanDefinitionAvailable() {
        String[] beanDefinitionNames = context.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            BeanDefinition beanDefinition = context.getBeanDefinition(beanDefinitionName);
            int role = beanDefinition.getRole();
            if (role == BeanDefinition.ROLE_APPLICATION) {
                Object bean = context.getBean(beanDefinitionName);
                System.out.println("bean = " + bean);
            }
        }
    }

    @Test
    public void testGetBeanWithUniqueClass() {
        assertDoesNotThrow(() -> context.getBean(ClassA.class));
    }

    @Test
    public void testGetBeanWithNonUniqueClass() {
        assertThrows(NoUniqueBeanDefinitionException.class, () -> context.getBean(ClassB.class));
    }

    @Test
    void testGetBeanWithUniqueName() {
        assertDoesNotThrow(() -> context.getBean("beanA"));
        assertDoesNotThrow(() -> context.getBean("beanA", ClassA.class));
    }

    @Test
    void testGetBeanWithNonUniqueName() {
        assertThrows(NoSuchBeanDefinitionException.class, () -> context.getBean("beanX"));
    }

    @Test
    void testGetBeanWithSubclass() {
        Map<String, ClassD> beansOfType = context.getBeansOfType(ClassD.class);
        ClassD childBeanD = beansOfType.get("childBeanD");
        assertThat(childBeanD).isNotNull();
        assertThat(childBeanD.getClass()).isEqualTo(ChildClassD.class);
    }
}