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
   
	public void rollDice(int numberOfRolls, int numberOfSides, int numberOfDice){

		myNumberOfRolls = numberOfRolls; //Set instance variables to what's passed in for the "last" simulation.
		myNumberOfSides = numberOfSides;
		myNumberOfDice = numberOfDice;

		arr = new int[((numberOfSides) * numberOfDice) - numberOfDice + 1]; //The array's size needs to account for not being able to roll 0s. 
		//If 0 can be rolled, which wouldn't make sense, this is not correct. Note: this was the AI part of the assignment. I figured it out on my
		//own, but then used Gemini to verify I had the logic correct if using more than two dice by asking it to show me a distribution with
		//different numbers of die.

		int sum = 0; //Initialize before nested loop starts.
		int thisRoll = 0;
		
			for (int i = 0; i < numberOfRolls; i++){  //Outer loop handles each trial.

				for (int j = 0; j < numberOfDice; j++){ //Inner loop rolls each dice individually and adds to the sum accumulator.

					//Simulate a round of rolling each dice one time, adding to the total with each throw.

					thisRoll = rgen.nextInt(numberOfSides) + 1; //Need to adjust for 0 indexing.

					sum += thisRoll;

				}

				//Add the sum to the tally in appropriate array element.

				for (int k = 0; k < arr.length; ++k){

					if (k + numberOfDice == sum){ //Backing out the number of dice from the array index is needed since neither dice can roll a 0 value.

						arr[k]++; //Increment the value within array element k by 1 each time a given sum registers.

					}

				}

				sum = 0; //Reset for next loop
				thisRoll = 0;

		}

		//Call getResults at the end and return the results.
		
		System.out.print("\n");
		System.out.print(getResults());

	}

	/**
	 * The getResults method builds a String showing the results of the last simulation.
	 * @return - the String containing the results of the simulation.
	 */

	public String getResults(){

		String strVal = "";
		StringBuilder sb = new StringBuilder(strVal);

		if (arr == null){ //If array is null, don't even bother to try to clone it. Just return an empty string so an exception isn't thrown.

			return strVal;

		}

		for (int i = 0; i < arr.length; i++){

			String left;
			String middle;
			String right;


			left = String.format("%3d", (i + myNumberOfDice)); //Need to add the myNumberOfDice instance variable to i to retrieve the correct sum given indexing.
			middle = ")";
			right = String.format("%6d\n", arr[i]);

			sb.append(left);
			sb.append(middle);
			sb.append(right);

		}

		strVal = sb.toString();

		return strVal;

	}


	/**
	 * Return an int array with the results of the last simulation.
	 * @return int array with the results of the last simulation.
	 */
	
	//If the results array is null, then return null.  Otherwise, return a clone of the results array.

    
	public int[] getLastSimulation(){

		if (myNumberOfRolls == 0){ //No rolls have taken place since the instance myNumberOfRolls variable hasn't been set to anything other than 0.

			return null;

		}

		int lastSimArray[] = arr.clone();

		return lastSimArray;

	}

}

