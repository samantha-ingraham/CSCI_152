**parsing vs catsing**
*both can be thought of converting things but in differenting ways
*manipulate the data into different types, important in strongly typed languages like java
**parsing**
    *converting a string into a data structure- converting it from characters into the actual value.
        eg: '12' can become the integer 12
**casting**
    *more specific type of parsing. 
    *converting an object of one type into another type
    *more general purpose
    *wont always evaluate correctly

**syntax**
    **parsing**
        static int parseInt (string s) *will return an int
        "Integer.parseInt("100",2)" {100 in base 2}
        "Double.parseDouble("12")"
        *overloaded function-can provide value and radix (radix tells us base 10, for example)
    **casting**
        narrowing (making value smaller memory footprint)=casting up
        widening (making value larger memory footprint)= casting down
        *casting does not try to infer anything, just mindlessly does what you tell it. casting up will just cut off at a point that is convenient, and will cause data loss if you have shit there (doesn't round, for example)
        *try to widen, not narrow.
        *if you try to cast up without taking data loss into account, you will get an error that prevents you from doing so. 
        * make sure you are balancing (in italics) the equation, you are reassuring java that you do in fact want to do this. eg "*int* my_int= *(int)* my_double"
        * long to int is the most common fuckup
        