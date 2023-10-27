/**
 * A class to test the functionality of Money, Date, and Bill classes.
 * By Veer Saini
 * 10/27/23
 */
public class BillMoneyDateDriver {

    /**
     * Performs tests on the Money class to verify its functionalities.
     *
     * <This method initializes instances of the Money class, performs various operations such as addition and modification,
     * and checks for equality between money instances. It tests the addition and modification of money amounts and validates
     * whether the operations are performed accurately. It also verifies the handling of invalid values and checks for the equality
     * of different money instances.
     */
    public static void moneyTests() {
        Money rack = new Money(1000, 0);
        Money grand = new Money(rack);
        System.out.println(rack.equals(grand));

        Money myMoney = new Money(19999, 199);
        myMoney.add(10000); //salary
        System.out.println(myMoney);
        //myMoney.setMoney(-1,-1); //should send an error message

        Money friendsMoney = new Money(0, 101);
        System.out.println(friendsMoney);
        System.out.println(myMoney.getMoney());
    }

    /**
     * Performs tests on the Date class to examine its functionalities.
     *
     * This method creates Date instances, performs comparison operations, checks for equality, and manipulates date values. It validates
     * the comparison functions and modification of date values. It tests setting individual date components and ensures the accurate
     * representation of date information.
     */
    public static void dateTests() {
        Date midterm1 = new Date(3, 20, 2020);
        Date midterm2 = new Date(12, 25, 2026);
        Date sameAsDate1 = new Date(midterm1);

        System.out.println(midterm1.isAfter(midterm2));
        System.out.println(midterm1.equals(midterm2));
        System.out.println(midterm1.equals(sameAsDate1));
        System.out.println(midterm1.toString());

        // midterm1.setYear(2027);
        // midterm2.setMonth(13);
        midterm1.setDay(5);
        midterm1.setMonth(2);
        System.out.println(midterm1.toString());
    }

    /**
     * Performs tests on the Bill class to validate its functionalities.
     *
     * This method creates instances of Bill, sets up due dates, amounts, and payment dates, and validates the functionalities
     * related to bills. It checks for equality between different Bill instances, modifies bill attributes, and verifies the accurate
     * representation of bill information, such as due dates and payment status. It also ensures that the payment status is correctly handled.
     */
    public static void billTests() {
        Money poor = new Money(1000, 5);
        Money bankLoan = new Money(40000);
        Date loanDue = new Date(10, 31, 2023);
        Date loanPay = new Date(10, 25, 2023);
        Bill loan = new Bill(bankLoan, loanDue, "Bank of America");

        Bill sameBill = new Bill(loan);
        System.out.println(loan.equals(sameBill)); //should be the same.
        System.out.println(loan);
        System.out.println(loanDue.equals(loan.getDueDate()));
        System.out.println(loanDue == loan.getDueDate()); //Privacy leak test

        loan.setPaid(loanPay);
        System.out.println(loan);
        System.out.println(loan.setAmount(poor));

        sameBill.setOriginator("JP Morgan Chase Bank");
        Money newAmount = new Money(44000, 100000);
        sameBill.setAmount(newAmount);
        System.out.println(sameBill);

        Date chaseLoan = new Date(12, 31, 2023);
        sameBill.setDueDate(chaseLoan);
        System.out.println(sameBill);

        sameBill.setPaid(loanPay);
        System.out.println(sameBill);
        System.out.println(sameBill.isPaid());
        System.out.println(sameBill.setDueDate(loanDue));
    }
}
