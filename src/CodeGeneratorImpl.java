
public class CodeGeneratorImpl implements CodeGenerator{
    @Override
    public Line getCode(PegColour pegColours, NumberOfPegs numberOfPegs){

        RandomGenerator generator = Factory.getRandomGenerator();
        Line code = Factory.getLine();
        for(int i = 0; i<numberOfPegs.getNumberOfPegs(); i++){
            int c = generator.generateRandomNumber(pegColours.getLength());
            code.addPeg(Factory.getPeg(pegColours.getColour(c).substring(0,1).toUpperCase()));
        }
        return code;
    }
}
