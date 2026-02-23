import java.util.Random;

public class DiceFactory {

	Random rgen = new Random();

	// Declare instance variables to store the rolls, sides, and number of dice from
	// the last simulation.

	// We need some of this info for the getResults method and might need all of it
	// for future methods.
    private int myNumberOfDice, myNumberOfRolls, myNumberOfSides;
    
    //Declare an appropriate collection variable to store the totals.

	private int[] arr;

	/**
	 * The rollDice method simulates rolling numberOfDice with numberOfSides the numberOfRolls times.
	 * The method doesn't return anything.
	 * @param int numberOfRolls - the number of times the dice are to be rolled.
	 * @param int numberOfSides - the number of sides for each die.
	 * @param int numberOfDice - the number of dice to be rolled.
	 */

	//TODO: Write the rollDice method as described in the above comment. Save the results in the array declared above.
   

	public void rollDice(int numberOfRolls, int numberOfSides, int numberOfDice){

		arr = new int[numberOfSides * numberOfDice];

		int sum = 0; //Initialize before nested loop starts.
		int thisRoll = 0;

		System.out.println("Roll dice method Rolls: " + numberOfRolls +  " Sides: " + numberOfSides + " Dice: " + numberOfDice + "\n");
		
			for (int i = 0; i < numberOfRolls; i++){ //FIXME: Need to check on indexing...

				System.out.println("Round " + (i + 1) + ":");

				for (int j = 0; j < numberOfDice; j++){

					//Simulate a round of rolling each dice one time, adding to the total with each throw.

					thisRoll = rgen.nextInt(numberOfSides) + 1; //Need to adjust for 0 indexing.

					System.out.println("Current Roll " + (j + 1) + ": " + thisRoll); //Here for debugging.

					sum += thisRoll;

					System.out.println("Current Sum " + (j + 1) + ": " + sum); //Here for debugging.

				}

				//Add the sum to the tally in appropriate array element.


				for (int k = 0; k < arr.length; ++k){

					if (k + 1 == sum){

						arr[k]++;

					}

				}

				sum = 0; //Reset for next loop
				thisRoll = 0;
				System.out.print("\n\n");

				



		}

		
		//Print array Contents.

		for (int i = 0; i < arr.length; ++i){

			System.out.println((i + 1)  + "\t " + arr[i]);

		}


		//Call getResults at the end and return the results.


	}

     
    
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

