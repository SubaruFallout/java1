package exceptons;

public class MyException extends RuntimeException {
    public MyException() {
        super("Overflow of backpack");
    }
}
