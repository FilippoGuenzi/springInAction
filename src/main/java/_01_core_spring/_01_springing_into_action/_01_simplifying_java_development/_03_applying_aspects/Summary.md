Some cross-concerns/system-wide functionalities, as logging, security, transaction management can be invoked in many components.
The business components, which have their own functionality, are scattered with lines of different functionality.
To group the system-wide logic into one single place (more reusable if you change the logic) and to let the business components as plain POJOs
we use AOP.
