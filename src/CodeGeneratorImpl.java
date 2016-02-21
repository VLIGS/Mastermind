import org.springframework.beans.factory.annotation.Autowired;

public class CodeGeneratorImpl implements CodeGenerator{
    @Autowired
    private RandomGenerator generator;
    @Autowired
    PegColour pegColours;
    @Autowired
    NumberOfPegs numberOfPegs;

    @Override
    public Line getCode(){
        Line code = Factory.getLine();
        for(int i = 0; i<numberOfPegs.getNumberOfPegs(); i++){
            int c = generator.generateRandomNumber(pegColours.getLength());
            code.addPeg(Factory.getPeg(pegColours.getColour(c).substring(0,1).toUpperCase()));
        }
        return code;
    }
}
