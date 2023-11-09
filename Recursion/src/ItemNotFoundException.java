/**
 * The ItemNotFoundException class extends Exception and represents an exception thrown when an item is not found.
 */
public class ItemNotFoundException extends Exception {

    /**
     * Constructs an ItemNotFoundException with a custom error report.
     *
     * @param report A custom error report detailing the specific reason for the exception.
     */
    public ItemNotFoundException(String report) {
        super(report);
    }

    /**
     * Constructs an ItemNotFoundException with a default error message indicating that the item was not found.
     */
    public ItemNotFoundException() {
        super("Item was not found");
    }
}
