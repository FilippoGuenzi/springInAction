MINIMAL SPRING XML CONFIGURATION
--------------------------------

To create a new spring configuration XML file use IDE new Spring config file instead of learning it by heart. It just creates the mininum required.
```
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="
       http://www.springframework.org/schema/beans
       http://www.springframework.org/schema/beans/spring-beans.xsd">
</beans>
```
DECLARING BEANS
---------------

Now you can add bean declarations in the middle.
```
<bean id="" class="" />
```
where :
* id is the id you give to the bean : it can be useful for wiring when the depending bean needs to refer to the bean it depends on.
* class is the full canonical name of the implementation class to instantiate as a bean

If the id is omitted Spring will give the bean the full qualified (canonical) class name suffixed with #0 for the 1st instance, #1, ...
Ex : com.soundsystem.SgtPeppers#0. It's better to give a more user-friendly id for the ease of referencing it later. But if you don't have to use this id avoid specifying it so that your xml, already verbose, becomes tinier.

With nothing more Spring will instantiate the bean by using its default constructor.

WIRING BEANS
------------

Spring requires every constructor parameter to be provided in wiring configuration 

In order to achieve wiring by constructor injection :
```
<bean class="...C1">
    <constructor-arg ref="c2"/>
</bean>
<bean id="c2" class="...C2" />
```
where C1 has a constructor taking a C2 object as parameter

When there's more than one parameter in the constructor you add the attribute index=0...n to specify the parameter's position.
```
<bean class="...C1">
    <constructor-arg index=0 ref="c2"/>
    <constructor-arg index=1 ref="c3"/>
</bean>
<bean id="c2" class="...C2" />
<bean id="c3" class="...C3" />
```
or 
```
<bean class="...C1" c:abcd-ref="c2"/> //where abcd is the C1 constructor C2 parameter name : class C1 { public C1(C2 abcd){...} }
<bean id="c2" class="...C2" />
```
In order to use c-ref attribute you need to add its namespace to the beans tag : xmlns:c="http://www.springframework.org/schema/c"
You can also use an attribute refering to the parameter position in the constructor : c:_0-ref
(! this one its not working here) If you have just one parameter you can also say : c:_-ref avoiding to give its position
You can also add 

INJECTING VALUES INSTEAD OF BEANS
---------------------------------

If instead of wiring beans together by constructor injection you want to pass the constructors values :
```
<bean class="...C1">
    <constructor-arg value="Les Misérables"/>
    <constructor-arg value="Victor Hugo"/>
</bean>
```
Or more explicitly, with the index representing the parameter's position in parameter's list :
```
<bean class="...C1">
    <constructor-arg index=0 value="Les Misérables"/>
    <constructor-arg index=1 value="Victor Hugo"/>
</bean>
```
You can do the same with c: argument :
```
<bean class="...C1" c:title="Les Misérables" c:author="Victor Hugo"/>
```
notice that for values -ref has disapppeared.

or with parameter indexes
```
<bean class="...C1" c:_0="Les Misérables" c:_1="Victor Hugo"/>
```
WIRING COLLECTIONS
------------------
```
<bean class="...">
    <constructor-arg>
        <list>
            <value></value>
            ...
            <value></value>
        </list>
    </constructor-arg>
</bean>
```
```
<bean class="...">
    <constructor-arg>
        <list>
            <ref bean="..."/>
            ...
            <ref bean="..."/>
        </list>
    </constructor-arg>
</bean>
```
We can use set instead of list.
Either set or list can be wired into a list, set or even array !! The only difference is that with sets duplicates are discarded and order is not maintained.

PROPERTY (SETTER) INJECTION
---------------------------
```
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd">

    <bean class="_01_core_spring._02_wiring_beans._04_wiring_beans_with_xml._04_setting_properties._01_CHOOSING_BETWEEN_CONSTRUCTOR_INJECTION_AND_PROPERTY_INJECTION.CDPlayer">
        <property name="cd" ref="cDisc"/>
    </bean>

    <bean id="cDisc" class="_01_core_spring._02_wiring_beans._04_wiring_beans_with_xml._04_setting_properties._01_CHOOSING_BETWEEN_CONSTRUCTOR_INJECTION_AND_PROPERTY_INJECTION.CompactDisc">
        ...
    </bean>

</beans>
```
Your IDE won't require you to add a property because, contrarily than at initialisaton of a bean with only a non default constructor, the method call is not required for the initialisation and is therefore optional.

As we had a c-namespace for constructor injection we have a p-namespace for property/field injection. It works the same.

Injecting values you'll have a value attribute instead of a ref attribute. You also need to fill the name attribute, which is the property name.
With p-namespace you'll have a p:propertyName attribute instead of a c:parameterName-ref attribute.
```
|                      | injecting bean references  | injecting values             | injecting collections of bean refs                             | injecting collections of values                                 |
|----------------------|----------------------------|------------------------------|----------------------------------------------------------------|-----------------------------------------------------------------|
| through constructor  | <constructor-arg ref="" /> | <constructor-arg value="" /> | <constructor-arg index=""><list><ref bean=""/></li..></cons..> | <constructor-arg index=""><list><value></value></li..></cons..> |
|                      | ... c:paramName-ref="" ... | ... c:paramName="" ...       |                                                                |                                                                 |
|                      | ... c:_0-ref="" ...        | ... c:_0="" ...              |                                                                |                                                                 |
| through other method | <property ref=""/>         | <property value="" />        | <property name=""><list><value></value></list></prop..>                                                                |                                                                 |
|                      | ... c:fieldName-ref="" ... | ... c:fieldName="" ...       |                                                                |                                                                 |
|                      | ... c:_0-ref="" ...        | ... c:_0="" ...              |                                                                |                                                                 |
```
No collection wiring via c-namespace or p-namespace, be it for beans refs or for values.

You also have a util namespace providing :
* util:list for declaring a <util:list> of refs/values as a java.util.List
* util:set idem with set
* util:map idem with set
* util:constant
* util:properties
* util:property-path

In order to use those you need to add in your config :
```
xmlns:util="http://www.springframework.org/schema/util"
xsi:schemaLocation="
        ...
        http://www.springframework.org/schema/util
        http://www.springframework.org/schema/util/spring-util.xsd
        ...
```
