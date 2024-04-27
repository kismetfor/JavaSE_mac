package network2;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class UdpEchoServer {
    private DatagramSocket socket = null;

    public UdpEchoServer(int port) throws SocketException {
        socket = new DatagramSocket(port);
    }

    public void start() throws IOException {
        System.out.println("服务器启动");
        
        //1.接收数据
        DatagramPacket requestPacket = new DatagramPacket(new byte[4096], 4096);
        socket.receive(requestPacket);

        //2.处理数据---作为回应
        String request = new String(requestPacket.getData(), 0, requestPacket.getLength());
        String response = process(request);

        //3.返回数据
        DatagramPacket responsePacket = new DatagramPacket(response.getBytes(), response.getBytes().length,
                requestPacket.getSocketAddress());
        socket.send(responsePacket);
    }

    private String process(String request) {
        if (request.equals("吃了吗")) {
            return "吃了";
        } else {
            return "没吃";
        }

    }


    public static void main(String[] args) throws IOException {
        UdpEchoServer server = new UdpEchoServer(9090);
        server.start();
    }
}
