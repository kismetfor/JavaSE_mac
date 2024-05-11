import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class TCPEchoClient {
    //有连接 可靠传输
    private Socket socket = null;

    public TCPEchoClient(String host, int port) throws IOException {
        socket = new Socket(host, port);
    }
    public void start() throws IOException{
        System.out.println("客户端启动");
        Scanner scannerConsole = new Scanner(System.in);
        Scanner scannerNetwork = new Scanner(socket.getInputStream());
        PrintWriter printWriter = new PrintWriter(socket.getOutputStream());
        while (true) {
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

    public static void main(String[] args) throws IOException{
        TCPEchoClient client = new TCPEchoClient("127.0.0.1", 9090);
        client.start();
    }
}
