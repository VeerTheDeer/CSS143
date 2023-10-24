public class Date {
    private int day;
    private int month;
    private int year;

    public static void main(String[] args) {
        Date Chrismas = new Date();
        Chrismas.setDate(12, 25, 2023);
        Chrismas.report();
    }

    public void setDate(int m, int d, int y) {
        this.month = m;
        this.day = d;
        this.year = y;
    }

    public void report() {
        System.out.println(this.month + "/" + this.day + "/" + this.year);

    }
}
