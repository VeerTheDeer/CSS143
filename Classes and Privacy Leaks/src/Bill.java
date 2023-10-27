/**
 * Represents a Bill with its specific details.
 * by Veer Saini
 * 10/27/23
 */
public class Bill {
    private Money amount;
    private Date dueDate;
    private Date paidDate;
    private String originator;

    /**
     * Constructs a Bill object with the provided amount, due date, and originator details.
     *
     * @param amount     The amount of the bill (Money object).
     * @param dueDate    The due date of the bill (Date object).
     * @param originator The originator of the bill (String).
     */
    public Bill(Money amount, Date dueDate, String originator) {
        this.amount = new Money(amount);
        this.dueDate = new Date(dueDate);
        this.paidDate = null;
        this.originator = originator;
    }

    /**
     * Constructs a Bill object using the values from another Bill object.
     *
     * @param other Another Bill object.
     */
    public Bill(Bill other) {
        this.amount = other.getAmount();
        this.dueDate = other.getDueDate();
        this.originator = other.getOriginator();
        this.paidDate = other.paidDate;
    }

    /**
     * Retrieves the amount of the Bill object.
     *
     * @return A new Money object representing the amount.
     */
    public Money getAmount() {
        return new Money(amount);
    }

    /**
     * Retrieves the due date of the Bill object.
     *
     * @return A new Date object representing the due date.
     */
    public Date getDueDate() {
        return new Date(dueDate);
    }

    /**
     * Retrieves the originator of the Bill object.
     *
     * @return The originator as a String.
     */
    public String getOriginator() {
        return originator;
    }

    /**
     * Checks if the bill is paid.
     *
     * @return True if the bill is paid; otherwise, false.
     */
    public boolean isPaid() {
        return (paidDate != null);
    }

    /**
     * Sets the bill as paid on a given date.
     *
     * @param datePaid The date on which the bill is paid (Date object).
     * @return True if the bill is successfully marked as paid; otherwise, false.
     */
    public boolean setPaid(Date datePaid) {
        if (dueDate.isAfter(datePaid)) {
            return false;
        } else {
            paidDate = new Date(datePaid);
            return true;
        }
    }

    /**
     * Sets a new due date for the bill.
     *
     * @param nextDate The new due date (Date object).
     * @return True if the new due date is set successfully; otherwise, false.
     */
    public boolean setDueDate(Date nextDate) {
        if (isPaid()) {
            return false;
        } else {
            dueDate = new Date(nextDate);
            return true;
        }
    }

    /**
     * Sets a new amount for the bill.
     *
     * @param amount The new amount (Money object).
     * @return True if the new amount is set successfully; otherwise, false.
     */
    public boolean setAmount(Money amount) {
        if (isPaid()) {
            return false;
        } else {
            this.amount = new Money(amount);
            return true;
        }
    }

    /**
     * Sets a new originator for the bill.
     *
     * @param originator The new originator for the bill (String).
     */
    public void setOriginator(String originator) {
        this.originator = originator;
    }

    /**
     * Converts the Bill object to a string.
     *
     * @return A string representation of the Bill object.
     */
    @Override
    public String toString() {
        String paid = "";
        if (isPaid())
            paid += "Bill paid on " + paidDate.toString();
        else
            paid += "Bill not paid.";

        return "Amount: " + amount + " Due Date: " + dueDate + " Originator: " + originator + " " + paid;
    }

    /**
     * Checks the equality between Bill objects.
     *
     * @param toCompare The object to compare.
     * @return True if the Bill objects are equal; otherwise, false.
     */
    @Override
    public boolean equals(Object toCompare) {
        if (!(toCompare instanceof Bill that)) {
            return false;
        }

        return this.amount.equals(that.amount) && this.dueDate.equals(that.dueDate) && this.isPaid() == (that.isPaid()) && this.originator.equals(that.originator);

    }
}
