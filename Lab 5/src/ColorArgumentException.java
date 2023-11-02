public class ColorArgumentException extends IllegalArgumentException{
    public ColorArgumentException() {
        super("A color channel was set to invalid value.");
    }
    public ColorArgumentException(String str) {
        super(str);
    }

}