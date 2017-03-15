# Controllers

## Definition

See 2.5.1.2.1 to understand their role.
A controller is a class annotated with @Controller. This annotation has nothing special. It would work the same with @Component but its more semantically explicit.
A controller has methods that return the model from the business and the view towards it's sent to. Here we don't have yet a business treatment so we just return the view name.

You can :

- Pass as an argument the map/Model where the model coming from the business logic will be stored and return the view name that will render it.
    * pass as an argument :
        * org.springframework.ui.Model which is an object similar to a Map (when no key is provided its inferred from the type passed as value : List<Spittle> --> spittleList)
        * the model as a Map
    * return : a string (view name)

```
                @RequestMapping(method=RequestMethod.GET)
                public String spittles(Model model) {
                    model.addAttribute(spittleRepository.findSpittles(Long.MAX_VALUE, 20));
                    return "spittles";
                }
```

Or :

```
                @RequestMapping(method=RequestMethod.GET)
                public String spittles(Map model) {
                    model.put("spittleList",spittleRepository.findSpittles(Long.MAX_VALUE, 20));
                    return "spittles";
                }
```

- Not pass as an argument anything (a model will be created anyway with the key inferred from model data type) and return the model (the view name will be inferred from the url).

```
                @RequestMapping(method=RequestMethod.GET)
                public List<Spittle> spittles() {
                    return spittleRepository.findSpittles(Long.MAX_VALUE, 20));
                }
```

The request url will be treated like this :
```hostname/appName[/servletMapping][/controllerRequestMapping][/methodRequestMapping]```

* appName : can be specified in many places
    * specified in pom <build><finalName>...</finalName</build>.
    * specified in <plugin><configuration><path>...</path> of <artifactId>tomcat7-maven-plugin</artifactId> (best solution when using tomcat7 plugin to run the app)
    * In Spring Boot it is specified as server: context-path: /...

* ServletMapping : specified in our AbstractAnnotationConfigDispatcherServletInitializer. It might be of different nature. See http://stackoverflow.com/questions/15385596/servlet-mapping-web-xml.
    ServletMapping is less and less used. Before we had a Tomcat with a Servlet container containing many servlet, each one having to respond to a specific url pattern.
    The tendency for big projects is to have a dedicated server containing a single app. With war artifacts, Tomcat is starting the war.
    In Spring boot we use jar and the app contains and starts the dedicated Tomcat/Jetty.

We see that in the controller we can have the @RequestMapping annotation at 2 levels :

* class level
* method level
Each one specifies which portion of the request url the annotated element will be reactive to.
It's wise to specify the HTTP method in the method annotation. Because you can have several methods in the same class with different HTTP methods.

## Testing your controllers

You can test them manually or with JUnit

### Test it manually by building the application.

Add this to your pom build plugins:
```
        <plugin>
            <groupId>org.apache.maven.plugins</groupId>
            <artifactId>maven-war-plugin</artifactId>
            <version>3.0.0</version>
        </plugin>
```

### Test it with JUnit :

Test that the right view is returned :

```
            @Test
            public void homeTest() throws Exception {

                HomeController homeController = new HomeController(); //instatiate the controller you want to test
                MockMvc mockMvc = MockMvcBuilders
                                    .standaloneSetup(homeController)
                                    .build(); //create a MockMvc instance for your controller that will allow you to send requests to it and check returned values
                mockMvc
                    .perform(MockMvcRequestBuilders.get("/homepage/jaja")) // here we perform a GET request to localhost/jojo/homepage/jaja
                    .andExpect(MockMvcResultMatchers.view().name("home")); // and we expect the "home" view to be returned
            }
```

Also test the model returned

```
            @Test
            public void shouldShowRecentSpittles() throws Exception {
                List<Spittle> expectedSpittles = createSpittleList(20);
                SpittleRepository mockRepository = mock(SpittleRepository.class);
                when(mockRepository.findSpittles(Long.MAX_VALUE, 20)).thenReturn(expectedSpittles);
        
                SpittleController controller = new SpittleController(mockRepository);
                MockMvc mockMvc = standaloneSetup(controller)
                                    .setSingleView(new InternalResourceView("/WEB-INF/views/_02/_05/_02/_03/spittles.jsp")) // default view resolution would fail because request path equals the view path. So we resolve the view here.
                                    .build(); //create a MockMvc instance for your controller that will allow you to send requests to it and check returned values
    
                mockMvc
                    .perform(get("/spittles"))  // here we perform a GET request to localhost/jojo/spittles
                    .andExpect(view().name("spittles")) // and we expect the "spittles" view to be returned
                    .andExpect(model().attributeExists("spittleList")) // and the model to contain a pair whose key is spittleList
                    .andExpect(model().attribute("spittleList", hasItems(expectedSpittles.toArray()))); // and whose value is expectedSpittles
    
            }
```

Spring needs one single entry point for web app configuration.
You then cannot have 2 classes that both :

* extend AbstractAnnotationConfigDispatcherServletInitializer
* have controllers associated to their ServletConfig

Check if by changing the ServletMapping something changes. --> no

What if you change only the RequestMapping ? --> the problem still exists

In order to make my examples work :
 
* whether I exclude classes from the build
* or I comment extend AbstractAnnotationConfigDispatcherServletInitializer on the examples I am not using
