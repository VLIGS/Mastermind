public class Factory {

    public static Game getInstance(Class c, Boolean b) {
        return new GameImpl(b);
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
