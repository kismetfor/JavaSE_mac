package network1;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class TcpEchoClient {
    private Socket socket = null;

    public TcpEchoClient(String serverIp, int serverPort) throws IOException {
        socket = new Socket(serverIp, serverPort);
    }
    public void start() throws IOException{
        System.out.println("客户端启动!!!!");

        try (InputStream inputStream = socket.getInputStream();
             OutputStream outputStream = socket.getOutputStream()){
            Scanner scanner = new Scanner(System.in);
            Scanner scannerNetwork = new Scanner(inputStream);
            while (true) {
                System.out.print("->");
                if (!scanner.hasNext()) break;

                String request = scanner.next();
                PrintWriter printWriter = new PrintWriter(outputStream);
                printWriter.println(request);
                printWriter.flush();
                //使用println发送 为了有\n
                //这里是和服务器的scanner.next呼应
                String response = scannerNetwork.next();
                System.out.println(response);
                printWriter.flush();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) throws IOException{
        TcpEchoClient client = new TcpEchoClient("127.0.0.1", 9090);
//        TcpEchoClient client = new TcpEchoClient("192.168.43.1", 9090);
        client.start();
    }
}
