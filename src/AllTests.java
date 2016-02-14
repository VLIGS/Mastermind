
import org.junit.runner.RunWith;
import org.junit.runners.Suite;


//runner class:
@RunWith(Suite.class)

//all test classes
@Suite.SuiteClasses({
        AnalyserTests.class,
        CodeGeneratorTests.class,
        ErrorCheckerTests.class,
        ScramblerTests.class}
)

public class AllTests {
}