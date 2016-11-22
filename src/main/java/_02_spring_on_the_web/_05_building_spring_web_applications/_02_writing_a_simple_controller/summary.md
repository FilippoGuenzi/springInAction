Controllers
-----------
See 2.5.1.2.1 to understand their role.
A controller is a class annotated with @Controller. This annotation has nothing special. It would work the same with @Component but its more semantically explicit.
A controller has methods that return the model from the business and the view towards it's sent to. Here we don't have yet a business treatment so we just return the view name.
You can :

- 1 
    - pass as an argument :
        - org.springframework.ui.Model which is an object similar to a Map (when no key is provided its inferred from the type passed as value : List<Spittle> --> spittleList)
        - the model as a Map 
    - return :
        - a string (view name)
        
                @RequestMapping(method=RequestMethod.GET)
                public String spittles(Model model) {
                    model.addAttribute(spittleRepository.findSpittles(Long.MAX_VALUE, 20));
                    return "spittles";
                }

            Or :

                @RequestMapping(method=RequestMethod.GET)
                public String spittles(Map model) {
                    model.put("spittleList",spittleRepository.findSpittles(Long.MAX_VALUE, 20));
                    return "spittles";
                }
      
- 2
    - pass as an argument :
        - nothing
    - return :
        - an object (the view name will be inferred from the url) (the model key is inferred from its type)
    
                @RequestMapping(method=RequestMethod.GET)
                public List<Spittle> spittles() {
                    return spittleRepository.findSpittles(Long.MAX_VALUE, 20));
                }

The request url will be treated like this :
hostname/appNameSpecifiedInPomBuildFinalName[/servletMappingSpecifiedInOurConfigDispatcherServletInitializer][/controllerRequestMapping][/methodRequestMapping]

ServletMapping might be of different nature. See http://stackoverflow.com/questions/15385596/servlet-mapping-web-xml

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

- test it with JUnit :

    - like this just to test that the right view is returned :

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
        
    - Or like this if you want to also test the model returned        
        
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
        

Spring needs one single entry point for web app configuration.
You then cannot have 2 classes that both :

- extend AbstractAnnotationConfigDispatcherServletInitializer
- have controllers associated to their ServletConfig

Check if by changing the ServletMapping something changes. --> no
What if you change only the RequestMapping ? --> problem doesn't change

In order to make my examples work :
 
- whether I exclude classes from the build
- or I comment extend AbstractAnnotationConfigDispatcherServletInitializer on the examples I am not using
