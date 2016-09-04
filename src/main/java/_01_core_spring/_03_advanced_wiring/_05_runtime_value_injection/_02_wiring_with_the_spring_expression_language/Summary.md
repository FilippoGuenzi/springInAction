Spring Expression Language SpEL
-------------------------------

During injection you can use SpEL.
SpEL is encapsulated in #{...} like placeholders are in ${...}

A few SpEL examples
-------------------

T(...) converts a given Class name or canonical name into the class itself so that you can invoke its static fields and methods.
T(System).currentTimeMillis()
T(java.lang.System).currentTimeMillis()

You can refer to instanciated beans and their properties directly with their names even if they are not injected in the reading bean.
#{steelWheels.artist}

You can also access properties in system properties with #{systemProperties['vin.cepage']} :
systemProperties are the options like -DmyOption=... in command line (VM options in IntelliJ launcher configurations)

Expressing litteral values
--------------------------

You can also inject values like 
    @Value("#{true}") boolean aBoolean
    @Value("#{2.1E7}") double aDouble
    @Value("#{3.1415926}") float aFloat
    @Value("Coucou") String string
    
Referencing beans properties and methods
----------------------------------------

