Import Java Config into Java config
-----------------------------------
```
@Configuration
@Import(ConfigurationClass.class)
...
```

Import XML config into Java Config
----------------------------------
```
@Configuration
@ImportResource("...config.xml")
...
```

Import XML config into XML config
---------------------------------
```
<import resource="...config.xml"/>
```
Import Java config into XML config
----------------------------------
```
<bean class="...Config"/>
<context:annotation-config/> with all what is required in the beans element
```
