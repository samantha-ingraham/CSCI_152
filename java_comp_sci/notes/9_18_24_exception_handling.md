terminology:
    when exception occurs, we say it was **thrown** or **raised**
    when being dealt with, we say it was **handled** or **caught**
    the block of code that deals with exceptions is called an **exception handle**
why use exceptions??
    sep error handling code from regular code
    code clarity
    worry about handling error in seperate space
    seperate detection/reporting/handling
    group and differentiate errors
how to use/how we will likely use
    try-catch-finally
    in try- code that might throw an exception
    in catch- (type of exception)+ what to do if it happens
    ** can protect code and help it run and tell u if u fucked up somewhere bc catch code will help **ignore** problem 
    see slide 6-10
    in finally- statement that always gets run with or without problems. 

finally can help us avoid accidentally creating malware

checked exceptions
    caught outside the runtime, prevents compiling
    checked automatically but not handled automatically 

    some will still compile/run but will throw an exception
    "cannot divide by 0"
    "index out of bounds"

    you can force the compiler to run anyway- "throws exception" will bully past any and all exceptions- maybe delete as a newbie

exception class heirarchy
    checked
        i/0 exception- it and all its children
        sql exception
    unchecked
        runtime exception
            array index out of bounds
            nullpointer exception
            illegal argument
    e is the most broad exception, checks all of them.

**most likely we will only ever use i/o exception and exception**
**be as specific as possible**