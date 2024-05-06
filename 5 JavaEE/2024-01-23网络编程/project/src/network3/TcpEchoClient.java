package network3;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class TcpEchoClient {
    private Socket socket = null;
    public TcpEchoClient(String serverIP, int serverPort) throws IOException {
        //tcp有连接 因此socket会保存好这两个信息
        //因此此处不像UDP需要保存IP和Port
        socket = new Socket(serverIP, serverPort);
    }
    public void start() throws IOException{
        System.out.println("客户端启动");
        try (InputStream inputStream = socket.getInputStream();
             OutputStream outputStream = socket.getOutputStream()){
            //控制台读取输入的Scanner
            Scanner scannerConsole = new Scanner(System.in);
            //网络读取输入的Scanner
            Scanner scannerNetwork = new Scanner(inputStream);
            PrintWriter printWriter = new PrintWriter(outputStream);
            while (true) {
                System.out.print("->");
                if (!scannerConsole.hasNext()) {
                    break;
                }
                String request = scannerConsole.next();


                //这里和服务器的scanner.next呼应
                printWriter.println(request);
                printWriter.flush();

                String response = scannerNetwork.next();
                System.out.println(response);
            }
        }
    }
    public static void main(String[] args) throws IOException{
        TcpEchoClient client = new TcpEchoClient("127.0.0.1", 9090);
        client.start();
    }
}
