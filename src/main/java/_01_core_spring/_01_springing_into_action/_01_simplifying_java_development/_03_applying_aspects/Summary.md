Some cross-concerns/system-wide functionalities, as logging, security, transaction management can be invoked in many components.
The business components, which have their own functionality, are scattered with lines of different functionality.
To group the system-wide logic into one single place (more reusable if you change the logic) and to let the business components as plain POJOs
we use AOP.

With AOP any Aspect, like Minstrel here, is a simple POJO to be declared as a spring bean.
Minstrel doesn't know about the Knight and the Knight doesn't know about the Minstrel. Both are unaware of each other.
Both are simple beans.
Spring context configuration turns Minstrel into an aspect.

AOP configuration
-----------------
```
<beans xmlns="http://www.springframework.org/schema/beans"
       ...
       xmlns:aop="http://www.springframework.org/schema/aop"
       xsi:schemaLocation="
       ...
       http://www.springframework.org/schema/aop
       http://www.springframework.org/schema/aop/spring-aop-3.2.xsd">

    ...

    <bean id="minstrel" ...>...</bean>
    <aop:config>
        <aop:aspect ref="minstrel"> <!--turns the minstrel bean into an aspect-->

            <!--poincut : where about the advices will be applied-->
            <aop:pointcut id="embark" expression="execution(* *.embarkOnQuest(..))"/>

            <!--before advice-->
            <aop:before method="singBeforeQuest" pointcut-ref="embark"/>

            <!--after advice-->
            <aop:after method="singAfterQuest" pointcut-ref="embark"/>

        </aop:aspect>
    </aop:config>
```
