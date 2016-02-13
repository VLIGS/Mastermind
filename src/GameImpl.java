import java.util.ArrayList;
import java.util.List;

public class GameImpl implements Game {
    private Display display;
    private CodeGenerator codeGenerator;
    private Line code;
    private Analyser analyser;
    private PegColour pegColours;
    private NumberOfPegs numberOfPegs;
    private NumberOfGuesses numberOfGuesses;
    private List<Line> guesses;
    private List<Line> feedback;
    private Scrambler scrambler;
    private ErrorChecker errorChecker;
    private boolean showCode;
    private String playAgain;

    public GameImpl(){
    }
    private void prepareForGame(){
        guesses = new ArrayList<>();
        feedback = new ArrayList<>();

        pegColours = Factory.getPegColours();
        numberOfPegs = Factory.getNumberOfPegs();
        numberOfGuesses = Factory.getNumberOfGuesses();
        display = Factory.getDisplay();
        codeGenerator = Factory.getCodeGenerator();
        analyser = Factory.getAnalyser();
        scrambler = Factory.getScrambler();
        errorChecker = Factory.getErrorChecker();
    }
    private void clearForNextGame(){
        guesses = new ArrayList<>();
        feedback = new ArrayList<>();
        display = Factory.getDisplay();
        codeGenerator = Factory.getCodeGenerator();
        analyser = Factory.getAnalyser();
    }

    @Override
    public void setShowCode(Boolean code){
        this.showCode = code;
    }

    @Override
    public void runGames(){
        prepareForGame();
        do {
            clearForNextGame();
            display.displayInstructions(pegColours,numberOfPegs.getNumberOfPegs(),numberOfGuesses.getNumberOfGuesses());
            display.displayInstructions("Generating secret code ....");
            code = codeGenerator.getCode(pegColours, numberOfPegs);
            display.displayInstructions("The secret code is " + code.toString(), showCode);
            int remainingNumberOfGuesses = numberOfGuesses.getNumberOfGuesses();
            do {
                String guess = "";
                while (!errorChecker.isValidGuess(guess,pegColours.getColours(),numberOfPegs.getNumberOfPegs())) {
                    guess = display.getGuess(remainingNumberOfGuesses);
                }
                guesses.add(Line.stringToLine(guess));
                feedback.add(scrambler.scramble(analyser.analyseGuess(guesses.get(numberOfGuesses.getNumberOfGuesses()-remainingNumberOfGuesses),code)));
                display.displayInstructions("The secret code is " + code.toString(), showCode);

                if(analyser.checkIfWon(feedback.get(numberOfGuesses.getNumberOfGuesses()-remainingNumberOfGuesses),numberOfPegs.getNumberOfPegs())){
                    display.displayWin(guesses, feedback);
                    remainingNumberOfGuesses = 0;
                }
                else if(remainingNumberOfGuesses>1) {
                    display.displayResults(guesses, feedback, numberOfGuesses.getNumberOfGuesses());
                    remainingNumberOfGuesses--;
                }
                else{
                    display.displayLoss();
                    remainingNumberOfGuesses--;
                }

            } while (remainingNumberOfGuesses>0);

            playAgain = display.getUserChoice();

        } while(playAgain.toUpperCase().equals("Y"));
    }
}
