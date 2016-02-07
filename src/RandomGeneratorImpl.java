import java.util.Random;

public class RandomGeneratorImpl implements RandomGenerator{
    public int generateRandomNumber(int n) {
        Random numberGenerator = new Random();
        return numberGenerator.nextInt(n-1);
    }
}
