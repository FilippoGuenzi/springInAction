No injection of any kind
------------------------
When each class is responsible to create its own references to collaborating classes we get highly-coupled and hard to test code.
Example with the DamselRescuingKnight (no constructor injection, no other injection) :
* so far he is not able to do any other quest than a RescueDamselQuest
* if we want to make him pursue another quest we have to change it inside the Knight implementation
* it's impossible to test because we can't have the reference to the quest inside the test

Constructor injection
---------------------
BraveKnight isn't coupled to any specific implementation since the dependence is of the quest interface type.
Since you provide the knight the quest he can embark on you can test it easily providing him a mock quest.

How to provide a Quest to the Knight ?

XML wiring
----------
```
<beans>
    <bean id="a" class="...implementationClassA">
        <constructor-arg ref="b"/>
    </bean>
    <bean id="b" class="...implementationClassB">
</beans>
```
In ```class="..."``` you don't specify the interface but the real implementation that will be initialized with it's full Canonical Name.
In ```ref``` of the ```constructor-arg``` you put the id of the been that will be injected.
Instead of ```ref``` you can have ```value```, when you're injecting beans you directly point to with the Spring Expression Language SpEL.
A good place for spring xml configuration files to be seen by spring is ```src/main/resources``` or subfolders.

Java wiring
-----------
```
@Configuration
public class KnightConfig {
    @Bean
    public Knight knight(){
        return new BraveKnight(quest());
    }
    @Bean
    public Quest quest(){
        return new SlayDragonQuest(System.out);
    }
}
```
In both XML-based and Java-based config classes don't know the implementation of their dependencies.
Implementations can be changed without changing the classes themselves.
Only spring knows the exact implementation that will be injected through configuration.

So far nothing happens. We need to start an application context where the beans will be loaded.

Starting a context
------------------
```
ClassPathXMLApplicationContext springContext = new ClassPathXMLApplicationContext(".../xmlconfig.xml")
```
or
```
AnnotationConfigApplicationContext springContext = new AnnotationConfigApplicationContext(ConfigClass.class)
```
Retrieving main bean
--------------------
```
springContext.getBean(MainBean.class)
```
Closing the spring context
--------------------------
```
springContext.close();
```
See listing 01_08
