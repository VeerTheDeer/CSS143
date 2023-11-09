public class ItemNotFoundException extends Exception {

    public ItemNotFoundException(String report){
        super(report);
    }

    public ItemNotFoundException(){
        super("Item was not found");
    }
}