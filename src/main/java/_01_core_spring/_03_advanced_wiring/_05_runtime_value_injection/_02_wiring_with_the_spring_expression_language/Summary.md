Spring Expression Language SpEL
-------------------------------

SpEL is encapsulated in #{...} like placeholders are in ${...}

T(...) converts a given Class name or canonical name into the class itself so that you can invoke its methods.
T(System).currentTimeMillis()
T(java.lang.System).currentTimeMillis()

You can refer to beans and their properties directly with their names :
#{steelWheels.artist}

