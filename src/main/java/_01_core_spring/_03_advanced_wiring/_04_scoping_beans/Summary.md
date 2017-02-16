# Scope of beans

The lifetime of a bean depends on its scope.
The default scope is __singleton__.
Here are all possible scopes :
* __Singleton__ : one only instance of the bean is created for the whole application.
  Each time the bean is injected in the application, it's always the same instance being injected.
* __Prototype__ : a new instance is created at each injection.
  We could say that each instance is a 'singleton' shared across users.
* __Request__ : in a web application, the same instance is kept at each injection for the lifetime of the request
  We could say that each request instance is a 'singleton' shared across points of injection.  
* __Session__ : in a web application, the same instance is kept at each injection for the lifetime of the session
  We could say that each session instance is a 'singleton' shared across points of injection.

Singleton and prototype scoped beans get created as soon as the application context is created.
Requests and sessions scoped beans get created with the requests and sessions. 

To change the scope of a bean you put ```@Scope(...)``` :
* whether on the bean definition in component scanning
* or on the bean declaration in java config
```
@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON) || @Scope(value=ConfigurableBeanFactory.SCOPE_SINGLETON)
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@Scope(WebApplicationContext.SCOPE_REQUEST)
@Scope(WebApplicationContext.SCOPE_SESSION)
```
In XML the bean element has a ```scope``` attribute that you can set to singleton, ...

Here we have 2 independent dimensions : space and users.
A problem might arise when injecting into one another beans of different scopes.
```
|Scope           |  sharable through space  |   sharable among users   |
|----------------|--------------------------|--------------------------|
|Singleton       |            Y             |             Y            |
|Prototype       |            N             |             Y            |
|Request         |            Y             |             N            |
|Session         |            Y             |             N            |
```

By nature there can be many requests/ sessions at the same time to be injected into another bean instance.

For example we might need to inject a Request Bean into a Singleton Bean.

There are as many Request beans to be injected into the Singleton bean than there are request.
* Which one do we inject ?
* How do we wait for the bean to be injected when the host bean is created ?

By nature there's just one singleton instance and one prototype instance per point of injection
and each one can be shared among users.

So there's no ambiguity here on which one to choose. And we don't have to wait.

```
   To be injected   |   Host of injection   |   Nature of the problem
--------------------|-----------------------|------------------------------------------------------------
Singleton           | Any scope             |   It's not a problem to inject a singleton in any other scope
                    |                       |   since there's no ambiguity in which instance injecting :
                    |                       |   there's just one instance.
====================|=======================|============================================================
Prototype           | Singleton             |   Not a problem : by definition an instance is created at each
                    |                       |   point of injection.
--------------------|-----------------------|------------------------------------------------------------
Prototype           | Request               |   Not a problem : an instance is created at each point of
                    |                       |   injection and is shared among requests
--------------------|-----------------------|------------------------------------------------------------
Prototype           | Session               |   Not a problem : an instance is created at each point of
                    |                       |   injection and is shared among sessions
====================|=======================|============================================================
Request             | Singleton             |   The instance of which request do we inject into the singleton ?
--------------------|-----------------------|------------------------------------------------------------
Request             | Prototype             |   The instance of which request do we inject into the prototype ?
--------------------|-----------------------|------------------------------------------------------------
Request             | Session               |   The instance of which request do we inject into the session ?
                    |                       |   Usually one request follows another in a session
                    |                       |   But nothing stops to open many tabs in your browser and to run
                    |                       |   many concurrent requests in the same session
====================|=======================|============================================================
Session             | Singleton             |   The instance of which session do we inject into the singleton ?
--------------------|-----------------------|------------------------------------------------------------
Session             | Prototype             |   The instance of which session do we inject into the prototype ?
--------------------|-----------------------|------------------------------------------------------------
Session             | Request               |   No problem here : there's just one session for a given request.
```

When there's a problem of ambiguity and non existence (at initialization the singleton pre-exists
to any request scoped beans that might be injected in it) Spring will inject a proxy
that will expose the injected bean methods and will be able to route them to the appropriate bean instance.

We say that the injected beans are injected as scoped proxies.

The bean definition/declaration must be annotated with ```@Scope(proxyMode = ScopedProxyMode.INTERFACES)```
or ```@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)```

In XML the ```<bean/>``` element must host an ```<aop:scoped-proxy/>``` element
which says that the bean is injected as a scoped proxy.

In order to do that you must include the aop namespace in the beans element.

By default the proxy mode is ```TARGET_CLASS```. If you want to set ```INTERFACES``` :
```<aop:scoped-proxy proxy-target-class=false/>```
