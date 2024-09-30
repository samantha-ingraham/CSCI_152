**Pass by Value**
    def: method parameter values are copied to another variable, and then copied object is passed to method/you
    *will not change the copied variable, even if the og value changes
**pass by reference**
    def: a alias/reference is passed to method, and then the og value that was referenced is given to the method/you
    *will adjust to changes made to original value
    
**used more frequently in the c languages**

*in java can be difficult because you may be getting one thing (pass by value) when you want the other(reference). **will be needed in rubics cube project**

**predictable ways it happens see slide 22**
*anything over 8 bites will likely be passed by reference
*anything 8 or under will likely be passed by value
*most primitives will be passed by value bc under 8 bites or equal to it.
**except strings**
    **(not a primitive, but feels like one, technically is an array and therefore immutabable. but strings can be changed? and so instead of keeping the immutable object of the character array(string) it destroys and recreates a new one each time you reference it.)
    ** new string gets a new address but points to the same reference as the previous string, and the old string address no longer does.
    **strings are not technically passed by value but they act like they are
**garbage collector**
    *collects up anything you lose a reference too
        *such as temp variables in a loop
        *makes managing memory a lot easier
        *you can still fill your memory, but not on accident(like c languages)
    *can't predictably delete things in time, so if you need/have **exactly** 2GB of memory, java would not be the best language to use since you need more control over the available space.
    *collects shit at random

**conclusions**
    *primitives and strings-passed by value
    *objects/non-primitve-passed by reference

**creating your cube**
    *create a copy ( array.copy)
    *?? didnt hear what he said
**trivia**
    *java is technically always passed by value becayse if the object reference type
    *strings immutable-when you change them, you make a whole new ass thing in memory.
