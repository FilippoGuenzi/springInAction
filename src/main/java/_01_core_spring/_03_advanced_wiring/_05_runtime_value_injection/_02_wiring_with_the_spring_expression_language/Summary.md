Spring Expression Language SpEL
-------------------------------

During injection you can use SpEL.
SpEL is encapsulated in #{...} like placeholders are in ${...}

T(...) converts a given Class name or canonical name into the class itself so that you can invoke its methods.
T(System).currentTimeMillis()
T(java.lang.System).currentTimeMillis()

You can refer to instanciated beans and their properties directly with their names even if they are not injected in the reading bean.
#{steelWheels.artist}

You can also access properties in properties files with #{systemProperties['vin.cepage']} //ne fonctionne pas pour le moment chez moi !!!!!!!!!!!!!!!!!!!!!!!!!
