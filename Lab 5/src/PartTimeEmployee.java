public class PartTimeEmployee extends HourlyWorker{
    private PartTimeEmployee() {
        //private blocks this object from being created this way

    }
    //the only way to make an Accountant is to specify the name and social, or with the other constructor below that takes name, social, and pay
    public PartTimeEmployee(String name, int social){
        super(name, social);
    }
    public PartTimeEmployee(String name, int social, double pay) {
        super(name, social, pay);
    }

    @Override
    public double calculateWeeklyPay() {
        return getHourlyPay() * 20;
    }
}
