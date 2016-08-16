package _01_core_spring._03_advanced_wiring._02_conditional_beans.listing_01_03_04_conditionally_configuring_beans;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MagicBeanConfig {

    @Bean
    @Conditional(MagicBeanExistsCondition.class)
    public MagicBean getMagicBean(){
        return new MagicBean();
    }

}
