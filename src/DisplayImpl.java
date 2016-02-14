import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Scanner;

public class DisplayImpl implements Display{
    private Scanner scan;
    @Autowired
    PegColour pegColour;
    @Autowired
    NumberOfGuesses numberOfGuesses;
    @Autowired
    NumberOfPegs numberOfPegs;

    public DisplayImpl(){
        scan = new Scanner(System.in); //Spring
    }

    @Override
    public void displayStartingInstructions(){

        displayInstructions("\n" + "Welcome to Mastermind.\n" +
                "\n" +
                "This is a text version of the classic board game Mastermind.\n" +
                "The computer will think of a secret code.\n" +
                "The code consists of " + numberOfPegs.getNumberOfPegs() + " colored pegs.\n" +
                "The pegs may be one of " + pegColour.getLength() + " colors: " +
                pegColour.getColours().toString() + " \n" +
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
                "You have " + numberOfGuesses.getNumberOfGuesses() + " tries to guess the answer or you lose the game.\n");

    }

    @Override
    public void displayInstructions(String instruction){
        System.out.println(instruction); //Spring
    }
    @Override
    public void displayInstructions(String instruction, boolean showCode){
        if(showCode){
            displayInstructions("\n" + instruction + "\n");
        }
    }

    @Override
    public String getGuess(int numberOfGuesses){

        displayInstructions("\n" + "You have " + numberOfGuesses + " guesses left" + "\n");

        displayInstructions("\n" + "What is your next guess?\n" +
                "Type in the characters for your guess and press enter.\n" +
                "Enter guess:" + "\n");

        return retrieveInput();
    }

    @Override
    public void displayResults(List guesses, List results){
        displayInstructions("\n" + ".... Secret Code");
            int j = guesses.size()-2;
            displayResultsLine(guesses, results);
            for (int i = j; i < numberOfGuesses.getNumberOfGuesses(); i++){
                displayInstructions("....");
            }
    }
    private void displayResultsLine(List guesses, List results){
        int j;
        for (j = 0; j < guesses.size(); j++) {
            String resultLine = "";
            Line line = (Line) results.get(j);
            resultLine = guesses.get(j).toString() + " Result: ";
            for (int r = 0; r < line.numberOfPegs(); r++) {
                resultLine = resultLine + line.getPeg(r).getPegColour() + " ";
            }
            displayInstructions(resultLine);
        }
    }
    @Override
    public void displayWin(List guesses, List results){
        displayInstructions(guesses.get(guesses.size()-1).toString());
        displayResultsLine(guesses, results);
        displayInstructions("\n" + "You solved the puzzle! Good job.\n");
    }
    @Override
   public void displayLoss(){
        displayInstructions("\n" + "You have used up all your turns unfortunately\n");
    }
    @Override
    public String getUserChoice(){
        displayInstructions("\n" + "Enter Y for another game or anything else to quit: " + "\n");
        return retrieveInput();
    }

    private String retrieveInput(){
        return scan.next();
    }
}
