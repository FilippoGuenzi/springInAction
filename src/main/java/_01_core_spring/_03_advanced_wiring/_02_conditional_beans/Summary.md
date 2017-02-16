## Conditional Beans

Conditional beans make the creation of beans not dependent from a profile being active but from any condition that can be defined programmatically :
* library available in the classpath
* other bean previously created
* specific environment variable set
* ...

To achieve that, you prefix your @Bean method with an ```@Conditional``` annotation, specifying the condition as an argument class
that must implement ```@Condition```.
If the condition evaluates to true the bean is created.

From the passed ```ConditionContext``` you can for example :
* check for bean definitions :
    * ```conditionContext.getRegistry().containsBeanDefinition("")```;
    * ```conditionContext.getBeanFactory().containsBean(""```) / ```containsBeanDefinition("")```;
* dig into bean properties : ```conditionContext.getBeanFactory().getBeanDefinition("")```;
* look for environment properties : ```conditionContext.getEnvironment().containsProperty("")```;
* inspect content of resources loaded via the ResourceLoader : ```conditionContext.getResourceLoader().getResource("")```
* load or check for the presence of classes via : ```conditionContext.getClassLoader()```

From the passed ```AnnotatedTypeMetadata``` you can inspect annotations placed on the @Bean annotated method.
