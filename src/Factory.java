import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Factory {
    private static BeanFactory factory = getBeanFactory();
    //private static Feedback feedback;

    public static Game getInstance(Boolean b) {
        //Game g = (Game)factory.getBean("game");
        Game g = new GameImpl();
        g.setShowCode(b);
        return g;

    }
    /**
    public static void getFeedback(){
        feedback = (Feedback)factory.getBean("feedback");
    }
     **/
    public static Analyser getAnalyser() {
        return (Analyser)factory.getBean("analyser");
    }
    public static PegColour getPegColours(){
        PegColour p = (PegColour)factory.getBean("pegcolour");
        p.setPegColours();
        return p;
    }
    public static Line getLine() {
        return new LineImpl();
        //return (Line)factory.getBean("pegline");
    }
    public static Peg getPeg(String colour) {
        //Peg pegToReturn = peg.
        Peg peg = new PegImpl();
        peg.setPeg(colour);
        return peg;
    }
    public static Display getDisplay() {
        return (Display)factory.getBean("display");
    }
    public static Scrambler getScrambler() {
        return (Scrambler) factory.getBean("scrambler");
    }
    public static RandomGenerator getRandomGenerator() {
        return (RandomGenerator) factory.getBean("randomgenerator");
    }
    public static ErrorChecker getErrorChecker() {
        return (ErrorChecker) factory.getBean("errorchecker");
    }
    public static CodeGenerator getCodeGenerator() {
        return (CodeGenerator) factory.getBean("codegenerator");
    }
    public static NumberOfGuesses getNumberOfGuesses() {
        return (NumberOfGuesses) factory.getBean("numberofguesses");
    }
    public static NumberOfPegs getNumberOfPegs() {
        return (NumberOfPegs) factory.getBean("numberofpegs");
    }
    private static BeanFactory getBeanFactory() {
        // create a bean factory from beans.xml file
        BeanFactory factory = new ClassPathXmlApplicationContext("beans.xml");
        return factory;
    }
}
