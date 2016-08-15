When Spring must decide which profile is active it looks for two properties :

- spring.profiles.active
- spring.profiles.default

If spring.profiles.active is specified then it is the active profile.
Otherwise Spring looks if spring.profiles.default is specified. If it is then it is the active profile.
Otherwise there's no active profile and only beans defined outside the scope of a profile declaration are created.

There are different ways to set those parameters in an application :
- from inside the artifact
    - as initialization parameters on DispatcherServlet (we'll see it in 5.1.1 on Spring MVC)
    - as context/servlet parameters of a web application (web.xml or annotation)
- from outside the artifact
    - as JNDI entries (?)
    - as environment variables (like path)
    - as JVM system properties (like -Xmx) 

For testing purposes : we choose the active profiles of the test with the @ActiveProfiles annotation

An advised method of setting profiles is to set spring.profiles.default from inside the artifact so that any developer can take it and run it.
When changing environment we set the spring.profiles.active from outside the artifact (environment variable for example)
and this property takes precedence over the other.

You can have profiles defining things completely independent the one from the other :
- database choice can be chosen in a set of profiles
- 
