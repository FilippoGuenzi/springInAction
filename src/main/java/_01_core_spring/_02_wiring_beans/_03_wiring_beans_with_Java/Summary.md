Although automatic wiring is preferable you can't always use it : when you need to inject beans from a third-party library you cannot annotate it with @Component.
The best alternative is to use JavaConfig (type-safe, refactor-friendly) and then to use XML config.

All beans are plain POJOs and they're not aware that they're going to be instanciated as beans in Spring context.
And they're not aware of other beans they'll be wired with.
It's the configuration file that will turn them into spring beans and will create the wiring. 

Configuration file is annotated with @Configuration
Inside you declare beans by declaring @Bean annotated methods that returns the type of your bean.
```
@Bean
public CompactDisc getSteelWheelsCD(){
    return new SteelWheels();
}
```
Spring beans have a name, which by default is the name of the method, but that could be changed with @Bean(name="...")

In order to wire beans together you provide the depending bean constructor the bean's to be injected method :
```
@Bean
public MediaPlayer getMediaPlayer(){
    return new CDPlayer(getSteelWheelsCD());
}
```
The compactDisc bean is provided by Spring upon call of getSteelWheelsCD(). A new bean is not created on every new call. If the bran already exists in the context it is provided instead. 

Alternatively instead of providing the bean to be injected with its @Bean-annotated method you can also provide the depending bean constructor with a variable of the bean to be injected type.
```
@Bean
public MediaPlayer getMediaPlayer(CompactDisc compactDisc){
    return new CDPlayer(compactDisc);
}
```
In order it to be known by the method body it has to be passed as an argument of the method.
This approach is preferred because it doesn't need the bean to be injected declaration to be in the same configuration file. It can have also been declared in XML or with component-scanning.

Again you can do the wiring with any other method than the constructor.
```
@Bean
public MediaPlayer getMediaPlayer(CompactDisc compactDisc){
    CDPlayer cdPlayer = new CDPlayer();
    cdPlayer.insertCD(compactDisc);
    return cdPlayer;
}
```
The body of such bean declaration methods have no limits. The important part is that an object of the right type is returned. 

