To create a new spring configuration XML file use IDE new Spring config file instead of learning it by heart. It just creates the mininum required.

<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="
       http://www.springframework.org/schema/beans
       http://www.springframework.org/schema/beans/spring-beans.xsd">
</beans>

Now you can add bean declarations in the middle.

<bean id="" class=""> where :
- id is the id you give to the bean : it can be useful for wiring when the depending bean needs to refer to the bean it depends on.
- class is the full canonical name of the implementation class to instantiate as a bean

If the id is omitted Spring will give the bean the full qualified (canonical) class name suffixed with #0 for the 1st instance, #1, ...
Ex : com.soundsystem.SgtPeppers#0. It's better to give a more user-friendly id for the ease of referencing it later.

With nothing more Spring will instantiate the bean by using its default constructor.

