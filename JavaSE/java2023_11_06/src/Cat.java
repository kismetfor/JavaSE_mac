public class Cat extends Animal{
    public Cat() {
        super("小花", 18);
    }

    public void miaomiao() {
        System.out.println(this.name+" 喵喵叫.........");
    }

    public static void main(String[] args) {
        Cat c = new Cat();
        c.miaomiao();
    }
}
