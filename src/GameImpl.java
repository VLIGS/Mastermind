import java.lang.reflect.Field;

public class GameImpl extends GameAbstractImpl implements Game {
    private Line code;
    private PegColour myPegColours = new PegColourImpl("blue", "green", "orange", "purple", "red", "yellow");

    public GameImpl(boolean easy){
        super(easy);
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

        //code = CodeGenerator::getCode()
        //
        //get guess from user
        //check if valid guess
        //store guess
        //analyse guess
        //scramble


    }
}
