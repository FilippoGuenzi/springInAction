MINIMAL SPRING XML CONFIGURATION
--------------------------------

To create a new spring configuration XML file use IDE new Spring config file instead of learning it by heart. It just creates the mininum required.

<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="
       http://www.springframework.org/schema/beans
       http://www.springframework.org/schema/beans/spring-beans.xsd">
</beans>

DECLARING BEANS
---------------

Now you can add bean declarations in the middle.

<bean id="" class="" /> where :
- id is the id you give to the bean : it can be useful for wiring when the depending bean needs to refer to the bean it depends on.
- class is the full canonical name of the implementation class to instantiate as a bean

If the id is omitted Spring will give the bean the full qualified (canonical) class name suffixed with #0 for the 1st instance, #1, ...
Ex : com.soundsystem.SgtPeppers#0. It's better to give a more user-friendly id for the ease of referencing it later. But if you don't have to use this id avoid specifying it so that your xml, already verbose, becomes tinier.

With nothing more Spring will instantiate the bean by using its default constructor.

WIRING BEANS
------------

In order to achieve wiring by constructor injection :

<bean class="...C1">
    <constructor-arg ref="c2"/>
</bean>
<bean id="c2" class="...C2" />
where C1 has a constructor taking a C2 object as parameter

or 

<bean class="...C1" c:abcd-ref="c2"/> //where abcd is the C1 constructor C2 parameter name : class C1 { public C1(C2 abcd){...} }
<bean id="c2" class="...C2" />
In order to use c-ref attribute you need to add its namespace to the beans tag : xmlns:c="http://www.springframework.org/schema/c"
You can also use an attribute refering to the parameter position in the constructor : c:_0-ref
(! this one its not working here) If you have just one parameter you can also say : c:_-ref avoiding to give its position

INJECTING VALUES INSTEAD OF BEANS
---------------------------------

If instead of wiring beans together by constructor injection you want to pass the constructors values :

<bean class="...C1">
    <constructor-arg value="Les Misérables"/>
    <constructor-arg value="Victor Hugo"/>
</bean>

You can do the same with c: argument :
<bean class="...C1" c:title="Les Misérables" c:author="Victor Hugo"/>
or with parameter indexes
<bean class="...C1" c:_0="Les Misérables" c:_1="Victor Hugo"/>
