import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Factory {
    private static BeanFactory factory = getBeanFactory();

    public static Game getInstance(Boolean b) {
        Game g = (Game)factory.getBean("game");
        g.setShowCode(b);
        return g;

    }

    /**
    public static Feedback getFeedback(){
        //return new Feedback();
        return (Feedback)factory.getBean("feedback");
    }
     **/

    public static Analyser getAnalyser() {
        return (Analyser)factory.getBean("analyser");
    }

    public static PegColour getPegColours(){
        return (PegColour)factory.getBean("pegcolour");
    }

    public static Line getLine() {
        return (Line)factory.getBean("pegline");
    }
    public static Peg getPeg(String colour) {
        Peg peg = (Peg)factory.getBean("peg");
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
