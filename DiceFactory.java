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

		myNumberOfRolls = numberOfRolls; //Set instance variables to what's passed in for the "last" simulation.
		myNumberOfSides = numberOfSides;
		myNumberOfDice = numberOfDice;

		arr = new int[((numberOfSides) * numberOfDice) - numberOfDice + 1]; //The array's size needs to account for not being able to roll 0s. 
		//If 0 can be rolled, which wouldn't make sense, this is not correct. Note: this was part of the AI assignment. I figured it out on my
		//own, but then used Gemini to verify I had the logic correct if using more than two dice.

		System.out.println("Array size: " + arr.length); //Here for debugging.

		int sum = 0; //Initialize before nested loop starts.
		int thisRoll = 0;

		System.out.println("Roll dice method Rolls: " + numberOfRolls +  " Sides: " + numberOfSides + " Dice: " + numberOfDice + "\n");
		
			for (int i = 0; i < numberOfRolls; i++){ //FIXME: Need to check on indexing...

				System.out.println("Round " + (i + 1) + ":"); //Here for debugging.

				for (int j = 0; j < numberOfDice; j++){

					//Simulate a round of rolling each dice one time, adding to the total with each throw.

					thisRoll = rgen.nextInt(numberOfSides) + 1; //Need to adjust for 0 indexing.

					System.out.println("Current Roll " + (j + 1) + ": " + thisRoll); //Here for debugging.

					sum += thisRoll;

					System.out.println("Current Sum " + (j + 1) + ": " + sum); //Here for debugging.

				}

				//Add the sum to the tally in appropriate array element.


				for (int k = 0; k < arr.length; ++k){

					if (k + numberOfDice == sum){ //Backing out the number of dice from the array index is needed since neither dice can roll a 0 value.

						arr[k]++;

					}

				}

				sum = 0; //Reset for next loop
				thisRoll = 0;
				System.out.print("\n\n");


		}

		
		//Print array Contents.

		for (int i = 0; i < arr.length; ++i){

			System.out.println((i + numberOfDice)  + ")\t " + arr[i]); //Adding numberOfDice makes it so my output is numberOfDice - 1 since it's 0 indexed.

		}


		//Call getResults at the end and return the results.
		getResults();

	}

     

	//TODO: Write the getResults method as described in the above comment.
	//      The method does not need parameters.
	//      If the array is null, which means getResults was called before rollDice, 
	// 		  then return an empty String.

	
	/**
	 * Return an int array with the results of the last simulation.
	 * @return int array with the results of the last simulation.
	 */
	
	// TODO: If the results array is null, then return null.  Otherwise, return a clone of the results array.

    
	/**
	 * The getResults method builds a String showing the results of the last simulation.
	 * @return - the String containing the results of the simulation.
	 */

	public String getResults(){

		String strVal = "";
		StringBuilder sb = new StringBuilder(strVal);

		if (arr == null){ //If array is null, don't even bother to try to clone it. Just return an empty string so an exception isn't thrown.

			return "";

		}

		int lastSim [] = arr.clone();


		sb.append("[");

		for (int i = 0; i < lastSim.length - 1; i++){ //Need to -1 to treat the last one separately to exclude the pesky comma.

			sb.append(lastSim[i]);
			sb.append(", ");
		}

		sb.append(lastSim[lastSim.length -1]); //Handle the last entry in the array.
		sb.append("]");
	
		strVal = sb.toString();

		return strVal;

	}

}

