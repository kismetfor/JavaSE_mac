package network3;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 * TCP的特点：
 * 1. 有连接：TCP是面向连接的协议，通信前需要先建立连接，然后进行数据传输，传输完成后再关闭连接。
 * 和打电话一样需要客户端拨号 服务器来接听
 * 2. 可靠传输：TCP提供可靠的数据传输服务，通过序列号、确认和重传机制等技术确保数据的完整性和可靠性。
 * 3. 面向字节流：TCP是面向字节流的协议，它把数据看作是一个连续的字节流，不保留消息边界。
 * 4. 全双工：TCP连接是全双工的，客户端和服务器可以同时发送和接收数据，实现双向通信。
 */
public class TcpEchoServer {
    private ServerSocket serverSocket = null;
    public TcpEchoServer(int port) throws IOException {
        serverSocket = new ServerSocket();
    }

    public void start() throws IOException{
        System.out.println("服务器启动");
        while (true) {
            //accept接听电话 然后才能通信
            Socket clientSocket = serverSocket.accept();
            processConnection(clientSocket);
        }
    }

    //通过这个方法建立连接 连接建立的过程就会涉及到多次的相应交互
    private void processConnection(Socket clientSocket) throws IOException{
        System.out.printf("[%s %d] 客户端上线", clientSocket.getInetAddress(), clientSocket.getPort());
        //读取客户端的请求
            //TCP是面相字节流的.这里的字节流和文件中的字节流完全一致的.
            //使用和文件操作一样的类和方法完成针对 tcp socket的读写
            try(InputStream inputStream = clientSocket.getInputStream();
                OutputStream outputStream = clientSocket.getOutputStream()) {
                Scanner scanner = new Scanner(inputStream);
                while (true) {
                    if (!scanner.hasNext()) {
                        System.out.printf("[%s %d] 客户端下线 读取完毕",clientSocket.getInetAddress(), clientSocket.getPort());
                        break;
                    }
                    //1.读取请求并解析 next会读到空白符才会结束
                    //客户端发来的请求必须带有空白符作为结尾 比如\n或者空格
                    String request = scanner.next();
                    //2根据请求计算响应
                    String response = process(request);
                    //3.把响应返回给客户端
                    //这个方式不方便给返回的响应中添加换行符 \n
                    //  outputStream.write(response.getBytes(), 0, request.getBytes().length);
                    //套上一层 这里PrintWriter相当于输入的Scanner 把输入流包装一下 完成更方便的写入
                    //方便完成更方便的输出
                    PrintWriter printWriter = new PrintWriter(outputStream);
                    System.out.println(printWriter);

                    System.out.printf("[%s:%d] req: %s resp: %s", clientSocket.getInetAddress(),clientSocket.getPort(),
                            request, response);
                }
            } catch (IOException e) {
                throw new IOException(e);
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
