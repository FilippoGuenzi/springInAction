Some resources are necessary in one environment (dev vs prod) and are replaced by others in other environments.
Instead of making the resource decision at build time, i.e. of building different artifacts depending on the environment they target 
we can build an only artifact which will select the appropriate resources at runtime.


Configuring profiles in Java config
-----------------------------------
Spring introduced a @Profile annotation that you use in a @Configuration annotated class :
* whether at class level
* or at @Bean level

Any bean that isn't annotated by a profile or whose configuration class isn't annotated by a profile will always be created.

Configuring profiles in XML config
----------------------------------
```
    <beans xmlns="..." ... profile="">...</beans>
```
or
```
    <beans xmlns="..." ... >
    
        <beans profile="dev">
            <bean class="..."/>
            <bean class="..."/>
        </beans>
    
        <beans profile="prod">
            <bean class="..."/>
            <bean class="..."/>
        </beans>
    
    </beans>
```
