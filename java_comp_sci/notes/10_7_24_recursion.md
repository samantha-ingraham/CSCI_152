**recursion**
    *def* when afunction calls itself

errors:
    Stack overflow: runtime error **need to be able to predict when and why this will happen** occurs when your function overflows the stack limits

**base case**: a case where there is only one output and it is known, and where the recursive process halts. kicks off the dominoes.
*can still have stack overflow if you feed in a number below or above the threshold the base case gives us, depending on whether the function subtracts(below) or adds(above) to make a step



**tail recursion**:call to the function is at the END on the function. preferred method, easier to predict. takes up less stack space and is usually less complex.

**non-tail recursion**: call to function is anywhere but the end. can be harder to predict what the output will be. things after the function call happen in the opposite direction that the recursive part of the function was executed. takes up more stack spave and is usually more complex. *sometimes a super power*

see slides for examples week 6




