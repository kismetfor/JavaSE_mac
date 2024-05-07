package network4;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class TcpEchoServer {

    private ServerSocket serverSocket = null;

    public TcpEchoServer(int port) throws IOException {
        serverSocket = new ServerSocket(port);
    }

    public void start() throws IOException{
        System.out.println("服务端启动");
        while (true) {
            Socket clientSocket = serverSocket.accept();
            Thread t = new Thread(()->{
                try {
                    processConnection(clientSocket);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            });
            t.start();
        }
    }

    private void processConnection(Socket clientSocket) throws IOException{
        System.out.printf("[%s : %d] 客户端上线", clientSocket.getInetAddress(), clientSocket.getPort());
        System.out.println();
        //接受请求
        try (InputStream inputStream = clientSocket.getInputStream();
             OutputStream outputStream = clientSocket.getOutputStream();
             ){
            Scanner scanner = new Scanner(inputStream);
            PrintWriter printWriter = new PrintWriter(outputStream);
            while (true) {
                if (!scanner.hasNext()) {
                    System.out.printf("[%s : %d] 客户端下线", clientSocket.getInetAddress(), clientSocket.getPort());
                    System.out.println();
                    break;
                }
                String request = scanner.next();
                String response = process(request);

                printWriter.println(response);
                printWriter.flush();
                System.out.printf("[%s : %d] req: %s resp: %s", clientSocket.getInetAddress(), clientSocket.getPort(),
                        request, response);
                System.out.println();
            }
        }
    }

    private String process(String request) {
        return request;
    }

    public static void main(String[] args) throws IOException{
        TcpEchoServer server = new TcpEchoServer(9090);
        server.start();
    }
}
