# Spring Expression Language SpEL


During injection you can use SpEL.
SpEL is encapsulated in ```#{...}``` like placeholders are in ```${...}```

## A few SpEL examples
```
T(...) converts a given Class name or canonical name into the class itself so that you can invoke its static fields and methods.
T(System).currentTimeMillis()
T(java.lang.System).currentTimeMillis()
```
You can refer to instanciated beans and their properties directly with their names even if they are not injected in the reading bean.
```
#{steelWheels.artist}
```
You can also access properties in system properties with ```#{systemProperties['vin.cepage']}``` :
```systemProperties``` are the options like ```-DmyOption=...``` in command line (VM options in IntelliJ launcher configurations)

## Expressing litteral values

You can also inject values like
 ```
    @Value("#{true}") boolean aBoolean
    @Value("#{2.1E7}") double aDouble
    @Value("#{3.1415926}") float aFloat
    @Value("Coucou") String string
```

## Referencing beans properties and methods

We can, even without injecting the referenced bean into the one referencing it do the following in an @Autowired method :
```
#{sgtPeppers}
#{sgtPeppers.artist} //provided artist as a getter
#{sgtPeppers.selectArtist()}
#{sgtPeppers.selectArtist().toUpperCase()}
#{sgtPeppers.selectArtist()?.toUpperCase()} //in order to avoid NPE toUpperCase() is invoked only if selectArtist() doesn't return null. Otherwise the overall expression returns null.
```

## Working with types in expressions

In order to call static fields and methods of Java classes you can reference a class with the T(...) operator where inside the T() you put the class canonical name.
Ex:
```
#{T(java.lang.Math).PI}
#{T(java.lang.Math).random()} 
```

## SpEL operators

```
+, -, *, /, %, ^
+ (string concatenation)
<, lt, <=, le, >, gt, >=, ge, ==, eq
and, or, not, |
a?b:c ternary
a?:b Elvis (if a != null then a else b)
matches (regular expressions)
```
Ex :
```#{2 * T(java.lang.Math).PI * circle.radius}``` where circle is a spring bean.

## Evaluating regular expressions

Ex : ```#{admin.email matches '[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.com'}``` --> evaluates to true if admin.email matches the pattern.

## Evaluating collections

For collections and Arrays you reference an item in array style ```myBean.myThings[i]```
You can keep on invoking fields and methods of the referenced item in the collection/array.
```myBean.myThings[i].surface()```
The array notation works also on Strings, retrieving the ith character : ```'a beautiful tree'[7] gives 'i'```
You can filter a collection with a condition retrieving only the items verifying the condition :
```myBean.myThings.?[surface > 50]```
You can retrieve the first item of a filtered collection :
```myBean.myThings.^[surface > 50]```
You can retrieve the last item of a filtered collection :
```myBean.myThings.$[surface > 50]```
You can project a collection to retrieve a collection of a chosen field :
```myBean.myThings.![surface] // here you get a collection of surfaces```

And you can mix those operators :
```myBean.myThings.^[surface > 50].![surface]```
