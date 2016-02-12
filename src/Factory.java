import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

//@Service
public class Factory {
    private static BeanFactory factory = getBeanFactory();

    public static Game getInstance(Boolean b) {
        return new GameImpl(b);
    }
   // @Autowired
    public static Analyser getAnalyser() {
        return (Analyser)factory.getBean("analyser");
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
     /**
        String myClassName = c.getName();
        Constructor myConstructor = null;
        Class parameters [] = new Class [0];
        Object [] myConstructorParameters = new Object[parameters.length];
        myConstructorParameters[0]=b;
        parameters[0] = b.getClass();

        try {
            myConstructor = Class.forName(myClassName).getConstructor(parameters);
        } catch (ClassNotFoundException e) {
        System.out.println("No suitable instruction exist");
        }
        catch (NoSuchMethodException e) {
            System.out.println("No suitable constructor exist");
        }
        try{
            return  (Game) myConstructor.newInstance(myConstructorParameters);
        }catch (InstantiationException e) {
        System.out.println("No suitable instruction exist");
        }
        catch (IllegalAccessException e) {
        System.out.println("No suitable instruction exist");
        }
        catch (InvocationTargetException e) {
        System.out.println("No suitable instruction exist");
        }
        return null;
    }
         **/
}
