import java.util.Scanner;

public class DiceManager {

        //Use these values for the quick roll option.
        final int ROLLS = 1000;
        final int DICE = 2;
        final int SIDES = 6;

        //TODO: Declare variables for a DiceFactory and console input.
        
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
        	//TODO: Instantiate the DiceFactory and Scanner objects.

            diceF = new DiceFactory();
            scnr = new Scanner(System.in);

        }

        /**
         * Launch the Dice Roller program menu.
         */
        public void go()
        {

            do{
            
            displayMenu();
            
            choice = inputInt(scnr, "Enter Choice: ", 0, 3);

            System.out.println("You chose: " + choice);
            

            switch (choice){

                case 0: // Do nothing to break out of the menu loop.
                    break;
                
                case 1: //Quick roll: call rollDice method and send the constants declared above.

                    diceF.rollDice(ROLLS, SIDES, DICE);

                    break;

                case 2: //Custom roll: use inputInt to get the number of rolls, dice, and sides.

                    myRolls = inputInt(scnr, "Enter nuber rolls: ", 1, 300);
                    myDice = inputInt(scnr, "Enter number dice: ", 1, 3);
                    mySides = inputInt(scnr, "Enter number sides: ", 1, 100);

                    diceF.rollDice(myRolls, mySides, myDice);

                    break;

                case 3: //Results array: get the array with the results of the last simulation.
                    break;

                default:
                    choice = -1;

            }

            } while (choice != 0);


         }


        /**
         * Private helper method that displays the menu.
         */
        private void displayMenu()
        {
            System.out.println("\nHere's the menu of choices -");
            System.out.println("0) Quit");
            System.out.printf("1) Quick roll with the default values (rolls = %d, dice = %d, sides = %d)\n", ROLLS, DICE, SIDES);
            System.out.println("2) Custom dice rolling (You enter the number of rolls, dice and sides.)");
            System.out.println("3) Get the array showing the results of the last simulation.");
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



