When there are many candidates of the same type for autowiring there's ambiguity.
Spring will raise a NoUniqueBeanDefinitionException (No qualifying bean of type [] is defined: expected single matching bean but found n : ..., ..., ...).

In order to solve this Spring offers different solutions :

1. Primary bean
---------------
You can add a @Primary, whether on the bean definition in component-scanning, or on the bean declaration in the configuration file in Java explicit config.
You cannot put it on the Bean definition in explicit Java config.
In Xml explicit config I don't see the point of having a primary bean since there cannot be ambiguity since the <constructor-arg> and <property> tags require an explicit ref,
i.e. force to choose a bean : you cannot refer to a bean by its super-type, you can only refer to a bean by its id.

When you loose your sight on all your beans and end up designating two of the same type as @Primary Spring will raise a NoUniqueBeanDefinitionException.  

2. Qualifiers
-------------
Every bean receive a default qualifier being its class name in camelCase in component-scanning config.
You can rely on this qualifier to designate your bean at the injection point with @Qualifier("iceCream") supposing your bean class is IceCream.
Or you can explicitly give your qualifier a name to decouple from the class name and avoid risks occurring with refactoring.
Having to choose a name for your qualifier it is advised to choose a qualifying name for your bean. Cookies being crispy you could say crispy for example.

You can qualify your bean :
 - whether on the bean definition
 - or on the bean declaration in explicit Java config.
 (to test ...)
