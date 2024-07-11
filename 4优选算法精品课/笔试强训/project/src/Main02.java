import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

class Read // 自定义快速读入
{
    StringTokenizer st = new StringTokenizer("");
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    String next() throws IOException
    {
        while(!st.hasMoreTokens())
        {
            st = new StringTokenizer(bf.readLine());
        }
        return st.nextToken();
    }

    String nextLine() throws IOException
    {
        return bf.readLine();
    }

    int nextInt() throws IOException
    {
        return Integer.parseInt(next());
    }

    long nextLong() throws IOException
    {
        return Long.parseLong(next());
    }

    double nextDouble() throws IOException
    {
        return Double.parseDouble(next());
    }
}
public class Main02 {

    public static void main(String[] args) throws IOException{
        Read in = new Read();

        int n = in.nextInt();
        int x = in.nextInt();
        int[] a = new int[n+1];
        for (int i = 1; i <= n; i++) {
            a[i] = in.nextInt();
        }

        int minlength = n;
        int start = 1;
        int end = n;

        int left = 1;
        int right = 1;
        int sum = 0;

        while (right <= n) { //后续修改条件
            sum += a[right]; //进窗口

            while (sum >= x) { //出窗口
                if (right-left+1 < minlength) { //记录
                    minlength = right-left+1;
                    start = left;
                    end = right;
                }
                sum -= a[left++];
            }
            right++;
        }

        System.out.println(start+" "+ end);
    }
}
