Refer to illustrations on :
* DispatcherServlet, and MVC
* how DispatcherServlet relates to AbstractAnnotationConfigDispatcherServletInitializer

AbstractAnnotationConfigDispatcherServletInitializer creates both :
* DispatcherServlet (responsible for creating the Spring context containing Handler Mappings, Controllers, View resolvers, Views)
* ContextLoaderListener (responsible for creating the Spring context that will hosts business beans)

DispatcherServlet will create a Spring application context and loads it with beans declared in the configuration classes returned by getServletConfigClasses.

ServletConfig explanation :
```
    //this is the configuration file for the Application Context created by DispatcherServlet

    @Configuration
    @EnableWebMvc //to use Spring MVC, otherwise its remains a normal Spring configuration file
    @ComponentScan(basePackages = "...")
    public class ServletConfig extends WebMvcConfigurerAdapter //extends WebMvcConfigurerAdapter in order to use its configureDefaultServletHandling method    
    {
        @Bean
        //this creates a ViewResolver (cf 2.5.1.2.1) that finds a view file given a view name
        public ViewResolver viewResolver() {
            InternalResourceViewResolver resolver = new InternalResourceViewResolver();
            resolver.setPrefix("/META-INF/views");
            resolver.setSuffix(".jsp");
            resolver.setExposeContextBeansAsAttributes(true); //make all beans accessible through ${...} expressions in a JSP 2.0 page, as well as in JSTL's c:out value expressions.
            return resolver;
        }
    
        @Override
        //this method routes static resources like images to servlet container default servlet instead of DispatcherServlet so that they are treated in a more simple fashion than dynamic resources
        public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
            configurer.enable();
        }
    }
```
