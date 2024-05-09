import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class TCPEchoServer {
    private ServerSocket serverSocket = null;

    public TCPEchoServer(int port) throws IOException {
        serverSocket = new ServerSocket(port);
    }
    public void start() throws IOException{
        System.out.println("服务器启动");
        while (true) {
            Socket clientSocket = serverSocket.accept();
            Thread t = new Thread(()->{
                try {
                    processConnector(clientSocket);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            });
            t.start();
        }

    }

    private void processConnector(Socket clientSocket) throws IOException{
        System.out.printf("[%s %d] 客户端上线", clientSocket.getInetAddress(), clientSocket.getPort());
        try (InputStream inputStream = clientSocket.getInputStream();
             OutputStream outputStream = clientSocket.getOutputStream();
        ){
            Scanner scanner = new Scanner(inputStream);
            PrintWriter printWriter = new PrintWriter(outputStream);
            while (true) {
                if (!scanner.hasNext()) {
                    System.out.printf("[%s %d] 客户端下线", clientSocket.getInetAddress(), clientSocket.getPort());
                    break;
                }
                String request = scanner.next();
                String response = process(request);
                printWriter.println(response);
                printWriter.flush();
                System.out.printf("[%s %d] req: %s resp: %s", clientSocket.getInetAddress(),
                        clientSocket.getPort(), request, response);
            }
        }

    }

    private String process(String request) {
        return request;
    }

    public static void main(String[] args) throws IOException{
        TCPEchoServer server = new TCPEchoServer(9090);
        server.start();
    }
}
