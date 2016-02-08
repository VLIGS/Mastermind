import java.util.List;
import java.util.Scanner;

public class DisplayImpl implements Display{
    private Scanner scan = new Scanner(System.in); //Spring

    @Override
    public void displayInstructions(PegColour pegColour, int numberOfPegs, int numberOfGuesses){

        System.out.println("Welcome to Mastermind.\n" +
                "\n" +
                "This is a text version of the classic board game Mastermind.\n" +
                "The computer will think of a secret code.\n" +
                "The code consists of " + numberOfPegs + " colored pegs.\n" +
                "The pegs may be one of " + pegColour.getLength() + " colors: " +
                pegColour.getAllColours().toString() + " \n" +
                "A color may appear more than once in the code.\n" +
                "\n" +
                "You try to guess what colored pegs are in the code and what order they are in\n" +
                "After making a guess the result will be displayed.\n" +
                "A result consists of a black peg for each peg you have exactly correct (color and position) in your guess.\n" +
                "For each peg in the guess that is the correct color, but is out of position, you get a white peg.\n" +
                "\n" +
                "Only the first letter of the color is displayed. B for Blue, R for Red, and so forth.\n" +
                "When entering guesses you only need to enter the first character of the color as a capital letter.\n" +
                "\n" +
                "You have " + numberOfGuesses + " tries to guess the answer or you lose the game.\n");

    }

    @Override
    public void displayInstructions(String instruction){
        System.out.println("\n" + instruction);
    }
    @Override
    public void displayInstructions(String instruction, boolean showCode){
        if(showCode){
            System.out.println("\n" + instruction);
        }
    }

    @Override
    public String getGuess(int numberOfGuesses){

        System.out.println("\n" + "You have " + numberOfGuesses + " guesses left" + "\n");

        System.out.println("\n" + "What is your next guess?\n" +
                "Type in the characters for your guess and press enter.\n" +
                "Enter guess:");

        return retrieveInput();
    }

    @Override
    public void displayResults(List guesses, List results, int NumberOfGuessesAllowed){
            System.out.println("\n" + ".... Secret Code");
            int j;
            for (j = 0; j < guesses.size(); j++) {
                System.out.println(guesses.get(j).toString() + " Result: " + results.get(j).toString());
            }
            for (int i = j; i < NumberOfGuessesAllowed; i++){
                System.out.println("....");
            }
    }
    @Override
    public void displayWin(List guesses, List results){
        System.out.println(guesses.get(guesses.size()-1).toString());
        for (int j = 0; j < guesses.size(); j++) {
            System.out.println(guesses.get(j).toString() + " Result: " + results.get(j).toString());
        }
        System.out.println("You solved the puzzle! Good job.\n");
    }
    @Override
   public void displayLoss(){
        System.out.println("You have used up all your turns unfortunately\n");
    }
    @Override
    public String getUserChoice(){
        System.out.println("Enter Y for another game or anything else to quit: ");
        return retrieveInput();
    }

    private String retrieveInput(){
        return scan.next();
    }
}
