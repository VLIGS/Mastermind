import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Factory {
    private static BeanFactory factory = getBeanFactory();

    public static Game getInstance(Boolean b) {
        return (Game)factory.getBean("game", b);
    }
    public static Line getLine() {
        return (Line)factory.getBean("pegline");
    }
    public static Peg getPeg(String colour) {
        return (Peg)factory.getBean("peg",colour);
    }

    private static BeanFactory getBeanFactory() {
        // create a bean factory from beans.xml file
        return new ClassPathXmlApplicationContext("beans.xml");
    }
}
