package network1;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.DatagramSocket;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class TcpEchoServer {
    private ServerSocket serverSocket  = null;

    public TcpEchoServer(int port) throws IOException {
        serverSocket = new ServerSocket(port);
    }
    public void start() throws IOException {
        System.out.println("服务器启动!!!!");
            Socket clientSocket = serverSocket.accept();
            processConnection(clientSocket);
            try (InputStream inputStream = clientSocket.getInputStream();
                 OutputStream outputStream = clientSocket.getOutputStream()){
                Scanner scanner = new Scanner(inputStream);
                while (true) {
                    if (!scanner.hasNext()) {
                        System.out.printf("[%s : %d] 客户端下线", clientSocket.getInetAddress(),
                                clientSocket.getPort());
                        break;
                    }
                    String request = scanner.next();
                    String response = process(request);
//                    outputStream.write(request.getBytes(), 0, request.getBytes().length);
                    PrintWriter printWriter = new PrintWriter(outputStream);
                    printWriter.println(response);
                    System.out.printf("[%s : %d] req: %s resp: %s ", clientSocket.getInetAddress(),
                            clientSocket.getPort(), response, response);
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
    }

    public String process(String request) {
        return request;
    }

    private void processConnection(Socket clientSocket) {
        System.out.printf("[%s : %d] 客户端上线", clientSocket.getInetAddress(),
                clientSocket.getPort());

    }

    public static void main(String[] args) throws IOException{
        TcpEchoServer server = new TcpEchoServer(9090);
        server.start();
    }
    //提交不上 只能出此下策
}
