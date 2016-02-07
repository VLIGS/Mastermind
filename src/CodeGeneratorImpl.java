
public class CodeGeneratorImpl implements CodeGenerator{
    @Override
    public Line getCode(PegColour pegColours, int codeLength){

        RandomGenerator generator = new RandomGeneratorImpl(); //Spring: need getInstance here
        Line code = new LineImpl(); //Spring: need getInstance here
        for(int i = 0; i<codeLength; i++){
            int c = generator.generateRandomNumber(pegColours.getLength());
            code.addPeg(new PegImpl(pegColours.getColour(c)));
        }
        return code;
    }
}
