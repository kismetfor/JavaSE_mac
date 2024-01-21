public class Date {
    public int year;
    public int month;
    public int date;
    public Date() {
        this(2002,12,12);
    }
    public Date(int year, int month, int date){
        this.year = year;
        this.month = month;
        this.date = date;
    }

    public Date(int year, int date) {
        this.year = year;
        this.date = date;
    }

    public void setDate(int year, int month, int date){
        this.year = year;
        this.month = month;
        this.date = date;
    }
    public void printDate() {
        System.out.println(year+"年"+month+"月"+date+"日");
    }

    public static void main(String[] args) {
        Date date1 = new Date();
        date1.printDate();

    }
}
