To do list:

1. It's not clear to me what the instance variables myNumberOfDice, myNumberOfRolls, and myNumberOfSide actually do. I'm not touching them in the getResults method. Need to take a closer look. 

From the assignment page 2: "This behavior should build and return a String that includes the sum of each of the numbers. The behavior does not need to receive any information since it has access to the instance variables that describe the last simulation and the results. If this method is called before a simulation has been run, return an empty String." 

This doesn't make sense when pitted against page 3 of the assignment: "What if someone calls this method before running a simulation? The results array will be null and the clone operation will fail. So, we need to guard against this case. If this method is called before running a simulation, return null."

2. Need to right-align output numbers for second column with printf.

3. Research array.toString method instead of how stringbuilder is used??