class Stu {
    private String name;
    private int age;
    public Stu(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Stu() {
        this("张雨潇", 12);
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return this.name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    private void eat() {
        System.out.println(this.name+"正在吃饭");
    }

}

public class Main1 {
    public static void main(String[] args) {
        Stu s1 = new Stu("徐涛", 12);
        Stu s2 = new Stu();
        s2.setName("陈立");
        System.out.println(s2.getName());
    }
    
}