Import Java Config into Java config
-----------------------------------
@Configuration
@Import(ConfigurationClass.class)
...

Import XML config into Java Config
----------------------------------
@Configuration
@ImportResource("...config.xml")
...

Import XML config into XML config
---------------------------------
<import resource="...config.xml"/>

Import Java config into XML config
----------------------------------
<bean class="...Config"/>
!!! Not working in my case.
