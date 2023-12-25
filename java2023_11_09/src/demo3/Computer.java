package demo3;

public class Computer {
    public void powerON() {
        System.out.println("打开电脑");
    }
    public void powerOff() {
        System.out.println("关闭电脑");
    }
    public void useDevice(USB usb) {
        usb.openDevice();
        if(usb instanceof KeyBoard) {
            KeyBoard keyBoard = (KeyBoard) usb;
            keyBoard.inPut();
        } else if (usb instanceof Mouse) {
            Mouse mouse = (Mouse) usb;
            mouse.click();
        }
        usb.closeDevice();
    }
}
