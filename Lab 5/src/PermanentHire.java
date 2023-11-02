public class PermanentHire extends SalariedWorker{
    public static final double ACCOUNTANT_MONTHLY = 10000;

    public PermanentHire() {

    }

    public PermanentHire(String name, int social) {
        super(name, social, ACCOUNTANT_MONTHLY);
    }
    public PermanentHire(String name, int social, int monthlyPay) {
        super(name, social, monthlyPay);
    }

    @Override
    public double calculateWeeklyPay() {
        return (getMonthlyPay()/4) + 250;
    }

}