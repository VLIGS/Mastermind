import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class GameImpl implements Game {
    @Autowired
    private Display display;
    @Autowired
    private CodeGenerator codeGenerator;
    @Autowired
    private Analyser analyser;
    @Autowired
    private NumberOfPegs numberOfPegs;
    @Autowired
    private NumberOfGuesses numberOfGuesses;
    @Autowired
    private Scrambler scrambler;
    @Autowired
    private ErrorChecker errorChecker;

    private boolean showCode;
    private List<Line> guesses;
    private List<Line> feedback;

    private void prepareForGame(){
        guesses = new ArrayList<>();
        feedback = new ArrayList<>();
    }

    @Override
    public void setShowCode(Boolean code){
        this.showCode = code;
    }

    @Override
    public void runGames(){
        String playAgain;

        do {
            prepareForGame();
            display.displayStartingInstructions();
            display.displayInstructions("Generating secret code ....");
            Line code =  codeGenerator.getCode();
            display.displayInstructions("The secret code is " + code.toString(), showCode);
            int remainingNumberOfGuesses = numberOfGuesses.getNumberOfGuesses();
            do {
                String guess = "";
                while (!errorChecker.isValidGuess(guess)) {
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
                    display.displayResults(guesses, feedback);
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
