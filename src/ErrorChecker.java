import java.util.List;

public interface ErrorChecker {
    boolean isValidGuess(String guess, List<String> colours, int codeLength);
}
