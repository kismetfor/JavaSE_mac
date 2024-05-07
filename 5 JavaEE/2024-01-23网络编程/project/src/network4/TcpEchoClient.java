package network4;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class TcpEchoClient {
    private Socket socket = null;

    public TcpEchoClient(String host, int port) throws IOException {
        // public Socket(String host, int port)
        socket = new Socket(host, port);
    }

    public void start() throws IOException{
        System.out.println("客户端启动");
        try (InputStream inputStream = socket.getInputStream();
             OutputStream outputStream = socket.getOutputStream();
             ){
            Scanner scannerConsole = new Scanner(System.in);
            Scanner scannerNetwork = new Scanner(inputStream);
            PrintWriter printWriter = new PrintWriter(outputStream);
            while (true) {
                System.out.print("->");
                if (!scannerConsole.hasNext()) {
                    System.out.println("客户端下线");
                    break;
                }
                String request = scannerConsole.next();

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
