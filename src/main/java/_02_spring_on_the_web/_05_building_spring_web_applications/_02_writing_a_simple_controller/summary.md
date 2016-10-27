It seems that you cannot have 2 classes that both :
- extend AbstractAnnotationConfigDispatcherServletInitializer
- have controllers associated to their ServletConfig

Check if by changing the ServletMapping something changes. What if you change only the RequestMapping ?
