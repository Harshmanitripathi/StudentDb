package StudentPackage;

public class BadDataEnteredException extends Exception{

    String s;
     BadDataEnteredException(String s){
        this.s = s;
    }

    @Override
    public String toString() {
        return s;
    }
}
