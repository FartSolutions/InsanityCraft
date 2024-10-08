# How to style
- [Naming conventions](#naming-conventions)
    - [Types and classes](#types-and-classes)
    - [Methods](#methods)
    - [Variables](#variables)
- [Code style](#code-style)
    - [Indentations](#indentations)
    - [Brackets](#brackets)
    - [Spaces](#spaces)
    - [Comments](#comments)

## Foreword
A graphic that briefly and concisely describes the difference between the used naming conventions.
![Camel-/Snake-/Pascal-Case](https://khalilstemmler.com/img/blog/camel-snake-pascal-case/camel-case-snake-case-pascal-case.png)

## Naming conventions
### Types and Classes
Classes and interfaces are written in Pascal-Case.
```java
public class CustomClass { };
public interface ICustomInterface { };
```

### Methods
Methods are written in Camel-Case.
```java
public class ExampleClass
{
    void processData() { }
}
```

### Variables
Variables are written in Camel-Case and static variable are written in Upper-Case splitted with underscores.
```java
public class ExampleClass
{
    public String exampleName;
    private String exampleSecret;
    public static String EXAMPE_NAME;
}
```

## Code style
### Indentations
Indentations are always with 4 spaces per tab.

### Brackets
Opening brackets are on the same line as the control structure or declaration, unless it is a class or method definition.
```java
public class ExampleClass
{
    public void doSomething()
    {
        if (condition) {
            return;
        }
        while (true) {
            break;
        }
    }
}
```

### Spaces
Spaces always follow commas and keywords such as `if`, `for`, `while` and so on.

### Comments
Documentation comments are written in Doxygen style.
```java
public class ExmpleClass
{
    /**
     * Here the function or method is explained in basic terms and, if necessary,
     * how to use it and what needs to be observed.
     *
     * @param param Description of the parameter.
     * @return Description of the return value.
     * @see int
     * @throws InvalidException If an exception occurred.
     * @since v1.0.0
     */
    int exampleMethod(ExampleType param);
}
```

&uarr; [Back to top](#top)
