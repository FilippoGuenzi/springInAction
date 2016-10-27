Controllers
-----------
See 2.5.1.2.1 to understand their role.
A controller is a class annotated with @Controller. This annotation has nothing special. It would work the same with @Component but its more semantically explicit.
A controller has methods that return the model from the business and the view towards it's sent to. Here we don't have yet a business treatment so we just return the view name.
You can :

- return :
    - a string (view name)
    - an object (the view name will be inferred from the url) (the model key is inferred from its type)
- pass as an argument :
    - nothing
    - the model as a Map
    - the model as an object similar to a Map


The request url will be treated like this :
hostname/appNameSpecifiedInPomBuildFinalName[/servletMappingSpecifiedInOurConfigDispatcherServletInitializer][/controllerRequestMapping][/methodRequestMapping]
We see that in the controller we can have the @RequestMapping annotation at 2 levels :

- class level
- method level
Each one specifies which portion of the request url will the annotated element will be reactive to.
It's wise to specify the HTTP method in the method annotation. Because you can have several methods in the same class with different HTTP methods.

In order to test your controller you can whether :

- test it manually by building the application. Add this to your pom build plugins:

        <plugin>
            <groupId>org.apache.maven.plugins</groupId>
            <artifactId>maven-war-plugin</artifactId>
            <version>3.0.0</version>
        </plugin>

- test it with JUnit like this :

        @Test
        public void homeTest() throws Exception {
        
            HomeController homeController = new HomeController(); //instatiate the controller you want to test 
            MockMvc mockMvc = MockMvcBuilders.standaloneSetup(homeController).build(); //create a MockMvc instance for your controller that will allow you to send requests to it and check returned values 
            mockMvc
                    .perform(MockMvcRequestBuilders.get("/homepage/jaja"))
                    .andExpect(MockMvcResultMatchers.view().name("home"));
        }

Spring needs one single entry point for web app configuration.
You then cannot have 2 classes that both :

- extend AbstractAnnotationConfigDispatcherServletInitializer
- have controllers associated to their ServletConfig

Check if by changing the ServletMapping something changes. --> no
What if you change only the RequestMapping ? --> problem doesn't change
