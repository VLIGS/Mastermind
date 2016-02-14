
public class Feedback {

    private static String exactMatch;
    private static String symbolMatch;
    private static String noMatch;

    public Feedback(String exactMatch, String symbolMatch, String noMatch){
        this.exactMatch = exactMatch;
        this.symbolMatch = symbolMatch;
        this.noMatch = noMatch;

    }

    public static String getExactMatch(){return exactMatch;}
    public static void setExactMatch(String s){exactMatch = s;}

    public static String getSymbolMatch(){return symbolMatch;}
    public static void setSymbolMatch(String s){symbolMatch = s;}

    public static String getNoMatch(){return noMatch;}
    public static void setNoMatch(String s){noMatch = s;}

}
