package demo3;

public class KeyBoard implements USB{
    @Override
    public void openDevice() {
        System.out.println("打开键盘");
    }
    public void inPut() {
        System.out.println("输入数据");
    }
    @Override
    public void closeDevice() {
        System.out.println("关闭键盘");
    }
}
