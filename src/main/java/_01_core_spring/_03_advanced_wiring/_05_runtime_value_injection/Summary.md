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

Still with the @PropertySource set, you can use "${prop}" to retrieve the prop property
