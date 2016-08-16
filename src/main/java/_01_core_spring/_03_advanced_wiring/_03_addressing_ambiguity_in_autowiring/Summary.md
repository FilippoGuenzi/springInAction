When there are many candidates of the same type for autowiring there's ambiguity.
Spring will raise a NoUniqueBeanDefinitionException (No qualifying bean of type [] is defined: expected single matching bean but found n : ..., ..., ...).

