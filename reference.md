

=> Java Envi : JDK + JRE
=> HelloWord App


--------------------------------------------------------------------
1. Java Project structure
--------------------------------------------------------------------

proj

    |
    |---- package1
    |
    |
    |---- package2
    |   |
    |   |---- package21


--------------------------------------------------------------------
2. java file structure
--------------------------------------------------------------------

PublicType.java
----------------------------------
| package declaration ( 1 )  ( optional but recommended )
| import statements ( n ) ( optional )
| public type declaration  ( interface, class, enum, annotation) ( 1 ) ( must )
| type declaration ( interface, class, enum, annotation) ( n ) ( optional )
|
----------------------------------


--------------------------------------------------------------------
3. package declaration
--------------------------------------------------------------------

why package ?
    => to organize the classes
    => to avoid name conflicts
    => to provide controlled access

syntax:

package com.abc.xyz;

recommended package naming conventions:
    
    => domain name  + project name + module name + sub module name

    eg: com.edforce.testing.playwright;


--------------------------------------------------------------------
4. import statements
--------------------------------------------------------------------

why import ?
    => to use classes from other packages
    => to avoid fully qualified names

e.g

proj
| 
|--p1 ( A.class , B.class )
|
|--p2 ( C.class , D.class )
|


e.g A.java

package p1;
import p2.C;
import p2.D;
// or
import p2.*;
public class A{
 B b;
 C c;
 D d;
}


--------------------------------------------------------------------
types 
--------------------------------------------------------------------

type aka datatype

in java, we have 4 user defined types

1. class
2. interface
3. enum
4. annotation
5. record ( java 14 ) => to create immutable objects with less code

why user defined types ?
    => to represent data
    => to represent behavior
    => to represent data + behavior

important note: java is object oriented language

what is object ?

- data/attributes/properites/fields  => state
- functions/methods/operations => behavior
- address/reference => identity

obj => data + behavior + identity ( sbi )

to create similar objects, we need a blueprint aka class


Object's concepts

- Interface / Abstraction
    why we need ?
    -> to expose essential behavior / operations to the outside world
- Implementation / Encapsulation
    why we need ?
    -> to hide the implementation details
- Inheritance
    why we need ?
    -> to reuse the existing code from generalization to specialization
- Polymorphism
    why we need ?
    -> to perform a single operation in different ways

--------------------------------------------------------------------
5. class syntax
--------------------------------------------------------------------

 ________   __________ class Name [extends] GenelizedType  {
 [public]   [abstract]            [implements] Interface1, Interface2, ... {
 [      ]   [final]      
            [strictfp]  // fields / variables
                        // constructors 
                        // methods
                        // inner types

 }       


-> abstract => to restrict the object creation
-> final => to restrict the inheritance
-> strictfp => to restrict the floating point calculations

-> extends => to inherit the properties and methods from the parent class
-> implements => to implement the interfaces

-> public => to make the class accessible from outside the package
-> default => to make the class accessible within the package

-> fields => data/attributes/properties
-> constructors => to initialize the object
-> methods => functions/operations
-> inner types => class inside the class

--------------------------------------------------------------------
6. interface syntax
--------------------------------------------------------------------

_____    interface Name [extends] Interface1, Interface2, ... {
[public]    // constants
[      ]    // abstract methods
            // default methods
            // static methods
        }

-> interface => to define the contract
-> extends => to inherit the properties and methods from the parent interfaces

-> constants => public static final
-> abstract methods => public abstract
-> default methods => public default
-> static methods => public static

important note: interface is 100% abstract class, we can't create an object for the interface

a class can implement multiple interfaces

--------------------------------------------------------------------
7. enum syntax
--------------------------------------------------------------------

why enum ?
    => to represent a group of constants

e.g days of the week, months of the year

________    enum Name {
[public]    // constants
            // methods
        }

--------------------------------------------------------------------
8. annotation / decorator syntax
--------------------------------------------------------------------

why annotation ?

    => to provide metadata about the program elements ( classes, methods, fields, etc ) to the compiler, JVM, or other tools ( e,g TestRunner )

________ @interface Name {
[public]    // constants
            // methods
        }

--------------------------------------------------------------------
9. variables
--------------------------------------------------------------------

why variables ?

    => to store the data

types of variables based on type of data

    1. value / primitive  variables ( byte, short, int, long, float, double, char, boolean)
    2. object / reference  variables ( class, interface, enum, annotation )

class Employee{
    final static String COMPANY_NAME="ABC";  // class variable
    static String tnrName;  // class variable
    int id;  // instance variable
    String name; // instance variable

    void work(){ // method
        int hours=8; // local variable
    }
}

Employee.COMPANY_NAME="XYZ"; // error
Employee.tnrName="Nag";
Employee.tnrName="Ria";

syntax:
___________  _________  datatype variableName [= value / object's reference];
[public]     [static]  
[protected]  [final]
[private]    
[       ]   

--- local variables---

Nil         [final]

--------------------------------------------------------------------
10. constructors
--------------------------------------------------------------------

how to create object ?

2 steps
step 1: memory allocation ( new )
step 2: initialization ( constructor )

obj = new Class();

why constructor ?

    => to initialize the object

syntax:

_________  ClassName([parameters]){
[public]
[protected]    // initialization code
[private]
[       ]
            }    



--------------------------------------------------------------------
11. methods
--------------------------------------------------------------------

why methods ?

    => to represent behavior

return-type : void / primitive / object's reference

2 types of methods
    - class methods
    - instance methods

syntax:

___________ _____________ return-type methodName([parameters]){
[public]    [static]       // ALR & assignment statements
[protected] [abstract]     // conditionals
[private]   [synchronized] // loops
[   ]       [natiive]      // method calls
            [strictfp]     // assertions

                          [return] [value / object's reference];

}

--------------------------------------------------------------------
Naming conventions
--------------------------------------------------------------------

package name : all lowercase
type name : PascalCase ( first letter of each word should be uppercase )
variables/methods : camelCase ( first letter of first word should be lowercase and first letter of each subsequent word should be uppercase )
constants : all uppercase with underscore

--------------------------------------------------------------------


