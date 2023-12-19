public class Date {
    public int year;
    public int month;
    public int date;
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
        date1.setDate(2021, 12,21);
        date1.printDate();
        Date date2 = new Date();
        date2.setDate(1234,1,23);
    }
}
