import java.util.Arrays;
import java.util.Scanner;

public class DiceManager {

        //Use these values for the quick roll option.
        final int ROLLS = 1000;
        final int DICE = 2;
        final int SIDES = 6;

        //Declare variables for a DiceFactory and console input.
        
        private int choice = -1;
        private int myRolls = -1;
        private int myDice = -1;
        private int mySides = -1;

        Scanner scnr;
        DiceFactory diceF;

        /**
         * Construct a Scanner and a new DiceFactory object.
         */
        public DiceManager()
        {
        	//Instantiate the DiceFactory and Scanner objects.

            diceF = new DiceFactory();
            scnr = new Scanner(System.in);

        }

        /**
         * Launch the Dice Roller program menu.
         */
        public void go()
        {

            System.out.println("\nWelcome to Dice Roller.\n\n");

            do{
            
            displayMenu();
            
            choice = inputInt(scnr, "\nEnter Your Choice: ", 0, 3);

            switch (choice){

                case 0: // Do nothing to break out of the menu loop.

                    break;
                
                case 1: //Quick roll: call rollDice method and send the constants declared above.

                    diceF.rollDice(ROLLS, SIDES, DICE);

                    break;

                case 2: //Custom roll: use inputInt to get the number of rolls, dice, and sides.

                    myRolls = inputInt(scnr, "Enter Number of Rolls: ", 1, Integer.MAX_VALUE); //Gemini helped with getting the constant MAX_VALUE in accordance with the assignment's requirement to use AI.
                    myDice = inputInt(scnr, "Enter Number of Dice: ", 1, Integer.MAX_VALUE);
                    mySides = inputInt(scnr, "Enter Number of Sides: ", 2, Integer.MAX_VALUE); //Can't have a one-sided dice, so set min at 2.

                    diceF.rollDice(myRolls, mySides, myDice);

                    break;

                case 3: //Results array: get the array with the results of the last simulation.

                    System.out.println("\nResults Array: " + Arrays.toString(diceF.getLastSimulation())); //The Arrays.toString method (and associated import above) was found just with a simple google search (which taps into Gemini), as directed in the assignment for AI use.

                    break;

                default:

                    System.out.println("\nAn error occurred. Please re-run the program.");
                    choice = -1;

            }

            } while (choice != 0);

         }


        /**
         * Private helper method that displays the menu.
         */
        private void displayMenu()
        {
            System.out.println("\nChoose an Option -");
            System.out.println("0) Quit");
            System.out.printf("1) Quick roll with the default values (rolls = %d, dice = %d, sides = %d)\n", ROLLS, DICE, SIDES);
            System.out.println("2) Custom dice rolling (You enter the number of rolls, dice and sides.)");
            System.out.println("3) Get the array showing the results of the last simulation.\n");
        }
        

        /**
         * (Mostly) Error-proof method to get an int in a specified range from the user.
         * This method would be best as a static method in some library so that it can be used
         * in any of our programs.  That's why the first parameter is a Scanner object.
         * @param input - the Scanner object previously created for input.
         * @param prompt - the message to be displayed for the input prompt.
         * @param min - the smallest number allowed.
         * @param max - the largest number allowed.
         * @return the int entered by the user.
         */
        private int inputInt(Scanner input, String prompt, int min, int max)
        {
            int number = -1;    // -1 Just to make the compiler happy.
            boolean wrong = true;
            do
            {
                try
                {
                    System.out.print(prompt);
                    number = Integer.parseInt(input.nextLine());

                    if (number > max || number < min)
                    {
                        System.out.printf("That number is out of range [%d to %d].  Try again.\n",
                                min, max);
                    }
                    else    // good input
                    {
                        wrong = false;
                    }
                }
                catch (NumberFormatException e)
                {
                    System.out.println("Make sure you enter an integer.  Try again.");
                }
            } while (wrong);

            return number;
        }
    }



