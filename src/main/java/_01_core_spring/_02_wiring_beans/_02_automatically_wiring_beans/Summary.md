Automatic wiring works by :

Declaring components
--------------------
* annotating bean to instanciate with @Component (or @Component("nameOfComponent"))

Telling Spring to look for them
-------------------------------
* configuring component scanning :
    * whether in XML
    ```<beans ...
    xmlns:context="http://www.springframework.org/schema/context"
    xsi:schemaLocation="...
    http://www.springframework.org/schema/context
    http://www.springframework.org/schema/context/spring-context.xsd">
        <context:component-scan base-package="package.to.scan"/>
        ```
    * or in Java by annotating the configuration class with ```@ComponentScan```. Fine grained scanning :
        * By default the automatic scanning scans in the same package than the configuration class, and its sub-packages.
        * Otherwise ```@ComponentScan("package.to.scan")``` will scan the specified package
        * Which is equivalent to ```@ComponentScan(basePackages = "package.to.scan")```
        * For multiple packages ```@ComponentScan(basePackages = {"package.to.scan", "...", ...})```
        * Better : ```@ComponentScan(basePackageClasses={Class1.class, Class2.class, ...})```

Declaring injection of a bean into another if needed
----------------------------------------------------
* wiring beans by declaring beans to be injected with ```@Autowired``` or ```@Inject```. If no bean is found for injection or if several candidates are found Spring will throw an exception.
  The ```@Autowired/@Inject``` annotation can be placed :
    * whether on a constructor taking as parameter the bean to be injected
    * or on any other method taking as parameter the bean to be injected
    * or on fields (not advised ?) provided :
        * the constructor injection is replaced by an init() injection !!! See p.21 (not in great details).
        * there's no initialization at all, whether by init or by constructor.

In order to to load a spring context for tests (independent from autowiring) :
* annotate your test class with ```@RunWith(SpringJUnit4ClassRunner.class)```
* specify the context configuration with ```@ContextConfiguration(classes = CDPlayerConfig.class)```

