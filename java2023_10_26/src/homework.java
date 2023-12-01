public class homework {

    public static boolean isSushu(int n){
        if(n==1){
            return true;
        }
        for (int j = 2; j <=Math.sqrt(n); j++) {
            if(n%j==0){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        //打印 1 - 100 之间所有的素数
        for (int i = 1; i < 100; i++) {
            if(isSushu(i)){
                System.out.println(i);
            }
        }
    }
    public static void main2(String[] args) {
        //输出 1000 - 2000 之间所有的闰年
        for (int i=1000; i<2000; i++){
            if((i%4==0 && i%100!=0) || i%400==0){
                System.out.println(i);
            }
        }
    }
    public static void main1(String[] args) {
        //编写程序数一下 1到 100 的所有整数中出现多少个数字9
        int count = 0;
        for (int i=1; i<=100; i++){
            if((i-9)%10 == 0){
                count++;
//                System.out.println(i);
            }
            if ((i-9*10)>=0 && (i-9*10)<10){
                count++;
//                System.out.println(i);
            }
        }
        System.out.println(count);
    }
}
