public class DiceFactory {

	// Declare instance variables to store the rolls, sides, and number of dice from
	// the last simulation.
	// We need some of this info for the getResults method and might need all of it
	// for future methods.
    private int myNumberOfDice, myNumberOfRolls, myNumberOfSides;
    
    //TODO: Declare an appropriate collection variable to store the totals.
	

	/**
	 * The rollDice method simulates rolling numberOfDice with numberOfSides the numberOfRolls times.
	 * The method doesn't return anything.
	 * @param int numberOfRolls - the number of times the dice are to be rolled.
	 * @param int numberOfSides - the number of sides for each die.
	 * @param int numberOfDice - the number of dice to be rolled.
	 */

	//TODO: Write the rollDice method as described in the above comment. Save the results in the array declared above.
    //			Call getResults at the end and return the results.

    
    
	/**
	 * The getResults method builds a String showing the results of the last simulation.
	 * @return - the String containing the results of the simulation.
	 */

	//TODO: Write the getResults method as described in the above comment.
	//      The method does not need parameters.
	//      If the array is null, which means getResults was called before rollDice, 
	// 		  then return an empty String.

	
	/**
	 * Return an int array with the results of the last simulation.
	 * @return int array with the results of the last simulation.
	 */
	
	// TODO: If the results array is null, then return null.  Otherwise, return a clone of the results array.

}

