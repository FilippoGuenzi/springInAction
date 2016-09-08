Refer to illustrations on :
- DispatcherServlet, and MVC
- how DispatcherServlet relates to AbstractAnnotationConfigDispatcherServletInitializer

When DispatcherServlet starts up, it creates a Spring application context and starts loading it with beans declared in the configuration files or classes that it’s given. 
With the getServletConfigClasses() method in MyAppInitializer, you’ve asked that DispatcherServlet load its application context with beans defined in 
the WebConfig configuration class (using Java configuration).

In other words, DispatcherServlet will create a Spring application context and loads it with beans declared in the configuration classes returned by getServletConfigClasses.

AbstractAnnotationConfigDispatcherServletInitializer creates both :
- DispatcherServlet (responsible for creating the Spring context containing Handler Mappings, Controllers, View resolvers, Views)
- ContextLoaderListener (responsible for creating the Spring context that will hosts business beans)
