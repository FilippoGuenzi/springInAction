package _01_core_spring._03_advanced_wiring._05_runtime_value_injection._02_wiring_with_the_spring_expression_language._01_a_few_examples;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class MyBean {

    private String value;
    private long currentMillis;
    private int myOtherBeanSize;
    private Integer property;

    @Autowired
    public MyBean(
            @Value("#{1}") String value,
            @Value("#{T(java.lang.System).currentTimeMillis()}") long millis,
            @Value("#{myOtherBean.size}") int mob,
            @Value("#{systemProperties['myotherbeansize']}") Integer property
    )  {
        this.value = value;
        this.currentMillis = millis;
        this.myOtherBeanSize = mob;
        this.property = property;
    }

    public void showValue() {
        System.out.println(value);
    }

    public void showMillis() {
        System.out.println(this.currentMillis);
    }

    public void showMyOtherBeanSize() {
        System.out.println(this.myOtherBeanSize);
    }

    public void readProperty(){
        System.out.println(this.property);
    }
}
