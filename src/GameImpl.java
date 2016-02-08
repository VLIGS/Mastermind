import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class GameImpl extends GameAbstractImpl implements Game {
    private Display display;
    private CodeGenerator codeGenerator;
    private Line code;
    private Analyser analyser;
    private PegColour pegColours;
    private NumberOfPegs numberOfPegs;
    private final NumberOfGuesses numberOfGuesses;
    private List<Line> guesses;
    private List<Line> feedback;
    private Scrambler scrambler;
    private ErrorChecker errorChecker;
    private boolean showCode;

    public GameImpl(boolean easy){
        super(easy);
        this.showCode = easy;
        guesses = new ArrayList<>();
        feedback = new ArrayList<>();

        pegColours = new PegColourImpl("blue", "green", "orange", "purple", "red", "yellow"); //Spring: need getInstance here
        numberOfPegs = new NumberOfPegs(4); //Spring: need getInstance here
        numberOfGuesses = new NumberOfGuesses(12); //Spring: need getInstance here
        display = new DisplayImpl(); //Spring
        codeGenerator = new CodeGeneratorImpl(); //Spring: need getInstance here
        analyser = new AnalyserImpl(); //Spring: need getInstance here
        scrambler = new ScramblerImpl(); //Spring: need getInstance here
        errorChecker = new ErrorCheckerImpl();//Spring: need getInstance here
    }

    /**
    private static GameImpl instance = null;  //static constructor block
    private GameImpl(boolean easy){
        super(easy);
    }
    public static GameImpl getInstance(boolean easy) {
        instance = new GameImpl(easy);
        return instance;
    }
     **/
    public boolean getShowCode(){
        try{
            Field field = GameAbstractImpl.class.getField("showCode");
        } catch(NoSuchFieldException e){
            System.out.println("No such field");
        }
        return true;
    }
    @Override
    public void runGames(){

        display.displayInstructions(pegColours,numberOfPegs.getNumberOfPegs(),numberOfGuesses.getNumberOfGuesses());
        display.displayInstructions("Generating secret code ....");
        code = codeGenerator.getCode(pegColours, numberOfPegs);
        display.displayInstructions("The secret code is " + code.toString(), showCode);
        int remainingNumberOfGuesses = numberOfGuesses.getNumberOfGuesses();

        do {
            String guess = "";
            while (!errorChecker.isValidGuess(guess,pegColours.getAllColours(),numberOfPegs.getNumberOfPegs())) {
                guess = display.getGuess(remainingNumberOfGuesses);
            }
            guesses.add(Line.stringToLine(guess));
            feedback.add(scrambler.scramble(analyser.analyseGuess(guesses.get(numberOfGuesses.getNumberOfGuesses()-remainingNumberOfGuesses),code)));
            display.displayInstructions("The secret code is " + code.toString(), showCode);
            display.displayResults(guesses, feedback, numberOfGuesses.getNumberOfGuesses());




            remainingNumberOfGuesses--;

        } while (remainingNumberOfGuesses>0);


    }
}
