In a Spring application objects live in a Spring container. 2 types of Spring containers (both ensure DI) :
* Bean factories
* Application Contexts
In most case Bean factories won't be enough and we'll prefer Application contexts which offer the possibility :
* to resolve text from properties file
* and to publish app events to events listeners who subscribed.

Application contexts :
```
|          |             non web                 |                web
------------------------------------------------------------------------------------------
|   XML    | ClassPathXMLApplicationContext      | XMLWebApplicationContext
|          | FileSystemXMLApplicationContext     |
------------------------------------------------------------------------------------------
|   Java   | AnnotationConfigApplicationContext  | AnnotationConfigWebApplicationContext
```
We'll see the web ones later.
FileSystemXMLApplicationContext is like ClassPathXMLApplicationContext but you have to provide him with the config file address
in the file system, like c:/knightConfig.xml
