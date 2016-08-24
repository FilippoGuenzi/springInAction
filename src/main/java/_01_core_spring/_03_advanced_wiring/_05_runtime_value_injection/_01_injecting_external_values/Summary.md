Here we're not injecting beans but values

1. Getting external values through the Spring environment
---------------------------------------------------------

In order to inject an object we haven't defined in one of our beans in explicit Java config we prefix it with @Autowired (that we saw only in automatic wiring).
Ex : 

    @Configuration
    @PropertySource("listing_in_01_03_05_01/prop.properties")
    public class SpringConfiguration {

        @Autowired
        Environment environment;

        @Bean
        public CompactDisc getCD() {
            String author = environment.getProperty("author");
            String title = environment.getProperty("title");
            return new SpecificCD(author, title);
        }
    }

Here another new thing is the @PropertySource which refers to the location of the properties file we want to use.
With @Autowired in front of Environment we can use it in our bean declaration methods.

Environment has these methods :
- getProperty("prop") -> propValue or null if not found
- getProperty("prop", defaultValueIfPropNotFound) -> propValue or defaultValueIfPropNotFound
- getProperty("prop", Type) -> propValue converted in Type or null if not found
- getProperty("prop", Type, defaultValueIfPropNotFound) -> propValue or defaultValueIfPropNotFound, converted in Type

- getRequiredProperty("prop") --> as getProperty() but throws an IllegalStateException if prop not found

- containsProperty("prop") to check if prop exists

- getPropertyAsClass(") to resolve a property into a class (Class<CompactDisc> cdClass = env.getPropertyAsClass("prop", CompactDisc.class)) 

Other interesting environment methods :
- String[] getActiveProfiles()
- String[] getDefaultProfiles()
- boolean acceptsProfiles(String[] profiles)

2. Resolving property placeholders
----------------------------------

XML config
----------
Your bean has a simple constructor and the injection is made in the configuration file.
1. As usual you specify the values to be injected in the constructor args : c:author="${author}" c:title="${title}"
2. In addition you add <context:property-placeholder location=""/> pointing to your properties file. You need to add what is required in the <beans> element for this context tag.

Java config
-----------
The same here. The bean is a plain POJO with no Spring writing. The injection is made in the configuration file.

    @PropertySource("listing_in_01_03_05_01_02/_02_java_config/prop.properties")
    public class SpringConfig {
    
        @Bean
        public CompactDisc getCD(@Value("${author}") String author, @Value("${title}") String title) {
            return new SpecificCD(author, title);
        }
    
        @Bean
        public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
            return new PropertySourcesPlaceholderConfigurer();
        }
    }
    
The new part here is :
- the @PropertySource pointing to your properties file
- the @Value("${propName}") in front of each @Bean method parameter
- the PropertySourcesPlaceholderConfigurer bean to enable spring to resolve the placeholders

Java Auto wiring
----------------
Here the spirit is to have the minimum in the config file (in order to have it auto). But you still have to add the :

    @Bean
    public static PropertySourcesPlaceholderConfigurer placeholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }
to resolve the property values.
And we add the @PropertySource pointing to your properties file
In the bean we just :
- add @Value("${propName}") in front of the constructor arguments
- prefix the constructor with @Autowired
