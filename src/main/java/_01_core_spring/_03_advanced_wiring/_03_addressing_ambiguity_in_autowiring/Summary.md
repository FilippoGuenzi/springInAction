# Addressing ambiguity in Autowiring

When there are many candidates of the same type for autowiring there's ambiguity.
Spring will raise a :

```NoUniqueBeanDefinitionException``` (No qualifying bean of type [] is defined: expected single matching bean but found n : ..., ..., ...).

In order to solve this Spring offers different solutions :

## Primary bean

You can add a ```@Primary```, whether on the bean definition in component-scanning, or on the bean declaration in the configuration file in Java explicit config.

You cannot put it on the Bean definition in explicit Java config. (Always the same intent to keep Beans as plain Pojo and to make only Spring know for its configuration)

In Xml explicit config I don't see the point of having a primary bean since there cannot be ambiguity since the ```<constructor-arg>``` and ```<property>``` tags require an explicit ref,
i.e. force to choose a bean : you cannot refer to a bean by its super-type, you can only refer to a bean by its id.

When you loose your sight on all your beans and end up designating two of the same type as ```@Primary``` Spring will raise a ```NoUniqueBeanDefinitionException```.

## Qualifiers

Every bean receive a default qualifier being its class name in camelCase in component-scanning config.
You can rely on this qualifier to designate your bean at the injection point with ```@Qualifier("iceCream")``` supposing your bean class is IceCream.
Or you can explicitly give your qualifier a name to decouple from the class name and avoid risks occurring with refactoring.
Having to choose a name for your qualifier it is advised to choose a qualifying name for your bean. Cookies being crispy you could say crispy for example.

You can qualify your bean :
 - whether on the bean definition
 - or on the bean declaration in explicit Java config.

 (to test ...)

Ambiguity come back when at least two of your beans to be injected have the same qualifier.
A solution would be to add more ```@Qualifier("...")``` annotations to distinguish them,
qualifying each bean with more traits and confiding that by describing in greater details your beans you'll have unique traits.
Java doesn't allow you to have several times the same annotation (unless it is itself annotated with ```@Repeatable```, which isn't the case here). We have to create our own.
```
@Target({ElementType.CONSTRUCTOR, ElementType.FIELD, ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Qualifier
public @interface Cold { }
```
In my opinion, since the qualifier can be written on the bean definition or on the bean declaration in Java config,
plus on the method to be @Autowired, ElementType shouldn't be different from ElementType.METHOD, ElementType.TYPE. 
In fact they're not required by Spring for qualifiers to work.

Though I don't see any case where we would select beans by their treats instead of choosing them directly. 
It might be useful if you think at technical traits : here I need a Collection implementation which is @Ordered and @AllowsDuplicates for example. 
