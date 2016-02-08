
import org.junit.runner.RunWith;
import org.junit.runners.Suite;


// specify a runner class: Suite.class
@RunWith(Suite.class)

// specify an array of test classes
@Suite.SuiteClasses({
        AnalyserTests.class,
        CodeGeneratorTests.class,
        ErrorCheckerTests.class,
        ScramblerTests.class}
)

// the actual class is empty
public class AllTests {
}